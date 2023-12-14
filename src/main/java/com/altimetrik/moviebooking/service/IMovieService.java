package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Movie;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IMovieService {

    ResponseEntity<Movie> createMovie(Movie movie);
    ResponseEntity<Movie> getMovieById(Integer movieId);
    ResponseEntity<List<Movie>> getAllMovies();
    ResponseEntity<List<Movie>> getAllMoviesOfActor(String actor);
    ResponseEntity<List<Movie>> getMoviesByGenre(String genre);
    ResponseEntity<List<Movie>> getMoviesByReleaseDate(LocalDate releaseDate);
    ResponseEntity<Movie> updateMovie(Integer movieId, Movie movie);
    ResponseEntity<Movie> deleteMovie(Integer movieId);
}
