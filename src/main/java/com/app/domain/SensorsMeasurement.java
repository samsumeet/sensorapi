package com.app.domain;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SensorsMeasurement {
	@NotEmpty(message = "This is a required field")
	private String co2;
	
	@NotEmpty(message = "This is a required field")
	private String time;
}
