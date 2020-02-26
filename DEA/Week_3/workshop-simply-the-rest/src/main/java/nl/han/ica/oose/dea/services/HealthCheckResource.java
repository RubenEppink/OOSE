package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dto.ItemDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/health")
public class HealthCheckResource {
    ItemService itemService;

    public HealthCheckResource() {
        itemService = new ItemService();
    }

    @GET
    public String healthy() {
        return "Up & Running";
    }

    @GET
    @Path("/items")
    @Produces("text/plain")
    public String retrieveItems() {
        return "bread, butter";
    }

    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveItemsAsJson() {
        return Response
                .status(200)
                .entity(itemService.getAll())
                .build();
    }


    @Path("{id}")
    @GET
    @Produces("application/json")
    public Response getItemById(@PathParam("id") int id) {
        return Response
                .status(200)
                .entity(itemService.getItem(id))
                .build();
    }

    @Path("/xd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @POST
    public String postItem(ItemDTO itemDTO) {
        itemService.addItem(itemDTO);

        return "Gelukt";
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteItem(@PathParam("id") int id) {
        itemService.deleteItem(id);
        return "verwijderd!";
    }

}
