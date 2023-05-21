package com.microservices.theatreservice.repository;

import com.microservices.theatreservice.entity.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTheatreRepository extends JpaRepository<MovieTheatre, Long> {

    public MovieTheatre findByTheatreIdAndMovieId(long theatreId, long movieId);

}
