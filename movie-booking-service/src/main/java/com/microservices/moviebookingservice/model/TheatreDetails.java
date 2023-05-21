package com.microservices.moviebookingservice.model;

import java.util.HashSet;
import java.util.Set;

public class TheatreDetails {
    private long id;

    private String name;

    private Set<MovieTheatreDetails> movieTheatreDetails = new HashSet<>();

    public TheatreDetails() {
    }

    public TheatreDetails(long id, String name, Set<MovieTheatreDetails> movieTheatreDetails) {
        this.id = id;
        this.name = name;
        this.movieTheatreDetails = movieTheatreDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MovieTheatreDetails> getMovieTheatreDetails() {
        return movieTheatreDetails;
    }

    public void setMovieTheatreDetails(Set<MovieTheatreDetails> movieTheatreDetails) {
        this.movieTheatreDetails = movieTheatreDetails;
    }
}
