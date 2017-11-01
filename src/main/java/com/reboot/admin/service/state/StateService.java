package com.reboot.admin.service.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reboot.admin.dao.state.StateDao;

@Service
public class StateService {
	
	@Autowired
	protected StateDao stateDao;

	public void saveStateService(String name) {
		stateDao.saveStateToDB(name);
	}
	
	
	public void updateStateService(String name, long id) {
		stateDao.updateStateToDB(name, id);
	}
	
	public void deleteStateService(String name) {
		stateDao.deleteStateFromDB(name);
	}
	
	public void getStateService() {
		stateDao.getStateFromDB();
	}
	
}
