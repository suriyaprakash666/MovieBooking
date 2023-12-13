package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {

}
