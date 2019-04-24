package com.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.domain.SensorsMeasurement;

public interface SensorsRepository extends JpaRepository<SensorsMeasurement, String> {

	List<SensorsMeasurement> findFirst3ByUuidOrderByTimeDesc(@Param("uuid") String uuid);

	@Query("select s from SensorsMeasurement s where s.uuid = ?1 AND s.time > ?2")
	List<SensorsMeasurement> findByTimeBetween(@Param("uuid") String uuid, @Param("time") Date start);

}
