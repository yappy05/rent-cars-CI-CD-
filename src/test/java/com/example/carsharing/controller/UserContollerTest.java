package com.example.carsharing.controller;

import com.example.carsharing.controller.UserContoller;
import com.example.carsharing.model.User;
import com.example.carsharing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserContollerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserContoller userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadAllUsers() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John Doe"));
        when(userService.readAllUsers()).thenReturn(users);

        // Act
        List<User> result = userController.readAllUsers();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
        verify(userService).readAllUsers();
    }

    @Test
    public void testCreateUser() {
        // Arrange
        User user = new User(null, "Jane Doe");
        when(userService.createUser(any(User.class))).thenReturn(new User(2L, "Jane Doe"));

        // Act
        User result = userController.createUser(user);

        // Assert
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        verify(userService).createUser(user);
    }

    @Test
    public void testUpdateUser() {
        // Arrange
        User user = new User(1L, "John Doe");
        when(userService.updateUser(any(User.class))).thenReturn(user);

        // Act
        User result = userController.updateUser(user);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(userService).updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        HttpStatus result = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.OK, result);
        verify(userService).deleteUser(userId);
    }
}