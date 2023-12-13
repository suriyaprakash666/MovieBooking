package com.altimetrik.moviebooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {
    @Id
    private int cinemaId;
    private String cinemaName;
    private String cinemaLocation;
    private int cinemaScreens;
    private long capacity;
    private String facilities;
}
