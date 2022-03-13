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
import com.inventory.city.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public void saveCity(City city) {
		this.cityRepository.save(city);

	}

	@Override
	public Page<City> findPage(int pageNumber) {
		Pageable pgbl = PageRequest.of(pageNumber - 1, 5);
		return cityRepository.findAll(pgbl);
	}

	@Override
	public City getCityById(long id) {
		Optional<City> optional = cityRepository.findById(id);
		City city = null;
		if (optional.isPresent()) {
			city = optional.get();
		} else {
			throw new RuntimeException(" City not found for id :: " + id);
		}
		return city;
	}

	@Override
	public void deleteCityById(long id) {
		this.cityRepository.deleteById(id);
	}

	@Override
	public Page<City> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		/*
		 * if (keyword !=null && !keyword.isEmpty() ) { return (Page<City>)
		 * this.cityRepository.findByKeyword(keyword); }
		 */
		return this.cityRepository.findAll(pageable);
	}

	@Override
	public List<City> findByKeyword(String keyword) {
		return cityRepository.findByKeyword(keyword);
	}

}
