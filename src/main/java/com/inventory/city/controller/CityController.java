package com.inventory.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.city.model.City;
import com.inventory.city.service.CityService;

@Controller
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);
	}

	@GetMapping("/showNewCityForm")
	public String showNewCityForm(Model model) {
		// create model attribute to bind form data
		City city = new City();
		model.addAttribute("city", city);
		return "new_city";
	}

	@GetMapping("/searchCity")
	public String getCities(Model model, String keyword) {

		if (!keyword.isEmpty()) {
			model.addAttribute("listCities", cityService.findByKeyword(keyword));
		} else {
			model.addAttribute("listCities", cityService.getAllCities());
			return "redirect:/";
		}

		return "index";
	}

	@PostMapping("/saveCity")
	public String saveCity(@ModelAttribute("city") City city) {
		// save city to database
		cityService.saveCity(city);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get city from the service
		City city = cityService.getCityById(id);

		// set city as a model attribute to pre-populate the form
		model.addAttribute("city", city);
		return "update_city";
	}

	@GetMapping("/deleteCity/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete city method
		this.cityService.deleteCityById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;
		List<City> listCities = null;
		Page<City> page = cityService.findPaginated(pageNo, pageSize, sortField, sortDir);

		listCities = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listCities", listCities);
		return "index";
	}

	@PostMapping("/login")
	public String login(@PathVariable(value = "user") String user, @PathVariable(value = "role") String role) {

		return "index";
	}

}
