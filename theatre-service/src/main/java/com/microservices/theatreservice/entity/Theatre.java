package com.microservices.theatreservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "theatreId",cascade = CascadeType.ALL)
    private Set<MovieTheatre> movieTheatres = new HashSet<>();

    public Theatre() {
    }

    public Theatre(long id, String name, Set<MovieTheatre> movieTheatres) {
        this.id = id;
        this.name = name;
        this.movieTheatres = movieTheatres;
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

    public Set<MovieTheatre> getMovieTheatres() {
        return movieTheatres;
    }

    public void setMovieTheatres(Set<MovieTheatre> movieTheatres) {
        this.movieTheatres = movieTheatres;
    }
    public void addMovieToTheatre(MovieTheatre movieTheatre) {
        this.movieTheatres.add(movieTheatre);
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieTheatres=" + movieTheatres +
                '}';
    }
}
