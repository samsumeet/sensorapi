package com.app.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
@Table(name = "sensors_data")
public class SensorsMeasurement {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String id;

	@NotNull(message = "This is a required field")
	private int co2;

	@NotNull(message = "This is a required field")
	@Temporal(TemporalType.DATE)
	private Date time;

	@NotEmpty(message = "This is a required field")
	private String uuid;
}
