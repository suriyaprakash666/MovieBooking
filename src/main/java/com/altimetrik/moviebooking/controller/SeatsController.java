package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Seat;
import com.altimetrik.moviebooking.exception.SeatNotFoundException;
import com.altimetrik.moviebooking.service.SeatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatsController {
    @Autowired
    private  SeatsServiceImpl seatService;

    @PostMapping("/create")
    public ResponseEntity<Seat> createSeat(@RequestBody Seat newSeat) {
        Seat createdSeat = seatService.createSeat(newSeat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeat);
    }

    @GetMapping("/{seatId}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long seatId) {
        Optional<Seat> seat = seatService.getSeatById(seatId);
        return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{seatId}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long seatId, @RequestBody Seat updatedSeat) {
        Seat seat = seatService.updateSeat(seatId, updatedSeat);
        return seat != null ? ResponseEntity.ok(seat) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId) {
        seatService.deleteSeat(seatId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

}