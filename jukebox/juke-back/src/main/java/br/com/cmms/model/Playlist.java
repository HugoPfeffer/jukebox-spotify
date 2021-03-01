package br.com.cmms.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private Long id;
    private String name;
    private List<Song> songs = new ArrayList<>();

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + ", name=" + name + "]";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

}
