package com.inventory.city.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.inventory.city.model.User;
import com.inventory.city.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
