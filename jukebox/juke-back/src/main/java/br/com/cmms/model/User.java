package br.com.cmms.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class User {

    public User() {
    }

    public User(long id, String name, String email) {
    }

    private Long id;
    private String name;
    private String email;
    private List<Playlist> playlists = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public String toString() {
        return "User [Id=" + id + ", email=" + email + ", name=" + name + ", playlists=" + playlists + "]";
    }
}
