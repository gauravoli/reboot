package com.reboot.admin.dao.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StateDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public void saveStateToDB(String name) {
		
	}
	
	public void updateStateToDB(String name, long id) {
		
	}
	
	public void getStateFromDB() {
		
	}
	
	public void deleteStateFromDB(String name) {
		
	}
	
}
