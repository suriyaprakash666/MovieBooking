package com.altimetrik.moviebooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data
public class Show {
    @Id
    String showId;

//    @ManyToOne
//    @JoinColumn(name = "movieId")
//    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;


    @NotNull(message = "Start Time cannot be null")
    LocalTime startTime;

    @NotNull(message = "End Time cannot be null")
    LocalTime endTime;

    @Positive(message = "Price must be a positive value")
    double price;

    @Positive(message = "Seat Availability must be a positive value")
    int seatAvailability;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Seat> seats = new ArrayList<>();

    public Show() {
        generateRandomShowId();
    }

    private void generateRandomShowId() {
        StringBuilder generatedId = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            char randomChar = (char) ('A' + new Random().nextInt(26));
            generatedId.append(randomChar);
        }

        for (int i = 0; i < 6; i++) {
            generatedId.append(new Random().nextInt(10));
        }

        this.showId = generatedId.toString();
    }
}
