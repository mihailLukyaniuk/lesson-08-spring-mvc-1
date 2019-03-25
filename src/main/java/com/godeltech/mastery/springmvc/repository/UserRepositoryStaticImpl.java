package com.godeltech.mastery.springmvc.repository;

import com.godeltech.mastery.springmvc.entity.User;
import com.godeltech.mastery.springmvc.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryStaticImpl implements UserRepository {

    private static final List<User> USERS = new ArrayList<>();

    private int currentId = 1;

    public UserRepositoryStaticImpl() {
        USERS.add(new User(getId(), "John", "Snow", "He knows nothing"));
        USERS.add(new User(getId(), "Arnold", "Schwarzenegger", "He'll be back"));
        USERS.add(new User(getId(), "John", "Snow", "He knows nothing"));
        USERS.add(new User(getId(), "Arnold", "Schwarzenegger", "He'll be back"));
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(USERS);
    }

    @Override
    public User getUser(int id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User addUser(User user) {
        user.setId(getId());
        USERS.add(user);
        return user;
    }

    @Override
    public void removeUser(int id) {
        USERS.remove(getUser(id));
    }

    private int getId() {
        return currentId++;
    }
}
