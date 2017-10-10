package com.reboot.admin.dao.country;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.reboot.admin.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class CountryDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<Country> getCountriesFromDB() {
		List<Country> countries = jdbcTemplate.query("SELECT ID, NAME FROM COUNTRY",
				new BeanPropertyRowMapper(Country.class));
		return countries;
	}
	
	
	public long saveCountryToDB(String name) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
	    	            PreparedStatement pst =
	    	                con.prepareStatement("insert into  COUNTRY (name, created_by, updated_by) values (?,?,?)", new String[] {"id"});
	    	            pst.setString(1, name);
	    	            pst.setString(2, "Varsha");
	    	            pst.setString(3, "Varsha");
	    	            return pst;
	    	        }
	    	    },
	    	    keyHolder);
	    	return (Long) keyHolder.getKey();
	}

}
