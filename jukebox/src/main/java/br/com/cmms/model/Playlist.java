package br.com.cmms.model;

public class Playlist {

    private Long Id;
    private String name;

    public Playlist(long Id, String name) {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

}
