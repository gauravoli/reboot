package com.reboot.admin.service.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reboot.admin.dao.country.CountryDao;
import com.reboot.admin.model.Country;

@Service
public class CountryService {
	
	@Autowired
	protected CountryDao countryDao;
	
	public List<Country> getCountriesService() {
		return countryDao.getCountriesFromDB();
	}
	
}
