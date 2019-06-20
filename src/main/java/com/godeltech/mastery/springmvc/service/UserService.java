package com.godeltech.mastery.springmvc.service;

import com.godeltech.mastery.springmvc.entity.User;
import com.godeltech.mastery.springmvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public User editUser(User user, int id) {
        return userRepository.editUser(user, id);
    }

    public void removeUser(int id) {
        userRepository.removeUser(id);
    }
}