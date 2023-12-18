package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Show;
import com.altimetrik.moviebooking.exception.ShowException;
import com.altimetrik.moviebooking.repository.ShowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {
    private static final Logger logger = LoggerFactory.getLogger(ShowServiceImpl.class);
    private final ShowRepository showRepository;
    @Autowired
    public ShowServiceImpl(ShowRepository showsRepository) {
        this.showRepository = showsRepository;
    }

    public List<Show> getAllShows() {
        logger.info("Fetching all shows");
        return showRepository.findAll();
    }

    public Optional<Show> getShowById(String showId) {
        logger.info("Fetching show by ID: {}", showId);
        return Optional.ofNullable(showRepository.findById(showId)
                .orElseThrow(() -> new ShowException("Show not found with ID: " + showId)));
    }

    public Show saveShow(Show show) {
        logger.info("Saving show: {}", show);
        try {
            return showRepository.save(show);
        } catch (Exception e) {
            logger.error("Error saving show: {}", e.getMessage());
            throw new ShowException("Error saving show");
        }
    }

    public void deleteShow(String showId) {
        logger.info("Deleting show by ID: {}", showId);
        try {
            showRepository.deleteById(showId);
        } catch (Exception e) {
            logger.error("Error deleting show: {}", e.getMessage());
            throw new ShowException("Error deleting show with ID: " + showId);
        }
    }
}