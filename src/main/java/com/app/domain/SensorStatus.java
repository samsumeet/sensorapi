package com.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "sensors_status")
public class SensorStatus {
	@Id
	private String id;
	
	@NotEmpty(message = "This is a required field")
	private String status;
}
