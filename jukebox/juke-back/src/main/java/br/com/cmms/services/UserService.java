package br.com.cmms.services;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.User;

@ApplicationScoped
public class UserService {

    public User generateUser() {
    User ggianini = new User();
    ggianini.setId(1L);
    ggianini.setName("Gustavo Gianini");
    ggianini.setEmail("ggianini@gmail.com");
    ggianini.getPlaylists().add(new Playlist(1L, "mpb"));
    ggianini.getPlaylists().add(new Playlist(2L, "rock"));
    return ggianini;
    }
}
