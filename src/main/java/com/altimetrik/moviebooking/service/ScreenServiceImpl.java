// ScreenService.java

package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Screen;
import com.altimetrik.moviebooking.exception.ScreenNotFoundException;
import com.altimetrik.moviebooking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements IScreenService{
    private final ScreenRepository screenRepository;
    @Autowired
    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public ResponseEntity<Screen> getScreenById(String screenId) {
        Optional<Screen> screen = screenRepository.findById(screenId);
        return screen.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Screen> createScreen(Screen screen) {
        Screen createdScreen = screenRepository.save(screen);
        return new ResponseEntity<>(createdScreen, HttpStatus.CREATED);
    }

    public ResponseEntity<Screen> updateScreen(String screenId, Screen updatedScreen) {
        Screen existingScreen = screenRepository.findById(screenId)
                .orElseThrow(() -> new ScreenNotFoundException("Screen not found with ID: " + screenId));

        existingScreen.setCinema(updatedScreen.getCinema());
        existingScreen.setShows(updatedScreen.getShows());

        Screen updated = screenRepository.save(existingScreen);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteScreen(String screenId) {
        if (!screenRepository.existsById(screenId)) {
            throw new ScreenNotFoundException("Screen not found with ID: " + screenId);
        }

        screenRepository.deleteById(screenId);
        return ResponseEntity.noContent().build();
    }
}
