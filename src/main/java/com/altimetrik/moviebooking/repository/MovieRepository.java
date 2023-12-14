package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Optional<List<Movie>> findByGenre(String genre);

    Optional<List<Movie>> findByReleaseDate(LocalDate releaseDate);
    default Optional<Movie> deleteAndGetById(Integer movieId) {
        Optional<Movie> optionalMovie = findById(movieId);
        optionalMovie.ifPresent(this::delete);
        return optionalMovie;
    }


}
