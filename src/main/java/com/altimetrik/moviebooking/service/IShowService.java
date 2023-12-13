package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Shows;

import java.util.List;
import java.util.Optional;

public interface IShowService {
    List<Shows> getAllShows();
    Optional<Shows> getShowById(String showId);
    Shows saveShow(Shows show);
    void deleteShow(String showId);
}
