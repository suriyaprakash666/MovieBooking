package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows, String> {
}
