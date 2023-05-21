package com.microservices.theatreservice.model;

public class Movie {

    private long id;

    private String movieName;
    private long duration;

    public Movie() {
    }

    public Movie(long id, String movieName, long duration) {
        this.id = id;
        this.movieName = movieName;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
