package com.reboot.admin.controller.country;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private static final Logger LOG = Logger.getLogger(CountryController.class);
	
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
	
	
	@ApiOperation(value = "Save Country objecct", response = Country.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully saved country"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping
	public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
		country.setId(service.saveCountryService(country.getName()));
		if(country.getId() != 0) {
			return new ResponseEntity<>(country, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Update Country objecct", response = Country.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully updated country"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PutMapping
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		int isUpdated = service.updateCountryService(country.getName(), country.getId());
		if(isUpdated == 1) {
			return new ResponseEntity<>(country, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Delete Country objecct", response = String.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully deleted country"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@DeleteMapping("/{name}")
	public ResponseEntity<String> deleteCountry(@PathVariable String name) {
		int isUpdated = service.deleteCountryService(name);
		if(isUpdated == 1) {
			return new ResponseEntity<>("Country Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}