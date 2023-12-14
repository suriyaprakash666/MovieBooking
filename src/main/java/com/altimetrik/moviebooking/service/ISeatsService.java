package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seat;

import java.util.List;
import java.util.Optional;

public interface ISeatsService {
    public Seat createSeat(Seat newSeat);
    public Optional<Seat> getSeatById(Long seatId);
    public Seat updateSeat(Long seatId, Seat updatedSeat);
    public void deleteSeat(Long seatId);
    public List<Seat> getAllSeats();


}
