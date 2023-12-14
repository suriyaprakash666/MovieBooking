package com.altimetrik.moviebooking.service;

import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    //Junit test template to save User
    @DisplayName("unit test template to save User")
    @Test
    public void givenUserObject_whenSaveUser_thenReturnUserObject(){
        User userToSave = new User();
        when(userRepository.save(userToSave)).thenReturn(userToSave);

        User result = userService.createUser(userToSave);
        assertNotNull(result);
        assertEquals(userToSave, result);
         }

         @Test
         public void testGetAllUsers(){
             List<User> expectedUsers = Arrays.asList(new User(), new User());
             when(userRepository.findAll()).thenReturn(expectedUsers);

             List<User> result = userService.getAllUsers();
             assertNotNull(result);
             assertEquals(expectedUsers.size(), result.size());
         }
    @Test
    void testUpdateUsersDetails() {
        Integer userId = 10;
        User updatedUser = new User();
        updatedUser.setUserName("Pooja Surwase");

        User existingUser = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User result = userService.updateUser(userId,updatedUser);
        assertNotNull(result);
        assertEquals(updatedUser.getUserName(), result.getUserName());
    }

    @Test
    void testDeleteUser() {
        int userId = 10;
        // Act
        userService.deleteUser(userId);
        // Assert
        verify(userRepository).deleteById(userId);
    }

}
