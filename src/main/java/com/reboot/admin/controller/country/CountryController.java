package com.reboot.admin.controller.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reboot.admin.model.Country;
import com.reboot.admin.service.country.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService service;
	
	@GetMapping
	public ResponseEntity<List<Country>> getCountries() {
		List<Country> countries = service.getCountriesService();

		if (null != countries && !countries.isEmpty()) {
			return new ResponseEntity<>(countries, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/{country}")
	public ResponseEntity<Country> getCountryId(@PathVariable String country) {
		return null;
	}
}