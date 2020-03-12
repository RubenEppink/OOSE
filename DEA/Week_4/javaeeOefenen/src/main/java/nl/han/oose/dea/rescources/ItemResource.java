package nl.han.oose.dea.rescources;

import nl.han.oose.dea.rescources.services.ItemService;
import nl.han.oose.dea.rescources.services.dto.ItemDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("items")
public class ItemResource {

    @Inject
    ItemService itemService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTextItems() {
        return "Bread and butter";
    }

    @Path("itemlijst")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemDTO> getJSONItems() {
        return itemService.getAll();
    }

    @Path("response")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSONItemsResponse() {
        return Response.status(200).entity(itemService.getAll()).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSONItemsById(@PathParam("id") int id) {
        return Response.status(200).entity(itemService.getItem(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postItem(ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return Response.status(201).entity("succes").build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response postItem(@PathParam("id") int id) {
        itemService.deleteItem(id);
        return Response.status(200).entity("item verwijderd").build();
    }

}
