package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Show;

import java.util.List;
import java.util.Optional;

public interface ShowService {
    List<Show> getAllShows();
    Optional<Show> getShowById(String showId);
    Show saveShow(Show show);
    void deleteShow(String showId);
}