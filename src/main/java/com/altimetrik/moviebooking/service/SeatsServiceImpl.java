package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seats;
import com.altimetrik.moviebooking.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatsServiceImpl implements ISeatsService{
        @Autowired
        private SeatsRepository seatRepository;

        public Seats createSeat(Seats newSeat) {
            return seatRepository.save(newSeat);
        }

        public Optional<Seats> getSeatById(Long seatId) {
            return seatRepository.findById(seatId);
        }

        public Seats updateSeat(Long seatId, Seats updatedSeat) {
            Seats seat = seatRepository.findById(seatId).orElse(null);
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

        public List<Seats> getAllSeats() {
            return seatRepository.findAll();
        }


    }



