package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seat;
import com.altimetrik.moviebooking.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatsServiceImpl implements ISeatsService{
        @Autowired
        private SeatsRepository seatRepository;

        public Seat createSeat(Seat newSeat) {
            return seatRepository.save(newSeat);
        }

        public Optional<Seat> getSeatById(Long seatId) {
            return seatRepository.findById(seatId);
        }

        public Seat updateSeat(Long seatId, Seat updatedSeat) {
            Seat seat = seatRepository.findById(seatId).orElse(null);
            if (seat != null) {
                seat.setStatus(updatedSeat.getStatus());
                seat.setType(updatedSeat.getType());
                return seatRepository.save(seat);
            }
            return null;
        }

        public void deleteSeat(Long seatId) {
                seatRepository.deleteById(seatId);
        }

        public List<Seat> getAllSeats() {
            return seatRepository.findAll();
        }


    }



