package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,String> {

    List<Movie> findByGenre(String genre);

    List<Movie> findByReleaseDate(LocalDate releaseDate);

    boolean existsByMovieTitle(String title);
    List<Movie> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);




}
