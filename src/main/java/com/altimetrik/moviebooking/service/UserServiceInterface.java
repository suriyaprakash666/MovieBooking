package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer userId) throws UserNotFoundException;
    User updateUser(Integer userId, User updatedUser);
    void deleteUser(Integer userId);
}
