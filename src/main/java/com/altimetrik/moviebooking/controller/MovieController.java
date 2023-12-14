package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Movie;
import com.altimetrik.moviebooking.service.IMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {


   private final IMovieService movieService;
   @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> createMovie(@RequestBody @Valid Movie movie){
            return movieService.createMovie(movie);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int movieId)
    {
        return movieService.getMovieById(movieId);
    }


    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return movieService.getAllMovies();
    }
    @GetMapping("/movies/release/{releaseDate}")
    public ResponseEntity<List<Movie>> getMovieByReleaseDate(@PathVariable LocalDate releaseDate)
    {
        return movieService.getMoviesByReleaseDate(releaseDate);
    }
    @GetMapping("/movies/actor/{actor}")
    public ResponseEntity<List<Movie>> getMoviesByActor(@PathVariable String actor)
    {
        return movieService.getAllMoviesOfActor(actor);
    }

    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre)
    {
        return movieService.getMoviesByGenre(genre);
    }
    @PutMapping("/movie/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer movieId,@RequestBody Movie movie){
       return movieService.updateMovie(movieId,movie);
    }

    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer movieId){
       return movieService.deleteMovie(movieId);
    }
}
