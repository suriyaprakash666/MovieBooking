package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seat;
import com.altimetrik.moviebooking.entity.Show;
import com.altimetrik.moviebooking.repository.SeatsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SeatsServiceImplTest {

    @Mock
    private SeatsRepository seatRepository;

    @InjectMocks
    private SeatsServiceImpl seatsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateSeat() {
        Seat newSeat = new Seat(5l,"si123","di23","booked",new Show());
        when(seatRepository.save(any())).thenReturn(newSeat);

        Seat createdSeat = seatsService.createSeat(newSeat);

        assertEquals(newSeat, createdSeat);
        verify(seatRepository, times(1)).save(newSeat);
    }

    @Test
    void testGetSeatById() {
        Long seatId = 1L;
        Seat seat = new Seat(6l,"sa123","da23","booked",new Show());
        when(seatRepository.findById(seatId)).thenReturn(Optional.of(seat));

        Optional<Seat> retrievedSeat = seatsService.getSeatById(seatId);

        assertEquals(Optional.of(seat), retrievedSeat);
        verify(seatRepository, times(1)).findById(seatId);
    }

    @Test
    void testUpdateSeat() {
        Long seatId = 1L;
        Seat updatedSeat = new Seat(5l,"s123","d23","notbooked",new Show());
        Seat existingSeat = new Seat(5l,"s123","d23","booked",new Show());
        when(seatRepository.findById(seatId)).thenReturn(Optional.of(existingSeat));
        when(seatRepository.save(any())).thenReturn(updatedSeat);

        Seat updated = seatsService.updateSeat(seatId, updatedSeat);

        assertEquals(updatedSeat, updated);
        verify(seatRepository, times(1)).findById(seatId);
        verify(seatRepository, times(1)).save(existingSeat);
    }

    @Test
    void testDeleteSeat() {
        Long seatId = 1L;
        doNothing().when(seatRepository).deleteById(seatId);

        seatsService.deleteSeat(seatId);

        verify(seatRepository, times(1)).deleteById(seatId);
    }

    @Test
    void testGetAllSeats() {
        List<Seat> seatList = new ArrayList<>();
        // Add sample seats to the list

        when(seatRepository.findAll()).thenReturn(seatList);

        List<Seat> allSeats = seatsService.getAllSeats();

        assertEquals(seatList, allSeats);
        verify(seatRepository, times(1)).findAll();
    }
}


//import com.altimetrik.moviebooking.entity.Seat;
//import com.altimetrik.moviebooking.exception.SeatNotFoundException;
//import com.altimetrik.moviebooking.repository.SeatsRepository;
//import com.altimetrik.moviebooking.service.SeatsServiceImpl;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
////@RunWith(MockitoJUnitRunner.class)
//public class SeatsServiceImplTest {
//    @Mock
//    private SeatsRepository seatRepository;
//    @InjectMocks
//    private SeatsServiceImpl seatService;
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testCreateSeat() {
//        Seat seat = new Seat(); // Create a sample seat object
//        when(seatRepository.save(any(Seat.class))).thenReturn(seat);
//        Seat createdSeat = seatService.createSeat(seat);
//        assertNotNull(createdSeat);
//        assertEquals(seat, createdSeat);
//    }
//    @Test
//    public void testGetSeatById_ExistingSeat() throws SeatNotFoundException {
//        Seat seat = new Seat(); // Create a sample seat object
//        Long seatId = 1L;
//
//        when(seatRepository.findById(seatId)).thenReturn(Optional.of(seat));
//
//        Optional<Seat> retrievedSeat = seatService.getSeatById(seatId);
//
//        assertNotNull(retrievedSeat);
//        assertEquals(seat, retrievedSeat);
//    }
//
//    @Test
//    public void testUpdateSeat() {
//        Seat seat = new Seat(); // Create a sample seat object
//        Long seatId = 1L;
//
//        when(seatRepository.findById(seatId)).thenReturn(Optional.of(seat));
//        when(seatRepository.save(any(Seat.class))).thenReturn(seat);
//
//        Seat updatedSeat = seatService.updateSeat(seatId, seat);
//
//        assertNotNull(updatedSeat);
//        assertEquals(seat, updatedSeat);
//    }
//
//    @Test
//    public void testDeleteSeat() {
//        Long seatId = 1L;
//
//        seatService.deleteSeat(seatId);
//
//        verify(seatRepository, times(1)).deleteById(seatId);
//    }
//
//    @Test
//    public void testGetAllSeats() {
//        List<Seat> seats = new ArrayList<>();
//        when(seatRepository.findAll()).thenReturn(seats);
//
//        List<Seat> retrievedSeats = seatService.getAllSeats();
//
//        assertNotNull(retrievedSeats);
//        assertEquals(seats, retrievedSeats);
//    }
//}

