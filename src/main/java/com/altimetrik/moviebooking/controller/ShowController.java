package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Show;
import com.altimetrik.moviebooking.service.ShowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
    private final ShowService showService;
    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{showId}")
    public ResponseEntity<Show> getShowById(@PathVariable String showId) {
        return showService.getShowById(showId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@Valid @RequestBody Show show) {
        Show savedShow = showService.saveShow(show);
        return new ResponseEntity<>(savedShow, HttpStatus.CREATED);
    }

    @DeleteMapping("/{showId}")
    public ResponseEntity<Void> deleteShow(@PathVariable String showId) {
        showService.deleteShow(showId);
        return ResponseEntity.noContent().build();
    }
}