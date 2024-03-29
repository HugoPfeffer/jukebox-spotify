<div id="top"></div>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
<!-- [![LinkedIn][linkedin-shield]][linkedin-url] -->



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://www.vectorlogo.zone/logos/3scalenet/3scalenet-icon.svg">
    <img src="https://www.vectorlogo.zone/logos/3scalenet/3scalenet-icon.svg" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Jukefy + 3Scale</h3>

  <p align="center">
    Implementing Jukefy with 3Scale APIManager
    <br />
    <a href="https://github.com/HugoPfeffer/jukebox-spotify"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    ·
    <a href="https://github.com/HugoPfeffer/jukebox-spotify/issues">Report Bug</a>
    ·
    <a href="https://github.com/HugoPfeffer/jukebox-spotify/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#Integration with 3Scale">Integration with 3Scale</a></li>
    <li><a href="#Product">Product</a></li>
    <li><a href="#Backend">Backend</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#Audiance">Audiance</a></li>
    <li><a href="#Final Steps">Final Steps</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is a guide on how to deploy 3Scale on OpenShift and integrate the APICast with Jukefys Backend API. 

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [OpenShift](https://www.redhat.com/en/technologies/cloud-computing/openshift) 
* [Red Hat 3Scale](https://www.redhat.com/en/technologies/jboss-middleware/3scale) 
* [Quarkus](https://quarkus.io/) 

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

For this project you we will be deploying 3Scale on OpenShift with the built-in 3Scale Operator from OpenShift

For instructions on how to deploy 3Scale on OpenShift, please refer to [Vinicius Martinez](https://github.com/vinicius-martinez) guide.

* [OpenShift Setup](https://github.com/redhat-sa-brazil/3scale-workshop/blob/master/OPENSHIFT_SETUP.md)
* [3Scale Setup](https://github.com/redhat-sa-brazil/3scale-workshop/blob/master/3SCALE_SETUP.md)


Or you can use the ```3scale-deploy-script.sh``` for the deployment of 3scale alongside the Jukefy app. 
```sh
./3scale-deploy-script.sh <project-name>
```

### Prerequisites

* OpenShift 4.8 Cluster
* 3Scale 2.11

<p align="right">(<a href="#top">back to top</a>)</p>

## Integration with 3Scale
This module will cover how to integrate Jukefy backend API with 3Scale API Gateway. 

### Product

1. Create a product with the names and system-name
* Name: **Jukefy API**
* System Name: **jukefy-api**
* Description: **Managed API by 3scale**

![API Manager Deploy](images/3scale-4.png)
![API Manager Deploy](images/3scale-3.png)

2. Add metrics to that product

**METHOD**
* Name: **List User Playlist**
* System Name: **userListPlaylist**
* Description: **List User Playlist**

_*We can use the default Hit Metric*_

`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Method`
`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Metrics`
![API Manager Deploy](images/3scale-1.png)

3. Add Mapping Rules to that product
`Go to Jukefy product page -> Integration -> Mapping Rules -> Create Mapping rule`

![API Manager Deploy](images/3scale-5.png)
![API Manager Deploy](images/3scale-9.png)
    *Add Mapping Rules for all metrics and methods we created.*

4. Add an Application Plan for your managed API

`Go to Jukefy product page -> Applications -> Application Plan -> Create Application Plan`

**Application Plan**
* Name: **JukePlan**
* System Name: **jukeplan**

![API Manager Deploy](images/3scale-7.png)

    *Feel free to add custom billings to the API*

<p align="right">(<a href="#top">back to top</a>)</p>

### Backend

1. Create a backend API to serve the APICast.

`Top Left Dropdown -> Backends -> Create Backend`

![API Manager Deploy](images/3scale-10.gif)

2. Apply the same Methods and Metrics to the Backend the same way we did on Products

`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Method`
`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Metrics`

3. Apply the same Mapping Rules to the Backend the same way we did on Products
`Go to Jukefy product page -> Integration -> Mapping Rules -> Create Mapping rule`
 
### Audiance

1. Add developer accounts and account plans so we can bill and analyse usage metrics. 

`Top Left Dropdown -> Audiance -> Create`

* Organizations/Group: Jukefy
* Username: your-name
* Email: your-email
* Password: your-password

![API Manager Deploy](images/3scale-12.gif)

2. Add an application to that Account
`Account Overview -> left menu -> Applications -> Listing -> Create Application`

![API Manager Deploy](images/3scale-13.gif)

    Select the Product, Application Plan and the Account we created

### Final Steps

1. Connect Backend API with the Product we created
`Top left dropdown -> Products -> Select Jukefy -> Integration -> Backends -> Add Backend`

![API Manager Deploy](images/3scale-14.gif)

2. Stage thoses changes and push it live for you to start consuming the API through 3scale. 

`Product Overview -> Configurations -> Promote Changes`

![API Manager Deploy](images/3scale-15.png)

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Hugo Pfeffer - hugo.pguima@gmail.com

Gustavo Gianini - ggianini@gmail.com

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[contributors-url]: https://github.com/HugoPfeffer/jukebox-spotify/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[forks-url]: https://github.com/HugoPfeffer/jukebox-spotify/network/members
[stars-shield]: https://img.shields.io/github/stars/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[stars-url]: https://github.com/HugoPfeffer/jukebox-spotify/stargazers
[issues-shield]: https://img.shields.io/github/issues/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[issues-url]: https://github.com/HugoPfeffer/jukebox-spotify/issues
[license-shield]: https://img.shields.io/github/license/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[license-url]: https://github.com/HugoPfeffer/jukebox-spotify/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
