package com.microservices.moviebookingservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class TicketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private long paymentId;
    private long movieId;
    private long theatreId;
    private LocalTime timeOfBooking;
    private long noOfSeats;

    public TicketDetails() {
    }

    public TicketDetails(long id, long userId, long paymentId, long movieId, long theatreId, LocalTime timeOfBooking, long noOfSeats) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.timeOfBooking = timeOfBooking;
        this.noOfSeats = noOfSeats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
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

    @Override
    public String toString() {
        return "TicketDetails{" +
                "id=" + id +
                ", userId=" + userId +
                ", paymentId=" + paymentId +
                ", movieId=" + movieId +
                ", theatreId=" + theatreId +
                ", timeOfBooking=" + timeOfBooking +
                ", noOfSeats=" + noOfSeats +
                '}';
    }
}
