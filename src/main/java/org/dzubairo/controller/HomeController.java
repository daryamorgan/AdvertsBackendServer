package org.dzubairo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HomeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHomePage() {
        String output = "Welcome to classified advertisements REST API Server";
        return Response.status(200).entity(output).build();
    }
}