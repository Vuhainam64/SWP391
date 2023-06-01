package com.hainam.petstore.resource.v1;

import com.hainam.petstore.dao.FeedbackDao;
import com.hainam.petstore.dto.Feedback;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("v1/feedback")
public class FeedbackResource {

    private FeedbackDao feedbackDao = FeedbackDao.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFeedback(Feedback feedback) {
        feedbackDao.createFeedback(feedback);
        URI uri = UriBuilder.fromPath("v1/feedback/{id}").resolveTemplate("id", feedback.getFeedbackId()).build();
        return Response.created(uri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }
}
