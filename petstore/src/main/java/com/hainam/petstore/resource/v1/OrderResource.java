package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dao.OrderDao;
import com.hainam.petstore.dto.Order;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("v1/order")
public class OrderResource {

    private OrderDao orderDao = OrderDao.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Order order) {
        orderDao.createOrder(order);
        URI uri = UriBuilder.fromPath("v1/order/{id}").resolveTemplate("id", order.getItemID()).build();
        return Response.created(uri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int itemID) {
        Order order = orderDao.getOrderById(itemID);
        if (order != null) {
            return Response.ok(order).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrder(@PathParam("id") int itemID, Order updatedOrder) {
        Order order = orderDao.getOrderById(itemID);
        if (order != null) {
            updatedOrder.setItemID(itemID);
            orderDao.updateOrder(updatedOrder);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") int itemID) {
        Order order = orderDao.getOrderById(itemID);
        if (order != null) {
            orderDao.deleteOrder(itemID);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
