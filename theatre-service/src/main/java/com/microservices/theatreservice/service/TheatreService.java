package com.microservices.theatreservice.service;

import com.microservices.theatreservice.model.Movie;
import com.microservices.theatreservice.entity.MovieTheatre;
import com.microservices.theatreservice.entity.Theatre;
import com.microservices.theatreservice.externalservice.MovieService;
import com.microservices.theatreservice.model.SeatMovieTheatre;
import com.microservices.theatreservice.repository.MovieTheatreRepository;
import com.microservices.theatreservice.repository.TheatreRepository;
import com.microservices.theatreservice.model.MovieTheatreDetails;
import com.microservices.theatreservice.model.TheatreDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TheatreService {

    private TheatreRepository theatreRepository;
    private MovieTheatreRepository movieTheatreRepository;
    private MovieService movieService;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository, MovieTheatreRepository movieTheatreRepository, MovieService movieService) {
        this.theatreRepository = theatreRepository;
        this.movieTheatreRepository = movieTheatreRepository;
        this.movieService = movieService;
    }

    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public TheatreDetails getTheatreById(long theatreIds) {
        return getTheatreDetailsFromTheatre(theatreRepository.findById(theatreIds).get());
    }

    public TheatreDetails getTheatreByTheatreIdAndMovieId(long theatreId, long movieId) {
        Theatre theatre = theatreRepository.findById(theatreId).get();
        theatre.setMovieTheatres(theatre.getMovieTheatres().stream().filter(movie -> movie.getMovieId() == movieId).collect(Collectors.toSet()));
        return getTheatreDetailsFromTheatre(theatre);
    }

    public TheatreDetails bookMovieSeatInTheatre(SeatMovieTheatre seatMovieTheatre) {
        MovieTheatre movieTheatre = movieTheatreRepository.findByTheatreIdAndMovieId(seatMovieTheatre.getTheatreId(), seatMovieTheatre.getMovieId());
        movieTheatre.setTotalSeats(movieTheatre.getTotalSeats()-seatMovieTheatre.getNoOfSeats());
        movieTheatreRepository.save(movieTheatre);
        return getTheatreByTheatreIdAndMovieId(seatMovieTheatre.getTheatreId(),seatMovieTheatre.getMovieId());
    }

    public TheatreDetails addMovieToTheatre(MovieTheatre movieTheatre) {
        Theatre theatre = theatreRepository.findById(movieTheatre.getTheatreId()).get();
        theatre.addMovieToTheatre(movieTheatre);
        return getTheatreDetailsFromTheatre(theatreRepository.save(theatre));
    }

    public List<TheatreDetails> getAllTheatre() {
        List<Theatre> theatreList = theatreRepository.findAll();
        return getListOfTheatreDetailsFromTheatreList(theatreList);
    }

    private List<TheatreDetails> getListOfTheatreDetailsFromTheatreList(List<Theatre> theatreList) {

        List<TheatreDetails> theatreDetailsList = new ArrayList<>();

        theatreList.forEach(theatre -> {
            TheatreDetails theatreDetails = getTheatreDetailsFromTheatre(theatre);
            theatreDetailsList.add(theatreDetails);
        });

        return theatreDetailsList;
    }

    public TheatreDetails getTheatreDetailsFromTheatre(Theatre theatre) {
        TheatreDetails theatreDetails = new TheatreDetails();
        theatreDetails.setName(theatre.getName());
        theatreDetails.setId(theatre.getId());
        List<Long> movieIds = theatre.getMovieTheatres().stream().map(MovieTheatre::getMovieId).collect(Collectors.toList());
        Map<Long, Movie> movieMap = movieService.getAllMoviesByIds(movieIds).stream().collect(Collectors.toMap(
                Movie::getId, Function.identity()
        ));

        Set<MovieTheatreDetails> movieTheatreDetails = new HashSet();

        theatre.getMovieTheatres().forEach(movieTheatre -> {
            Movie movie = movieMap.get(movieTheatre.getMovieId());
            movieTheatreDetails.add(new MovieTheatreDetails(movieTheatre.getMovieId(), movieTheatre.getTimeOfShow(), movieTheatre.getDateOfShow(),
                    movie.getDuration(), movieTheatre.getTotalSeats(), movie.getMovieName(), movieTheatre.getMovieTicketPrice()));
        });
        theatreDetails.setMovieTheatreDetails(movieTheatreDetails);
        return theatreDetails;
    }


}
