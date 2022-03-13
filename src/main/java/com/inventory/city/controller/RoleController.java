package com.inventory.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.city.model.Role;
import com.inventory.city.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/role")
	public String getRoles(Model model) {
		List<Role> roles = roleService.getAllRoles();
		model.addAttribute("role ", roles);
		return "role";
	}
}
