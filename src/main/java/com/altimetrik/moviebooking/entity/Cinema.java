package com.altimetrik.moviebooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private int cinemaId;
    private String cinemaName;
    private String cinemaLocation;
    private int cinemaScreens;
    private long capacity;
    private String facilities;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows = new ArrayList<>();
}
