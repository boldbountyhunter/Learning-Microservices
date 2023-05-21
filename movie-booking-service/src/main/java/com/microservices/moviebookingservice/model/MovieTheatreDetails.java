package com.microservices.moviebookingservice.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieTheatreDetails {


    private long id;
    private LocalTime timeOfShow;
    private LocalDate dateOfShow;
    private long duration;
    private long totalSeats;
    private String movieName;

    private long movieTicketPrice;

    public MovieTheatreDetails() {
    }

    public MovieTheatreDetails(long id, LocalTime timeOfShow, LocalDate dateOfShow, long duration, long totalSeats, String movieName, long movieTicketPrice) {
        this.id = id;
        this.timeOfShow = timeOfShow;
        this.dateOfShow = dateOfShow;
        this.duration = duration;
        this.totalSeats = totalSeats;
        this.movieName = movieName;
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

    public LocalDate getDateOfShow() {
        return dateOfShow;
    }

    public void setDateOfShow(LocalDate dateOfShow) {
        this.dateOfShow = dateOfShow;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public long getMovieTicketPrice() {
        return movieTicketPrice;
    }

    public void setMovieTicketPrice(long movieTicketPrice) {
        this.movieTicketPrice = movieTicketPrice;
    }

}
