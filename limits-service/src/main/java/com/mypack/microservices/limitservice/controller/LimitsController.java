package com.mypack.microservices.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.microservices.limitservice.configuration.Configuration;
import com.mypack.microservices.limitservice.entities.Limits;

@RestController
public class LimitsController {
	
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits getLimits() {
		return new Limits(configuration.getMinimum() , configuration.getMaximum());
		//return new Limits(1, 100);
	}
}
