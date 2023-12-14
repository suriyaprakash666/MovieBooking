package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Seats;
import com.altimetrik.moviebooking.exception.SeatNotFoundException;
import com.altimetrik.moviebooking.service.SeatsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SeatsControllerTest {

    @Mock
    private SeatsServiceImpl seatService;

    @InjectMocks
    private SeatsController seatsController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSeat() {
        Seats seat = new Seats(); // Create a sample seat object

        when(seatService.createSeat(any(Seats.class))).thenReturn(seat);

        ResponseEntity<Seats> responseEntity = seatsController.createSeat(seat);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(seat, responseEntity.getBody());
    }

    @Test
    public void testGetSeatById_ExistingSeat() throws SeatNotFoundException {
        Seats seat = new Seats(); // Create a sample seat object
        Long seatId = 1L;

        when(seatService.getSeatById(seatId)).thenReturn(seat);

        ResponseEntity<Seats> responseEntity = seatsController.getSeatById(seatId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(seat, responseEntity.getBody());
    }

    @Test
    public void testUpdateSeat() {
        Seats seat = new Seats(); // Create a sample seat object
        Long seatId = 1L;

        when(seatService.updateSeat(seatId, seat)).thenReturn(seat);

        ResponseEntity<Seats> responseEntity = seatsController.updateSeat(seatId, seat);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(seat, responseEntity.getBody());
    }

    @Test
    public void testDeleteSeat() {
        Long seatId = 1L;

        ResponseEntity<Void> responseEntity = seatsController.deleteSeat(seatId);

        verify(seatService, times(1)).deleteSeat(seatId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAllSeats() {
        Seats seat1 = new Seats();
        Seats seat2 = new Seats();
        List<Seats> seats = Arrays.asList(seat1, seat2);

        when(seatService.getAllSeats()).thenReturn(seats);

        ResponseEntity<List<Seats>> responseEntity = seatsController.getAllSeats();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(seats, responseEntity.getBody());
    }
}

