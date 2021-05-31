package br.com.cmms.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cmms.model.Playlist;
import br.com.cmms.services.PlaylistService;

@Path("/Playlist")
public class PlaylistResource {

    @Inject
    PlaylistService PlaylistService;

    @POST
    @PermitAll
    @Transactional
    @Consumes
    public void insertPlaylist(Playlist Playlist){
        PlaylistService.insertPlaylist(Playlist);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public void listAllPlaylists(){
        PlaylistService.listAllPlaylists();
    }
    
    @GET
    @Path("/Playlist/{PlaylistId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist getPlaylistById(@PathParam("PlaylistId") Long PlaylistId) {
        return PlaylistService.listPlaylistById(PlaylistId);
    }

}
