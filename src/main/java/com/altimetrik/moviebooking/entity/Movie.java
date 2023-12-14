package com.altimetrik.moviebooking.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1, initialValue = 1000)
    private Integer movieId;

    @NotBlank(message = "enter the movie title")
    private String movieTitle;

    @NotBlank(message ="enter the movie description" )
    private String description;

    @NotNull(message = "enter date")
    @DateTimeFormat()
    private LocalDate releaseDate;

    @NotNull(message = "enter the duration")
    @DecimalMin(value = "80.0",message = "duration should be at least 80 minutes")
    @DecimalMax(value = "250.0", message = "duration should not be more than 250 minutes")
    private Double duration;

    @NotBlank(message = "enter the genre")
    private String genre;

    @NotBlank(message = "enter the director name")
    private String director;

    @NotBlank(message = "enter the casting")
    private String casting;

=======
public class Movie {

>>>>>>> 65452758ce0302941000aa5a5c528d79eed434c2
}
