package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.SensorsMeasurement;

public interface SensorsRepository extends JpaRepository<SensorsMeasurement, String>{
	

}
