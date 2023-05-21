package com.microservices.theatreservice.resource;

import com.microservices.theatreservice.entity.MovieTheatre;
import com.microservices.theatreservice.entity.Theatre;
import com.microservices.theatreservice.model.SeatMovieTheatre;
import com.microservices.theatreservice.model.TheatreDetails;
import com.microservices.theatreservice.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("")
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        return new ResponseEntity<>(theatreService.addTheatre(theatre), HttpStatus.ACCEPTED);
    }

    @GetMapping("")
    public ResponseEntity<List<TheatreDetails>> getAllTheatre() {
        return new ResponseEntity<>(theatreService.getAllTheatre(),HttpStatus.OK);
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<TheatreDetails> getTheatreById(@PathVariable long theatreId) {
        return new ResponseEntity<>(theatreService.getTheatreById(theatreId),HttpStatus.OK);
    }

    @PostMapping("/add-movie-to-theatre")
    public ResponseEntity<TheatreDetails> addMovieToTheatre(@RequestBody MovieTheatre movieTheatre) {
        return new ResponseEntity<>(theatreService.addMovieToTheatre(movieTheatre), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{theatreId}/movie/{movieId}")
    public ResponseEntity<TheatreDetails> getTheatreByTheatreIdAndMovieId(@PathVariable long theatreId,@PathVariable long movieId) {
        return new ResponseEntity<>(theatreService.getTheatreByTheatreIdAndMovieId(theatreId,movieId),HttpStatus.OK);
    }

    @PostMapping("/book-seat")
    public ResponseEntity<TheatreDetails> bookSeat(@RequestBody SeatMovieTheatre seatMovieTheatre) {
        return new ResponseEntity<>(theatreService.bookMovieSeatInTheatre(seatMovieTheatre), HttpStatus.ACCEPTED);
    }

}
