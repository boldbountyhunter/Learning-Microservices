package com.microservices.theatreservice.externalservice;

import com.microservices.theatreservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MOVIE-SERVICE")
public interface MovieService {

    @PostMapping("/movie/movie-by-ids")
    List<Movie> getAllMoviesByIds(@RequestBody List<Long> movieIds);
}
