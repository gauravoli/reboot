package com.reboot.admin.dao.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.reboot.admin.model.Country;

@Repository
public class CountryDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<Country> getCountriesFromDB() {
		List<Country> countries = jdbcTemplate.query("SELECT ID, NAME FROM COUNTRY",
				new BeanPropertyRowMapper(Country.class));
		return countries;
	}

}
