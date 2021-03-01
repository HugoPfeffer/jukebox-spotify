package br.com.cmms.services;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;

@ApplicationScoped
public class SongService {

    public ArrayList<Song> generateSongs(Playlist playlist) {
        return playlist.getSongs();
    }

}
