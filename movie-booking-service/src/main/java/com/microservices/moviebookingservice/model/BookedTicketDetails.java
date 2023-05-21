package com.microservices.moviebookingservice.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookedTicketDetails {

    private long ticketId;
    private long userId;
    private long ticketAmount;
    private String movieName;
    private long movieDuration;
    private String theatreName;
    private LocalTime timeOfShow;
    private LocalDate dateOfShow;
    private LocalTime timeOfBooking;
    private long noOfSeats;

    public BookedTicketDetails() {
    }

    public BookedTicketDetails(long ticketId, long userId, long ticketAmount, String movieName, long movieDuration, String theatreName, LocalTime timeOfShow, LocalDate dateOfShow, LocalTime timeOfBooking, long noOfSeats) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.ticketAmount = ticketAmount;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.theatreName = theatreName;
        this.timeOfShow = timeOfShow;
        this.dateOfShow = dateOfShow;
        this.timeOfBooking = timeOfBooking;
        this.noOfSeats = noOfSeats;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(long ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public long getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(long movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public LocalTime getTimeOfShow() {
        return timeOfShow;
    }

    public void setTimeOfShow(LocalTime timeOfShow) {
        this.timeOfShow = timeOfShow;
    }

    public LocalTime getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(LocalTime timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public LocalDate getDateOfShow() {
        return dateOfShow;
    }

    public void setDateOfShow(LocalDate dateOfShow) {
        this.dateOfShow = dateOfShow;
    }

    @Override
    public String toString() {
        return "BookedTicketDetails{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", ticketAmount=" + ticketAmount +
                ", movieName='" + movieName + '\'' +
                ", movieDuration=" + movieDuration +
                ", theatreName='" + theatreName + '\'' +
                ", timeOfShow=" + timeOfShow +
                ", dateOfShow=" + dateOfShow +
                ", timeOfBooking=" + timeOfBooking +
                ", noOfSeats=" + noOfSeats +
                '}';
    }
}