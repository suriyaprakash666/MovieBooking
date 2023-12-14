package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Cinema;
import com.altimetrik.moviebooking.exception.CinemaIdNotFoundException;
import com.altimetrik.moviebooking.service.CinemaServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CinemaController {
    @Autowired
    private CinemaServiceImpl cinemaService;

    @GetMapping("/cinemas")
    public String index(){
        return "Welcome";
    }
    @PostMapping(path="/save")
    @ResponseBody
    public String  saveCinema( @Valid @RequestBody Cinema cinema){
        cinemaService.saveCinema(cinema);
        return "Cinema details saved Successfully";
    }
    @GetMapping("/allCinemas")
    public List<Cinema>getAllCinemas(){
       return cinemaService.getAllCinemas();
    }
    @ResponseBody
    @PutMapping("/update")
    public String updateCinema( @Valid @RequestBody Cinema cinema){
        cinemaService.updateCinema(cinema);
        return "updated Successfully";
    }
    @ResponseBody
    @DeleteMapping(path="/cinema/{id}")
    public String  deleteCinema( @PathVariable("id")@RequestBody long cinemaId){
        cinemaService.deleteCinema(cinemaId).get();
        return "Deleted Successfully";
    }
    @ResponseBody
    @GetMapping("/{cinemaId}")
    public Cinema getCinemaById(@PathVariable("cinemaId")@RequestBody long cinemaId)throws CinemaIdNotFoundException {
        if(cinemaService.getCinemaById(cinemaId)==null){
            throw new CinemaIdNotFoundException("Cinema Id Not Found");
        }
        return cinemaService.getCinemaById(cinemaId);
    }
    @GetMapping("/location")
    public String getCinemaByLocation( @Valid @RequestBody String cinemaLocation) {
        try {
            cinemaService.getCinemaByLocation(cinemaLocation);
            return "Cinemas by location";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error Occuring while fetching locations";
        }
    }

    }
