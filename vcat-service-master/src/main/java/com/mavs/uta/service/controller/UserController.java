package com.mavs.uta.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavs.uta.service.bean.User;
import com.mavs.uta.service.repository.UserRepository;

@RestController
@RequestMapping(path = "/vcat")
public class UserController {

	@Autowired
	private UserRepository userRepository;
/*
	@PostMapping(path="/login",consumes="application/json", produces = "application/json")
	public User login(@RequestBody User user) {
		return (User) userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}*/
}
