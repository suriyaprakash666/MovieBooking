package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seats;
import com.altimetrik.moviebooking.exception.SeatNotFoundException;
import com.altimetrik.moviebooking.repository.SeatsRepository;
import com.altimetrik.moviebooking.service.SeatsServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class SeatsServiceImplTest {
    @Mock
    private SeatsRepository seatRepository;
    @InjectMocks
    private SeatsServiceImpl seatService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSeat() {
        Seats seat = new Seats(); // Create a sample seat object
        when(seatRepository.save(any(Seats.class))).thenReturn(seat);
        Seats createdSeat = seatService.createSeat(seat);
        assertNotNull(createdSeat);
        assertEquals(seat, createdSeat);
    }
    @Test
    public void testGetSeatById_ExistingSeat() throws SeatNotFoundException {
        Seats seat = new Seats(); // Create a sample seat object
        Long seatId = 1L;

        when(seatRepository.findById(seatId)).thenReturn(Optional.of(seat));

        Seats retrievedSeat = seatService.getSeatById(seatId);

        assertNotNull(retrievedSeat);
        assertEquals(seat, retrievedSeat);
    }

    @Test
    public void testUpdateSeat() {
        Seats seat = new Seats(); // Create a sample seat object
        Long seatId = 1L;

        when(seatRepository.findById(seatId)).thenReturn(Optional.of(seat));
        when(seatRepository.save(any(Seats.class))).thenReturn(seat);

        Seats updatedSeat = seatService.updateSeat(seatId, seat);

        assertNotNull(updatedSeat);
        assertEquals(seat, updatedSeat);
    }

    @Test
    public void testDeleteSeat() {
        Long seatId = 1L;

        seatService.deleteSeat(seatId);

        verify(seatRepository, times(1)).deleteById(seatId);
    }

    @Test
    public void testGetAllSeats() {
        List<Seats> seats = new ArrayList<>();
        when(seatRepository.findAll()).thenReturn(seats);

        List<Seats> retrievedSeats = seatService.getAllSeats();

        assertNotNull(retrievedSeats);
        assertEquals(seats, retrievedSeats);
    }
}

