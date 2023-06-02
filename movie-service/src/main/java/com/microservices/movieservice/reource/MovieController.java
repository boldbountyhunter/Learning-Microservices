package com.microservices.movieservice.reource;

import com.microservices.movieservice.entity.Movie;
import com.microservices.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable long movieId) {
        return new ResponseEntity<>(movieService.getMovieById(movieId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.ACCEPTED);
    }

    @PostMapping("/movie-by-ids")
    public ResponseEntity<List<Movie>> findAllMovieByIds(@RequestBody List<Long> movieIds) {
        return new ResponseEntity<>(movieService.findAllMovieByIds(movieIds), HttpStatus.ACCEPTED);
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovie() {
        return new ResponseEntity<>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteMovie(@PathVariable long movieId) {
        return new ResponseEntity<>(movieService.deleteMovieById(movieId), HttpStatus.OK);
    }
}
