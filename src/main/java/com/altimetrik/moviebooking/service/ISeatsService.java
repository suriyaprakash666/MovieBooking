package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seats;
import com.altimetrik.moviebooking.exception.SeatNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ISeatsService {
    public Seats createSeat(Seats newSeat);
    public Seats getSeatById(Long seatId) throws SeatNotFoundException;
    public Seats updateSeat(Long seatId, Seats updatedSeat);
    public void deleteSeat(Long seatId);
    public List<Seats> getAllSeats();


}
