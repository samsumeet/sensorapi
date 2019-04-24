package com.app.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SensorsMetrics {
	@NotNull(message = "This is a required field")
	private int maxLast30Days;

	@NotNull(message = "This is a required field")
	private double avgLast30Days;

}
