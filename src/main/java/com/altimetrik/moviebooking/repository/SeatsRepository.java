package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seat,Long> {

}
