package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, String> {
}
