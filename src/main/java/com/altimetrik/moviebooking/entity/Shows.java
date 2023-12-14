package com.altimetrik.moviebooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalTime;
import java.util.Random;

@Entity
@Data
public class Shows {
    @Id
    String showId;

    @NotBlank(message = "Movie ID cannot be blank")
    String movieId;

    @NotBlank(message = "Cinema ID cannot be blank")
    String cinemaId;

    @NotNull(message = "Start Time cannot be null")
    LocalTime startTime;

    @NotNull(message = "End Time cannot be null")
    LocalTime endTime;

    @Positive(message = "Price must be a positive value")
    double price;

    @Positive(message = "Seat Availability must be a positive value")
    int seatAvailability;

    public Shows() {
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
