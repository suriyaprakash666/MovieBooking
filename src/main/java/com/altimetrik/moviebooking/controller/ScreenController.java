package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Screen;
import com.altimetrik.moviebooking.service.IScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    private final IScreenService screenService;
    @Autowired
    public ScreenController(IScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens() {
        List<Screen> screens = screenService.getAllScreens();
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

    @GetMapping("/{screenId}")
    public ResponseEntity<Screen> getScreenById(@PathVariable String screenId) {
        return screenService.getScreenById(screenId);
    }

    @PostMapping
    public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
        return screenService.createScreen(screen);
    }

    @PutMapping("/{screenId}")
    public ResponseEntity<Screen> updateScreen(@PathVariable String screenId, @RequestBody Screen updatedScreen) {
        return screenService.updateScreen(screenId, updatedScreen);
    }

    @DeleteMapping("/{screenId}")
    public ResponseEntity<Void> deleteScreen(@PathVariable String screenId) {
        return screenService.deleteScreen(screenId);
    }
}
