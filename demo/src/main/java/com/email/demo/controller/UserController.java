package com.email.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.demo.model.User;
import com.email.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return "User registered successfully!";
	}
}