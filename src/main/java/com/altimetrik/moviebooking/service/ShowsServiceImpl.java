package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Show;
import com.altimetrik.moviebooking.exception.ShowsException;
import com.altimetrik.moviebooking.repository.ShowsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowsServiceImpl implements ShowService {
    private static final Logger logger = LoggerFactory.getLogger(ShowsServiceImpl.class);
    private final ShowsRepository showsRepository;
    @Autowired
    public ShowsServiceImpl(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public List<Show> getAllShows() {
        logger.info("Fetching all shows");
        return showsRepository.findAll();
    }

    public Optional<Show> getShowById(String showId) {
        logger.info("Fetching show by ID: {}", showId);
        return Optional.ofNullable(showsRepository.findById(showId).orElseThrow(() -> new ShowsException("Invalid Show Id")));
    }

    public Show saveShow(Show show) {
        logger.info("Saving show: {}", show);
        return showsRepository.save(show);
    }

    public void deleteShow(String showId) {
        logger.info("Deleting show by ID: {}", showId);
        showsRepository.deleteById(showId);
    }
}

