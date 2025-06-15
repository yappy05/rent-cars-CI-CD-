package com.example.carsharing.controller;


import com.example.carsharing.model.User;
import com.example.carsharing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserContoller userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void readAllUsers() {
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        List<User> users = Arrays.asList(user1, user2);

        when(userService.readAllUsers()).thenReturn(users);

        List<User> result = userController.readAllUsers();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());
        verify(userService, times(1)).readAllUsers();
    }

    @Test
    void createUser() {
        User user = new User(null, "Charlie");
        User savedUser = new User(3L, "Charlie");

        when(userService.createUser(user)).thenReturn(savedUser);

        User result = userController.createUser(user);

        assertEquals("Charlie", result.getName());
        assertEquals(3L, result.getId());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    void updateUser() {
        User user = new User(1L, "Alice Updated");

        when(userService.updateUser(user)).thenReturn(user);

        User result = userController.updateUser(user);

        assertEquals("Alice Updated", result.getName());
        verify(userService, times(1)).updateUser(user);
    }

    @Test
    void deleteUser() {
        Long userId = 1L;

        HttpStatus response = userController.deleteUser(userId);

        assertEquals(HttpStatus.OK, response);
        verify(userService, times(1)).deleteUser(userId);
    }
}