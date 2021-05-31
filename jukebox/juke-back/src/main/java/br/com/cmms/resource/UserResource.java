package br.com.cmms.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cmms.model.User;
import br.com.cmms.services.UserService;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @PermitAll
    @Transactional
    @Consumes
    public void insertUser(User user){
        userService.insertUser(user);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public void listAllUsers(){
        userService.listAllUsers();
    }
    
    @GET
    @Path("/user/{userId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") Long userId) {
        return userService.listUserById(userId);
    }

}
