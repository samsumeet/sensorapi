package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.SensorsDAO;
import com.app.domain.SensorStatus;
import com.app.domain.SensorsMeasurement;
import com.app.domain.SensorsMetrics;
import com.app.service.SensorsService;

@Service
public class SensorsServiceImpl implements SensorsService {

	@Autowired
	private SensorsDAO sensorsDAO;

	@Override
	public void addSensorMetrics(SensorsMeasurement sensorsMeasurement) {
		sensorsDAO.insertSensorMeasurement(sensorsMeasurement);
	}

	@Override
	public SensorsMetrics getSensorMetrics(String uuid) {
		return sensorsDAO.getSensorMetrics(uuid);

	}

	@Override
	public SensorStatus getSensorStatus(String uuid) {

		return sensorsDAO.getSensorStatus(uuid);
	}

}
