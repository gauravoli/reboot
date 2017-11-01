package com.reboot.admin.controller.state;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reboot.admin.model.State;
import com.reboot.admin.service.state.StateService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/state/")
@Api(value = "State Controller", description = "Get list of states, insert, update & delete operations")
public class StateController {

	private static final Logger LOG = Logger.getLogger(StateController.class);
	
	@Autowired
	protected StateService stateService;
	
	@PostMapping
	public ResponseEntity<State> saveState(@RequestBody State state) {
		stateService.saveStateService(state.getName());
		return null;
	}
	
	@PutMapping
	public void updateState(@RequestBody State state) {
		stateService.updateStateService(state.getName(), state.getId());
	}
	
	@DeleteMapping
	public void deleteState(@PathVariable String name) {
		stateService.deleteStateService(name);
	}
	
	@GetMapping
	public void getStates() {
		stateService.getStateService();
	}
	
}
