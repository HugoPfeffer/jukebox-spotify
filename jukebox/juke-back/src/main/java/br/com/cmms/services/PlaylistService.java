package br.com.cmms.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.lang.model.util.ElementScanner6;

import br.com.cmms.model.Playlist;
import br.com.cmms.model.Song;
import br.com.cmms.repository.PlaylistRepository;
import br.com.cmms.repository.SongRepository;

@ApplicationScoped
public class PlaylistService {

    @Inject
    PlaylistRepository playlistRepository;

    @Inject
    SongRepository songRepository;

    // List all Playlists
    public List<Playlist> listAllPlaylists() {
        return playlistRepository.listAll();
    }

    // List Playlist by ID
    public Playlist listPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId);
    }

    // List Songs On Playlist
    public List<Song> listAllSongsOnPlaylist(Playlist playlist) {
        return songRepository.list("playlist", playlist);
    }

    // List Songs By ID On Playlist ARRUMAR SAPORRA
    public Song listSongByIdOnPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId);
        Song song = songRepository.findById(songId);
        List<Song> list = songRepository.list("playlist", playlist);
        for (Song songFound : list) {
            if (songFound.equals(song)) {
                return songFound;
            } else {
                throw new NoSuchElementException("This song doen't exist on this playlist");
            }
        }
        return null;
    }

    // Insert new Playlist
    public void insertPlaylist(Playlist playlist) {
        playlistRepository.persist(playlist);
    }

    // Insert Song on Playlist
    public void insertSongOnPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId);
        Song song = songRepository.findById(songId);
        List<Song> list = playlist.getSongsList();
        if (!list.contains(song)) {
            list.add(song);
            playlistRepository.persist(playlistRepository.findById(playlistId));
        } else
            throw new IllegalArgumentException("This song already exists on this playlist.");
    }

}
