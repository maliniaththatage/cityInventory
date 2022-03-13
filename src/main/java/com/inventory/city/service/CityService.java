package com.inventory.city.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.inventory.city.model.City;

public interface CityService {
	
	List<City> getAllCities();

	void saveCity(City city);

	City getCityById(long id);

	void deleteCityById(long id);

	Page<City> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	List <City> findByKeyword(String keyword);
	
	Page<City> findPage(int pageNumber);
}
