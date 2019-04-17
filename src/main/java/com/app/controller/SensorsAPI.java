
package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("api/v1/sensors")
public interface SensorsAPI {
	
	@GetMapping(value = "/{uuid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Return Sensor status with details", notes = "This is a status API", response = List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity<String> getSensorStatus(@PathVariable("uuid") String uuid);

	@GetMapping(value = "/{uuid}/metrics", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Return metrics with details", notes = "This is a metrics API", response = List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity<String> getSensorMetrics(@PathVariable("uuid") String uuid);

	@GetMapping(value = "/{uuid}/alerts", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Return alerts with details", notes = "This is a alerts API", response = List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity<String> getSensorAlerts(@PathVariable("uuid") String uuid);

}
