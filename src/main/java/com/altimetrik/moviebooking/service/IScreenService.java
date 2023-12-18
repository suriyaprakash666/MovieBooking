package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Screen;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IScreenService {
    List<Screen> getAllScreens();
    ResponseEntity<Screen> getScreenById(String screenId);
    ResponseEntity<Screen> createScreen(Screen screen);
    ResponseEntity<Screen> updateScreen(String screenId, Screen updatedScreen);
    ResponseEntity<Void> deleteScreen(String screenId);
}
