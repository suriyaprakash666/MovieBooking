package com.altimetrik.moviebooking.service;
//
//<<<<<<< HEAD
import com.altimetrik.moviebooking.entity.Cinema;
import com.altimetrik.moviebooking.exception.CinemaIdNotFoundException;
import com.altimetrik.moviebooking.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CinemaServiceImpl implements ICinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema updateCinema(Cinema cinema) {
        Optional<Cinema>opt=cinemaRepository.findById(cinema.getCinemaId());
        if(opt.isPresent()){
            cinemaRepository.save(cinema);
        }
        return cinema;
    }

    @Override
    public Optional<Cinema>deleteCinema(long cinemaId) {
        cinemaRepository.deleteById(cinemaId);
        return cinemaRepository.findById(cinemaId);

    }

    @Override
    public Cinema getCinemaById(long cinemaId) throws CinemaIdNotFoundException {
        Optional<Cinema> optional = cinemaRepository.findById(cinemaId);
        Cinema c = null;
            if (optional.isPresent()) {
                c = optional.get();
                throw new CinemaIdNotFoundException("CinemaId Not Found");
            }
            return c;
        }




    @Override
    public List<Cinema> getCinemaByLocation(String cinemaLocation) {
        try {
            List<Cinema> allCinema = cinemaRepository.findAll();
            if (allCinema == null) {
                throw new RuntimeException("Locations not available");
            }
            return allCinema.stream().filter(cinema -> cinema.getCinemaLocation().
                    equalsIgnoreCase(cinemaLocation)).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }
//
//=======
//public class CinemaServiceImpl implements ICinemaService{
//>>>>>>> 53926498360b5aa9a96a580305b4996ce66dbb37
}
