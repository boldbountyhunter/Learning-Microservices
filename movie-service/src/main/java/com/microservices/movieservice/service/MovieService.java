package com.microservices.movieservice.service;

import com.microservices.movieservice.entity.Movie;
import com.microservices.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(long movieID) {
        return movieRepository.findById(movieID).get();
    }

    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    public String deleteMovieById(long movieId) {
        movieRepository.deleteById(movieId);
        return "Movie deleted..!!";
    }

    public List<Movie> findAllMovieByIds(List<Long> movieIds) {
        return movieRepository.findAllByIdIn(movieIds);
    }
}
