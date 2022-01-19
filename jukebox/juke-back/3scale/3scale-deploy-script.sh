#!/bin/bash
project_name=$1
read -p ' Registry Username: ' registry_username
read -sp ' Registry Password: ' registry_pass

##### initial setup, cred for the cluster and project name.
      echo "What's the API Server?"
      read -p ' API Server: ' API_Server

      echo "What's the API Token?"
      read -sp ' Token: ' API_Token

      echo "What's the Cluster Domain?"
      read -p ' Domain: ' DOMAIN

oc create namespace $project_name > /dev/null 2>&1
oc project $project_name > /dev/null 2>&1

## create 3scale secret for the registry.
oc -n $project_name create secret \
  docker-registry threescale-registry-auth \
  --docker-server=registry.redhat.io \
  --docker-username=$registry_username \
  --docker-password=$registry_pass


##### create pvc and seed for 3scale
oc create -f pvc-storage.yaml
oc create -f seed.yaml

##### deploy the operator


cat <<EOF | oc create -n $project_name -f -
apiVersion: operators.coreos.com/v1
kind: OperatorGroup
metadata:
  name: jukefy-3scale-operatorgroup
  # namespace: jukefy
spec:
  targetNamespaces:
  - "$project_name"
EOF



oc create -f 3scale-sub.yaml -n $project_name
until oc get sub/jukefy-3scale-subscription >/dev/null 2>&1 ; do sleep 1 ; done


##### deploy api manager
# until oc create -f 3scale-apimanager.yaml -n $project_name >/dev/null 2>&1 ; do sleep 1 ; done 
# oc delete -f 3scale-apimanager.yaml -n $project_name >/dev/null 2>&1
# echo "Done!"

echo "Deploying 3Scale Operator..."
sleep 60;

cat <<EOF | oc create -n $project_name -f -
apiVersion: apps.3scale.net/v1alpha1
kind: APIManager
metadata:
 name: jukefy-apimanager
spec:
 wildcardDomain: "$DOMAIN"
 resourceRequirementsEnabled: false
EOF


##### deploy jukefy app on openshift
oc create -f mysql-deploy.yaml

cd ../

./mvnw clean package \
-Dquarkus.kubernetes-client.master-url=$API_Server \
-Dquarkus.kubernetes-client.token=$API_Token \
-Dquarkus.openshift.route.expose=true \
-Dquarkus.kubernetes.deploy=true

cd 3scale



echo '
________                        
\______ \   ____   ____   ____  
 |    |  \ /  _ \ /    \_/ __ \ 
 |    `   (  <_> )   |  \  ___/ 
/_______  /\____/|___|  /\___  >
        \/            \/     \/ '

oc get routes -n $project_name  