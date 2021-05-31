package br.com.cmms.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.cmms.model.Playlist;
import br.com.cmms.repository.PlaylistRepository;

@ApplicationScoped
public class PlaylistService {

    @Inject
    PlaylistRepository playlistRepository;

    public List<Playlist> listAllPlaylists() {
        return playlistRepository.listAll();
    }

    public void insertPlaylist(Playlist playlist) {
        playlistRepository.persist(playlist);
    }

    public Playlist listPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId);
    }

}
