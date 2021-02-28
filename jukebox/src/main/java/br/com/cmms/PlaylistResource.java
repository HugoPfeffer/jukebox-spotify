package br.com.cmms;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.User;
import br.com.cmms.services.PlaylistService;
import br.com.cmms.services.UserService;

@Path("/playlists")
public class PlaylistResource {

    @Inject
    private PlaylistService playlistService;
    private UserService userService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    /*public ArrayList<Playlist> getAllPlaylists() {
        return playlistService.generatePlaylist(userService.generateUser());
    }
    */
    public User getUser() {
        return userService.generateUser();
    }

}