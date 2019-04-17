package com.app.controller.impl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.controller.SensorsAPI;

@Component
public class SensorsImpl implements SensorsAPI{

	@Override
	public ResponseEntity<String> getSensorStatus(String uuid) {
		// TODO Auto-generated method stub
		return new ResponseEntity<String>("{\"status\":\"OK\"}",HttpStatus.OK)  ;
	}

@Override
	public ResponseEntity<String> getSensorMetrics(String uuid) {
		// TODO Auto-generated method stub
		return new ResponseEntity<String>(HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<String> getSensorAlerts(String uuid) {
		// TODO Auto-generated method stub
		return new ResponseEntity<String>(HttpStatus.OK) ;
	}

}
