package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seats,Long> {
}
