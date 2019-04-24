package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.SensorStatus;

public interface SensorStatusRepository extends JpaRepository<SensorStatus, String>{

}
