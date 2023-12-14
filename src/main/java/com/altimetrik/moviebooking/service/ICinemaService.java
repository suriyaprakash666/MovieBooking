package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Cinema;
import com.altimetrik.moviebooking.exception.CinemaIdNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICinemaService {
    public Cinema saveCinema(Cinema cinema);
    public List<Cinema> getAllCinemas();
    public Cinema updateCinema(Cinema cinema);
    public Optional<Cinema> deleteCinema(long cinemaId);
    public Cinema getCinemaById(long cinemaId) throws CinemaIdNotFoundException;
    public List<Cinema> getCinemaByLocation(String cinemaLocation);
}
