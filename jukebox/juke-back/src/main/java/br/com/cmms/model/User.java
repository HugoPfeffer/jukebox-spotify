package br.com.cmms.model;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class User {

    public User() {
    }

    public User(long Id, String name, String email) {
    }

    private Long Id;
    private String name;
    private String email;
    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", email=" + email + ", name=" + name + ", playlists=" + playlists + "]";
    }
}
