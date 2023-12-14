package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.Seats;
import com.altimetrik.moviebooking.exception.SeatNotFoundException;
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

        public Seats getSeatById(Long seatId) throws SeatNotFoundException {
            Optional<Seats> opt=seatRepository.findById(seatId);
            if(opt.isPresent()){
                return opt.get();
            }
            else{
                throw new SeatNotFoundException("Id not found with ID: " + seatId,"Check your Id Once!");
            }
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



