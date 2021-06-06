package br.com.cmms.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.cmms.model.Song;
import br.com.cmms.repository.SongRepository;

@ApplicationScoped
public class SongService {

    @Inject
    SongRepository songRepository;

    // List all Songs
    public List<Song> listAllSongs() {
        return songRepository.listAll();
    }

    // List Song by ID
    public Song listSongById(Long songId) {
        return songRepository.findById(songId);
    }

    // Insert new Song
    public void insertSong(Song song) {
        songRepository.persist(song);
    }

}

