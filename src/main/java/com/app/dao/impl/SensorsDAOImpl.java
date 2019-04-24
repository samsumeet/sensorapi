package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import static com.app.constants.Constants.STATUS;
import static com.app.constants.Constants.C02_THRESHOLD_VALUE;


import java.util.Calendar;
import java.util.List;

import com.app.dao.SensorsDAO;
import com.app.domain.SensorStatus;
import com.app.domain.SensorsMeasurement;
import com.app.domain.SensorsMetrics;
import com.app.repository.SensorStatusRepository;
import com.app.repository.SensorsRepository;

@Component
public class SensorsDAOImpl implements SensorsDAO {
	@Autowired
	private SensorsRepository sensorsMeasurementRepository;
	@Autowired
	private SensorStatusRepository sensorsStatusRepository;

	@Override
	public void insertSensorMeasurement(SensorsMeasurement sensorsMeasurement) {

		sensorsMeasurementRepository.save(sensorsMeasurement);

		SensorStatus sensorStatus = new SensorStatus();
		sensorStatus.setId(sensorsMeasurement.getUuid());

		if (sensorsMeasurement.getCo2() > C02_THRESHOLD_VALUE) {
			sensorStatus.setStatus(STATUS[1]);
			sensorsStatusRepository.save(sensorStatus);
		}

		List<SensorsMeasurement> sensorsDataList = sensorsMeasurementRepository.findFirst3ByUuidOrderByTimeDesc(sensorsMeasurement.getUuid());
		if (sensorsDataList.size() > 0) {
			int co2 = sensorsDataList.get(0).getCo2();

			boolean sameValues = sensorsDataList.stream().allMatch(x -> x.getCo2() == co2);

			if (co2 > C02_THRESHOLD_VALUE && sameValues) {
				sensorStatus.setStatus(STATUS[2]);
				sensorsStatusRepository.save(sensorStatus);
			} else if (co2 < C02_THRESHOLD_VALUE && sameValues) {
				sensorStatus.setStatus(STATUS[0]);
				sensorsStatusRepository.save(sensorStatus);
			}
		}

	}

	@Override
	public SensorsMeasurement getSensorMeasurement(String uuid) {
		return sensorsMeasurementRepository.findById(uuid).get();
	}

	@Override
	public SensorStatus getSensorStatus(String uuid) {
		return sensorsStatusRepository.findById(uuid).get();
	}

	@Override
	public SensorsMetrics getSensorMetrics(String uuid) {

		SensorsMetrics sensorsMetrics = new SensorsMetrics();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);// then one month

		List<SensorsMeasurement> list = sensorsMeasurementRepository.findByTimeBetween(uuid, c.getTime());
		sensorsMetrics.setMaxLast30Days(list.stream().mapToInt(data -> data.getCo2()).max().getAsInt());
		sensorsMetrics.setAvgLast30Days(list.stream().mapToInt(data -> data.getCo2()).average().getAsDouble());

		return sensorsMetrics;
	}

}
