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
public class ShowsController {
    private final ShowService showsService;

    @Autowired
    public ShowsController(ShowService showsService) {
        this.showsService = showsService;
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showsService.getAllShows();
    }

    @GetMapping("/{showId}")
    public ResponseEntity<Show> getShowById(@PathVariable String showId) {
        return showsService.getShowById(showId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@Valid @RequestBody Show show) {
        Show savedShow = showsService.saveShow(show);
        return new ResponseEntity<>(savedShow, HttpStatus.CREATED);
    }

    @DeleteMapping("/{showId}")
    public ResponseEntity<Void> deleteShow(@PathVariable String showId) {
        showsService.deleteShow(showId);
        return ResponseEntity.noContent().build();
    }
}
