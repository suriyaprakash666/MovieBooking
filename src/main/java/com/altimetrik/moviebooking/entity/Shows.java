package com.altimetrik.moviebooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.time.LocalTime;

//ShowID, MovieID, CinemaID, Start Time, End Time, Price, Seat Availability.
@Entity
public class Shows {
    @Id
    String showId;
    String movieId;
    String cinemaId;
    LocalTime startTime;
    LocalTime endTime;
    double price;
    int seatAvailability;
}
