package br.com.cmms.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;

@ApplicationScoped
public class SongService {

    public List<Song> generateSongs(Playlist playlist) {
        return playlist.getSongs();
    }

}
