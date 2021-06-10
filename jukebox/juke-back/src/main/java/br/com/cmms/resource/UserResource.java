package br.com.cmms.resource;

import java.util.List;

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

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.cmms.model.User;
import br.com.cmms.services.UserService;

@Path("/user")
@Tag(name = "User")
public class UserResource {

    @Inject
    UserService userService;

    // List all Users
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    // List User by ID
    @GET
    @Path("{userId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") Long userId) {
        return userService.listUserById(userId);
    }

    // Insert new User
    @POST
    @PermitAll
    @Transactional
    @Consumes
    public void insertUser(User user) {
        userService.insertUser(user);
    }

}
