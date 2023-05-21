package com.microservices.userservice.service;

import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).get();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String deleteUserById(long userId) {
        userRepository.deleteById(userId);
        return "User Deleted..!!!";
    }
}
