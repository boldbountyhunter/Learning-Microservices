package com.microservices.theatreservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class MovieTheatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long theatreId;

    private LocalTime timeOfShow;
    private LocalDate dateOfShow;
    private long totalSeats;
    private boolean isActive = true;
    private long movieId;

    private long movieTicketPrice;

    public MovieTheatre() {
    }

    public MovieTheatre(long id, long theatreId, LocalTime timeOfShow, LocalDate dateOfShow, long totalSeats, boolean isActive, long movieId, long movieTicketPrice) {
        this.id = id;
        this.theatreId = theatreId;
        this.timeOfShow = timeOfShow;
        this.dateOfShow = dateOfShow;
        this.totalSeats = totalSeats;
        this.isActive = isActive;
        this.movieId = movieId;
        this.movieTicketPrice = movieTicketPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getTimeOfShow() {
        return timeOfShow;
    }

    public void setTimeOfShow(LocalTime timeOfShow) {
        this.timeOfShow = timeOfShow;
    }

    public long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(long theatreId) {
        this.theatreId = theatreId;
    }

    public LocalDate getDateOfShow() {
        return dateOfShow;
    }

    public void setDateOfShow(LocalDate dateOfShow) {
        this.dateOfShow = dateOfShow;
    }

    public long getMovieTicketPrice() {
        return movieTicketPrice;
    }

    public void setMovieTicketPrice(long movieTicketPrice) {
        this.movieTicketPrice = movieTicketPrice;
    }

    @Override
    public String toString() {
        return "MovieTheatre{" +
                "id=" + id +
                ", theatreId=" + theatreId +
                ", timeOfShow=" + timeOfShow +
                ", dateOfShow=" + dateOfShow +
                ", totalSeats=" + totalSeats +
                ", isActive=" + isActive +
                ", movieId=" + movieId +
                ", movieTicketPrice=" + movieTicketPrice +
                '}';
    }
}
