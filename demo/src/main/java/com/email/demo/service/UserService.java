package com.email.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.email.demo.model.User;
import com.email.demo.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void registerUser(User user) {
        userRepository.save(user);

        // Emit user registered event
        eventPublisher.publishEvent(new UserRegisteredEvent(this, user));
    }
}