package com.inventory.city.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.inventory.city.model.City;
import com.inventory.city.model.Role;

public interface RoleService {
	
	List<Role> getAllRoles();

}
