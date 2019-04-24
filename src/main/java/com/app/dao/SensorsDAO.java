package com.app.dao;

import org.springframework.stereotype.Repository;

import com.app.domain.SensorStatus;
import com.app.domain.SensorsMeasurement;
import com.app.domain.SensorsMetrics;

@Repository
public interface SensorsDAO {

	void insertSensorMeasurement(SensorsMeasurement sensorsMeasurement);

	SensorsMeasurement getSensorMeasurement(String uuid);
	
	SensorStatus getSensorStatus(String uuid);
	
	SensorsMetrics getSensorMetrics(String uuid);

}
