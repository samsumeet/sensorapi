package com.app.service;

import com.app.domain.SensorStatus;
import com.app.domain.SensorsMeasurement;
import com.app.domain.SensorsMetrics;

public interface SensorsService {
	public void addSensorMetrics(SensorsMeasurement sensorsMeasurement);

	public SensorStatus getSensorStatus(String uuid);

	public SensorsMetrics getSensorMetrics(String uuid);

}
