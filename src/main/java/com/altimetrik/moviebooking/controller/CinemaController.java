package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.Cinema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    @GetMapping("/cinema")
    public String index(){
        return "Welcome";

    }
}
