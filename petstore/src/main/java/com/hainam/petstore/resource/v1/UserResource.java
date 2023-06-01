package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dao.UserDao;
import com.hainam.petstore.dto.User;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("v1/user")
public class UserResource {

    private UserDao userDao = UserDao.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        userDao.createUser(user);
        URI uri = UriBuilder.fromPath("v1/user/{id}").resolveTemplate("id", user.getUserID()).build();
        return Response.created(uri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int userId) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int userId, User updatedUser) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            updatedUser.setUserID(userId);
            userDao.updateUser(updatedUser);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int userId) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            userDao.deleteUser(userId);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
