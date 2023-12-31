package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer userId) throws UserNotFoundException;
    User updateUser(Integer userId, User updatedUser);
    void deleteUser(Integer userId);
}
