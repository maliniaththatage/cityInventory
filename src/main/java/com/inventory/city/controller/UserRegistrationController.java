package com.inventory.city.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.city.service.UserService;
import com.inventory.city.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService service) {
		this.userService=service;
	}
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationFrom() {
		return "registration";
		
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
