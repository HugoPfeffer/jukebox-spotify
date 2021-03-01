package br.com.cmms.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.User;

@ApplicationScoped
public class PlaylistService {

    public List<Playlist> generatePlaylists(User user) {
        return user.getPlaylists();
    }

}
