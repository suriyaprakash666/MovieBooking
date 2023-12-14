package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.exception.UserNotFoundException;
import com.altimetrik.moviebooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) throws UserNotFoundException {
        Optional<User> opt = userRepository.findById(userId);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw new UserNotFoundException("User not found with ID: " + userId,"Check User Id Once!");
        }
    }

    @Override
    public User updateUser(Integer userId, User updatedUser) {

        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setUserName(updatedUser.getUserName());
                    existingUser.setUserPhoneNumber(updatedUser.getUserPhoneNumber());
                    existingUser.setUserEmail(updatedUser.getUserEmail());
                    existingUser.setUserPassword(updatedUser.getUserPassword());
                    return userRepository.save(existingUser);
                })
                .orElse(null);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
