package br.com.cmms.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
    public List<Song> listAllSongsOnPlaylist(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId);
        return playlist.getSongsList();
    }

    // List Song By ID On Playlist
    public Song listSongByIdOnPlaylist(Long playlistId, Long songId) {
        Song songFound = null;
        Playlist playlist = playlistRepository.findById(playlistId);
        Song wantedSong = songRepository.findById(songId);
        List<Song> list = playlist.getSongsList();
        if (list.contains(wantedSong)) {
            songFound = wantedSong;
        } else {
            throw new NoSuchElementException("This song doesn't exist on this playlist.");
        }
        return songFound;
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
            playlistRepository.persist(playlist);
        } else
            throw new IllegalArgumentException("This song already exists on this playlist.");
    }

    // Delete Song By ID On Playlist
    public void deleteSongByIdOnPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId);
        Song wantedSong = songRepository.findById(songId);
        List<Song> list = playlist.getSongsList();
        if (list.contains(wantedSong)) {
            list.remove(wantedSong);
            playlistRepository.flush();
        } else {
            throw new NoSuchElementException("This song doesn't exist on this playlist.");
        }
    }

    // Delete Playlist By ID
    public void deletePlaylistById(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId);
        playlistRepository.delete(playlist);
    }



}
