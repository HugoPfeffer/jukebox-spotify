package br.com.cmms.model;

import java.util.ArrayList;

public class Playlist {

    private Long Id;
    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Long getId() {
        return Id;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Playlist [Id=" + Id + ", name=" + name + "]";
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

}
