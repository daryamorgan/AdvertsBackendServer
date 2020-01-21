package org.dzubairo.controller;

import org.dzubairo.model.Advert;
import org.dzubairo.model.Customer;
import org.dzubairo.service.CustomerService;
import org.dzubairo.service.AdvertService;

import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {
        Customer addedCustomer = CustomerService.addCustomer(customer);

        if (addedCustomer == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).entity(addedCustomer).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") int id) {
        Customer customer = CustomerService.getCustomer(id);

        if (customer == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(customer).build();
    }

    @GET
    @Path("{id}/adverts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerAdverts(@PathParam("id") int id) {
        Customer customer = CustomerService.getCustomer(id);

        if (customer == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Set<Advert> adverts = AdvertService.getAdvertsByCustomerId(customer.getId());

        if (adverts == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(200).entity(adverts).build();
    }
}

