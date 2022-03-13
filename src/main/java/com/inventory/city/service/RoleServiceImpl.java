package com.inventory.city.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.inventory.city.model.City;
import com.inventory.city.model.Role;
import com.inventory.city.repository.CityRepository;
import com.inventory.city.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}


}
