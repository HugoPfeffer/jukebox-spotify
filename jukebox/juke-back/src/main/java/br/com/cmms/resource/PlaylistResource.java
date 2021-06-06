package br.com.cmms.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;
import br.com.cmms.services.PlaylistService;

@Path("/playlist")
public class PlaylistResource {

    @Inject
    PlaylistService playlistService;

    // List all Playlists
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public void listAllPlaylists() {
        playlistService.listAllPlaylists();
    }

    // List Playlist by ID
    @GET
    @Path("{playlistId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist getPlaylistById(@PathParam("playlistId") Long playlistId) {
        return playlistService.listPlaylistById(playlistId);
    }

    // List all Songs On Playlist
    @GET
    @Path("{playlistId}/songs")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> listAllSongsOnPlaylist(@PathParam("playlistId") Long playlistId) {
        return playlistService.listAllSongsOnPlaylist(playlistId);
    }

    // List Song By ID On Playlist
    @GET
    @Path("{playlistId}/song/{songId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Song listSongByIdOnPlaylist(@PathParam("playlistId") Long playlistId, @PathParam("songId") Long songId) {
        return playlistService.listSongByIdOnPlaylist(playlistId, songId);
    }

    // Insert new Playlist
    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertPlaylist(Playlist playlist) {
        playlistService.insertPlaylist(playlist);
    }

    // Insert Song on Playlist
    @POST
    @Transactional
    @Path("{playlistId}/song/{songId}")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertSongOnPlaylist(@PathParam("playlistId") Long playlistId, @PathParam("songId") Long songId) {
        playlistService.insertSongOnPlaylist(playlistId, songId);
    }

    // List Song By ID On Playlist
    @DELETE
    @Transactional
    @Path("{playlistId}/song/{songId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteSongByIdOnPlaylist(@PathParam("playlistId") Long playlistId, @PathParam("songId") Long songId) {
        playlistService.deleteSongByIdOnPlaylist(playlistId, songId);
    }

    // Delete Playlist by ID
    @DELETE
    @Transactional
    @Path("{playlistId}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlaylistById(@PathParam("playlistId") Long playlistId) {
        playlistService.deletePlaylistById(playlistId);
    }

}
