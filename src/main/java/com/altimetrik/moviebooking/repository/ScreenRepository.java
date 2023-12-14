package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, String> {
}
