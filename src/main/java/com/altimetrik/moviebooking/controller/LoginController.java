package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.DTO.LoginRequest;
import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.service.IUserService;
import com.altimetrik.moviebooking.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    @Autowired
    IUserService userServiceInterface;
    @PostMapping("/user-login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        User user = userServiceInterface.getUserById(loginRequest.getUserID());

        if (user != null && user.getUserPassword().equals(loginRequest.getUserPassword())) {
            return ResponseEntity.ok("Login successful!"+user.getUserName());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
}