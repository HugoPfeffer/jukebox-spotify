package br.com.cmms.services;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.User;

@ApplicationScoped
public class PlaylistService {

    public ArrayList<Playlist> generatePlaylist(User user) {
        return user.getPlaylists();
    }

}
