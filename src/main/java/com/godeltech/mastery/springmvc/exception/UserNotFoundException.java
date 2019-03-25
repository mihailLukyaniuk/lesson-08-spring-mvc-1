package com.godeltech.mastery.springmvc.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super(String.format("User [%s] not found", id));
    }
}
