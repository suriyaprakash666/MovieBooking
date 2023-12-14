package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Seats;
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
    public ResponseEntity<Seats> createSeat(@RequestBody Seats newSeat) {
        Seats createdSeat = seatService.createSeat(newSeat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeat);
    }

    @GetMapping("/{seatId}")
    public ResponseEntity<Seats> getSeatById(@PathVariable Long seatId) {
        try {
            Seats seat = seatService.getSeatById(seatId);
            return new ResponseEntity<>(seat, HttpStatus.OK);
        } catch (SeatNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            //Seats seat = seatService.getSeatById(seatId);
            //return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{seatId}")
    public ResponseEntity<Seats> updateSeat(@PathVariable Long seatId, @RequestBody Seats updatedSeat) {
        Seats seat = seatService.updateSeat(seatId, updatedSeat);
        return seat != null ? ResponseEntity.ok(seat) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId) {
         seatService.deleteSeat(seatId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Seats>> getAllSeats() {
        List<Seats> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

}




