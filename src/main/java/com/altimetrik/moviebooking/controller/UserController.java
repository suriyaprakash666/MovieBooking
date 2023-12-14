package com.altimetrik.moviebooking.controller;

import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.exception.UserNotFoundException;
import com.altimetrik.moviebooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userServiceInterface;

    @Autowired
    public UserController(IUserService userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    // Create a new user
    @PostMapping("/register-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userServiceInterface.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get all users
    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        return userServiceInterface.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        try {
            User user = userServiceInterface.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update user by ID
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User updatedUser) {
        try {
            User user = userServiceInterface.updateUser(userId, updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete user by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        try {
            userServiceInterface.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
