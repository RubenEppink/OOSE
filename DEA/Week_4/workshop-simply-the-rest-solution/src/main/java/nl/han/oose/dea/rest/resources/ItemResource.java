package nl.han.oose.dea.rest.resources;

import nl.han.oose.dea.rest.services.HardcodedItemService;
import nl.han.oose.dea.rest.services.ItemService;
import nl.han.oose.dea.rest.services.dto.ItemDTO;

import javax.inject.Inject;
import javax.mail.FetchProfile;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items")
public class ItemResource {
    ItemService hardcodedItemService;

    @Inject
    public void setItemService(ItemService hardcodedItemService) {
        this.hardcodedItemService = hardcodedItemService;
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTextItems() {
        return "bread, butter";
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJsonItems() {
//        return "[\"bread\", \"butter\"]";
//    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ItemDTO> getJsonItems() {
//        return itemService.getAll();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonItems() {
        return Response.ok().entity(hardcodedItemService.getAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(ItemDTO itemDTO) {
        hardcodedItemService.addItem(itemDTO);

        return Response.status(201).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("id") int id) {
        return Response.ok().entity(hardcodedItemService.getItem(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") int id) {
        hardcodedItemService.deleteItem(id);
        return Response.ok().build();
    }
}
