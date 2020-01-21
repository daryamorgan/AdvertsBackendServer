package org.dzubairo.controller;

import org.dzubairo.model.Advert;
import org.dzubairo.service.AdvertService;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/adverts")
public class AdvertController  {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAdvert(Advert advert) {
        Advert addedAdvert = AdvertService.addAdvert(advert);

        if (addedAdvert == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).entity(addedAdvert).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvert(@PathParam("id") int id) {
        Advert advert = AdvertService.getAdvert(id);

        if (advert == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(advert).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdverts() {
        Set<Advert> adverts = AdvertService.getAllAdverts();

        if (adverts == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(adverts).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeAdvert(@PathParam("id") int id) {
        boolean result = AdvertService.removeAdvert(id);

        if (!result) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(204).build();
    }
}
