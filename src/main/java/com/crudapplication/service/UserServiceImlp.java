package com.crudapplication.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crudapplication.model.Role;
import com.crudapplication.model.User;
import com.crudapplication.repository.UserRepository;
import com.crudapplication.web.dto.UserRegistrationDto;

@Service
public class UserServiceImlp implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserServiceImlp(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto registrationDto) {
	   User user = new User(registrationDto.getFirstName(),
			   registrationDto.getLastname() ,registrationDto.getEmail(),
			   registrationDto.getPassword(),Arrays.asList(new Role("Role_User")));
	 
	   return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
