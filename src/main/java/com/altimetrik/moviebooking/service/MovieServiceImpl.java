package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Movie;
import com.altimetrik.moviebooking.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService{

    private final MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);


    @Override
    public ResponseEntity<Movie> createMovie(Movie movie) {
        logger.info("uploading a new movie..");
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    @Override
    public ResponseEntity<Movie> getMovieById(Integer movieId) {
       return ResponseEntity.ok(movieRepository.findById(movieId).orElseThrow());
    }

    @Override
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Movie>> getAllMoviesOfActor(String actor) {
        List<Movie> movies=getAllMovies().getBody();
        List<Movie> movieList=movies.stream().filter(movie -> movie.getCasting().contains(actor)).collect(Collectors.toList());
        if(movieList.isEmpty()){
            return null;
        }
        return ResponseEntity.ok(movieList);
    }

    @Override
    public ResponseEntity<List<Movie>> getMoviesByGenre(String genre) {
        return ResponseEntity.ok(movieRepository.findByGenre(genre).orElseThrow());

    }

    @Override
    public ResponseEntity<Movie> updateMovie(Integer movieId, Movie movie) {
        Movie existingMovie=movieRepository.findById(movieId).orElseThrow();
        movie.setMovieId(existingMovie.getMovieId());
        movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }

    @Override
    public ResponseEntity<List<Movie>> getMoviesByReleaseDate(LocalDate releaseDate) {
        return ResponseEntity.ok(movieRepository.findByReleaseDate(releaseDate).orElseThrow());

    }

    @Override
    public ResponseEntity<Movie> deleteMovie(Integer movieId) {
        return ResponseEntity.ok(movieRepository.deleteAndGetById(movieId).orElseThrow());
    }
}
