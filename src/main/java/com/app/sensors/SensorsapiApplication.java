package com.app.sensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages="com.app.controller")
public class SensorsapiApplication{

	public static void main(String[] args) {
		SpringApplication.run(SensorsapiApplication.class, args);
	}

}
