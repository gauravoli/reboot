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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin/country")
@Api(value = "Country Controller", description = "Get list of country, insert, update & delete operations")
public class CountryController {

	@Autowired
	protected CountryService service;

	@ApiOperation(value = "Return the list of country", response = Country.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved country list"),
			@ApiResponse(code = 204, message = "No content avaiable in the database"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource") })
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