package com.altimetrik.moviebooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {
    @Id
    @GeneratedValue
    @NotNull(message = "Cinema Id must not be blank")
    private long cinemaId;

    @NotNull(message = "Cinema Name must not be null")
    private String cinemaName;

    @NotBlank(message = "Must enter the location ")
    private String cinemaLocation;

    @NotNull(message = "should not be null value ")
    private int cinemaScreens;

    @Positive(message = "Please enter the positive values")
    private long capacity;
    private String facilities;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows = new ArrayList<>();
}
