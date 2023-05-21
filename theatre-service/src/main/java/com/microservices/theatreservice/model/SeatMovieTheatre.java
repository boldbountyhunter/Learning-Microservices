package com.microservices.theatreservice.model;

public class SeatMovieTheatre {

    private long noOfSeats;
    private long theatreId;
    private long movieId;

    public SeatMovieTheatre() {
    }

    public SeatMovieTheatre(long noOfSeats, long theatreId, long movieId) {
        this.noOfSeats = noOfSeats;
        this.theatreId = theatreId;
        this.movieId = movieId;
    }

    public long getNoOfSeats() {
        return noOfSeats;
    }

    public long getTheatreId() {
        return theatreId;
    }

    public long getMovieId() {
        return movieId;
    }
}
