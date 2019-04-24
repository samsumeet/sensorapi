package com.app.sensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages= {"com.app.service","com.app.controller","com.app.dao"})
@EntityScan("com.app.domain")
@EnableJpaRepositories("com.app.repository")
public class SensorsapiApplication{

	public static void main(String[] args) {
		SpringApplication.run(SensorsapiApplication.class, args);
	}

}
