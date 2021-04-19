package com.mavs.uta.service.repository;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.mavs.uta.service.bean.User;

@RestResource(exported = false)
public interface UserRepository extends Repository<User, String> {
	  User findByUsernameAndPassword(String username,String password);

	}
