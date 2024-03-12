package com.email.demo.service;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

import com.email.demo.model.User;

public class UserRegisteredEvent extends ApplicationEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    private final User user;

    public UserRegisteredEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}