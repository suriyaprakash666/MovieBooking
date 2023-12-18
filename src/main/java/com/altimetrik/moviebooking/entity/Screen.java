package com.altimetrik.moviebooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Screen {
    @Id
    private int screenNo;

    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Show> shows;
}
