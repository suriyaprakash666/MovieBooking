package com.altimetrik.moviebooking.controller;
import com.altimetrik.moviebooking.entity.User;
import com.altimetrik.moviebooking.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserControllerTest {
     //Junit test template
    @Mock
    private IUserService userService;
    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserRegistration() {
        User mockUser = new User();
        when(userService.createUser(any())).thenReturn(mockUser);

        ResponseEntity<User> response = userController.createUser(new User());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
        verify(userService, times(1)).createUser(any());
    }

    @Test
    void testUpdateUserDetails() {
        Integer userId = 1;
        User mockUpdatedUser = new User();
        when(userService.updateUser(eq(userId), any())).thenReturn(mockUpdatedUser);

        // Act
        ResponseEntity<User> response = userController.updateUser(userId, new User());

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Use HttpStatus.OK for updates, or adjust based on your application's logic
        assertEquals(mockUpdatedUser, response.getBody());
        verify(userService, times(1)).updateUser(eq(userId), any());
    }

    @Test
    void testGetAllCustomers() {
        // Arrange
        List<User> mockCustomers = Arrays.asList(new User(), new User());
        when(userService.getAllUsers()).thenReturn(mockCustomers);
        // Act
        List<User> response = userController.getAllUsers();
        // Assert
        assertEquals(HttpStatus.OK.value(), response.size()); // Check the HTTP status code
        assertEquals(mockCustomers.size(), response.size());
        assertEquals(mockCustomers, response);
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testDeleteUser() {
        Integer userId = 10;
        // Act
        ResponseEntity<Void> responseEntity = userController.deleteUser(userId);
        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(userService, times(1)).deleteUser(userId);
    }


}
