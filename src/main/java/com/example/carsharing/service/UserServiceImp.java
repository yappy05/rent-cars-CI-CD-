package com.example.carsharing.service;

import com.example.carsharing.model.User;
import com.example.carsharing.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository repo;
    @Override
    public List<User> readAllUsers() {
        return repo.findAll();
    }

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return repo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
