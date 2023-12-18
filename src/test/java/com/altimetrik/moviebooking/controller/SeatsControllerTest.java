package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Seat;
import com.altimetrik.moviebooking.entity.Show;
import com.altimetrik.moviebooking.exception.SeatNotFoundException;
import com.altimetrik.moviebooking.service.SeatsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SeatsControllerTest {

    @Mock
    private SeatsServiceImpl seatService;

    @InjectMocks
    private SeatsController seatsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateSeat() {
        Seat newSeat = new Seat(2l,"s123","si12","booked",new Show());
        when(seatService.createSeat(any())).thenReturn(newSeat);

        ResponseEntity<Seat> response = seatsController.createSeat(newSeat);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newSeat, response.getBody());
    }

    @Test
    void testGetSeatById() {
        Long seatId = 1L;
        Seat seat = new Seat(3l,"s123","d23","booked",new Show());
        when(seatService.getSeatById(seatId)).thenReturn(Optional.of(seat));
        ResponseEntity<Seat> response = seatsController.getSeatById(seatId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(seat, response.getBody());
    }

    @Test
    void testUpdateSeat() {
        Long seatId = 1L;
        Seat updatedSeat = new Seat(2l,"s123","d23","booked",new Show());
        when(seatService.updateSeat(eq(seatId), any())).thenReturn(updatedSeat);

        ResponseEntity<Seat> response = seatsController.updateSeat(seatId, updatedSeat);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedSeat, response.getBody());
    }

    @Test
    void testDeleteSeat() {
        Long seatId = 1L;
        doNothing().when(seatService).deleteSeat(seatId);

        ResponseEntity<Void> response = seatsController.deleteSeat(seatId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertTrue(response.getBody() == null);
    }

    @Test
    void testGetAllSeats() {
        List<Seat> seatList = new ArrayList<>();

        when(seatService.getAllSeats()).thenReturn(seatList);

        ResponseEntity<List<Seat>> response = seatsController.getAllSeats();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(seatList, response.getBody());
    }
}





