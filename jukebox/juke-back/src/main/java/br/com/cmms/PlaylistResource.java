package br.com.cmms;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cmms.db.userDatabase;
import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;
import br.com.cmms.model.User;
import br.com.cmms.services.PlaylistService;
import br.com.cmms.services.SongService;
import br.com.cmms.services.UserService;

@Path("/jukebox")
public class PlaylistResource {


    @Inject
    private PlaylistService playlistService;
    @Inject
    private SongService songService;
    @Inject
    private UserService userService;

    @GET
    @Path("/playlist")
    @Produces(MediaType.APPLICATION_JSON)

    public ArrayList<Playlist> getAllPlaylists() {
        return playlistService.generatePlaylists(userService.generateUsers());
    }

    @GET
    @Path("/playlist/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Playlist getPlaylistById(@PathParam("id") int id) {
        return playlistService.generatePlaylists(userService.generateUsers()).get(id);
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public User getUserById(@PathParam("id") int id) {
        return userDatabase.getUsers().get(id);
    }

    @Path("/user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getAllUsers() {
        return userDatabase.getUsers();
    }

    @GET
    @Path("/song/{playlistId}")
    @Produces(MediaType.APPLICATION_JSON)

    public ArrayList<Song> getSongsByPlaylistId(@PathParam("playlistId") int playlistId) {
        return songService.generateSongs(playlistService.generatePlaylists(userService.generateUsers()).get(playlistId));
    }

}