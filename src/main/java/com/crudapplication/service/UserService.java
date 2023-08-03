package com.crudapplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.crudapplication.model.User;
import com.crudapplication.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
