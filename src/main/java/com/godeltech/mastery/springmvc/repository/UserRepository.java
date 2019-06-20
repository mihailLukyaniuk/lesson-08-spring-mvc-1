package com.godeltech.mastery.springmvc.repository;

import com.godeltech.mastery.springmvc.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUser(int id);

    User addUser(User user);

    User editUser(User user, int id);

    void removeUser(int id);
}
