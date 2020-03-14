package nl.han.oose.dea.spotitube.controller;

import nl.han.oose.dea.spotitube.domain.PlaylistDomain;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistsController {
    private PlaylistDomain playlistDomain;

    @Inject
    public void setPlaylistDomain(PlaylistDomain playlistDomain) {
        this.playlistDomain = playlistDomain;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlaylists(@QueryParam("token") String token) {
        return Response.status(200).entity(playlistDomain.getPlaylistsDTO()).build();
    }

   /* @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@QueryParam("token") String token, @PathParam("id") int id) {
        playlistDomain.deletePlaylist(id);
    }*/

}
