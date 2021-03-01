package br.com.cmms.model;

public class Song {

    private Long id;
    private String name;
    private String author;
    private int duration;
    private int votes;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void vote() {
        votes++;
    }

    public void removeVote() {
        if (votes >= 0)
            votes--;
    }

    @Override
    public String toString() {
        return "Song [Id=" + id + ", author=" + author + ", duration=" + duration + ", name=" + name + ", votes="
                + votes + "]";
    }

}
