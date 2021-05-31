package br.com.cmms.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;
import br.com.cmms.repository.SongRepository;

@ApplicationScoped
public class SongService {

    @Inject
    SongRepository songRepository;

    public List<Song> ListAllSongs() {
        return songRepository.listAll();
    }

    public List<Song> ListSongsByPlaylist(Playlist playlist){
        return songRepository.list("playlist", playlist);
    }
}

