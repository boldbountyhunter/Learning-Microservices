package com.microservices.moviebookingservice.externalService;

import com.microservices.moviebookingservice.model.SeatMovieTheatre;
import com.microservices.moviebookingservice.model.TheatreDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "THEATRE-SERVICE")
public interface TheatreService {

    @PostMapping("/theatre/book-seat")
    public TheatreDetails bookSeat(@RequestBody SeatMovieTheatre seatMovieTheatre);

    @GetMapping("/theatre/{theatreId}/movie/{movieId}")
    public TheatreDetails getTheatreByTheatreIdAndMovieId(@PathVariable long theatreId, @PathVariable long movieId);

}
