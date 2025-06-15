package com.example.carsharing.controller;

import com.example.carsharing.model.User;
import com.example.carsharing.repo.UserRepository;
import com.example.carsharing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@AllArgsConstructor
public class UserContoller {
    private final UserService userService;
    private final UserRepository repo;

    @GetMapping("/api/user")
    public List<User> readAllUsers (){
        return userService.readAllUsers();
    }
    @PostMapping("/api/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/api/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/api/user/delete/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return HttpStatus.OK;
    }
}
