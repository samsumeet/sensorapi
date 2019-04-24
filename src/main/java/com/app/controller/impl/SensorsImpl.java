package com.app.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.controller.SensorsAPI;
import com.app.domain.Response;
import com.app.domain.SensorStatus;
import com.app.domain.SensorsMeasurement;
import com.app.domain.SensorsMetrics;
import com.app.service.SensorsService;

@Component
public class SensorsImpl implements SensorsAPI {
	@Autowired
	private SensorsService sensorsService;

	@Override
	public ResponseEntity<Response> insertSensorMeasurement(String uuid, SensorsMeasurement sensorsMeasurement) {
		sensorsMeasurement.setUuid(uuid);
		this.sensorsService.addSensorMetrics(sensorsMeasurement);
		return new ResponseEntity<Response>(new Response(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SensorStatus> getSensorStatus(String uuid) {

		return new ResponseEntity<SensorStatus>(this.sensorsService.getSensorStatus(uuid), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SensorsMetrics> getSensorMetrics(String uuid) {
		return new ResponseEntity<SensorsMetrics>(this.sensorsService.getSensorMetrics(uuid),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> getSensorAlerts(String uuid) {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
