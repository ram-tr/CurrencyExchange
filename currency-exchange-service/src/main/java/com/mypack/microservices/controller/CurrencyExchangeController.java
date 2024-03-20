package com.mypack.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.microservices.entity.CurrencyExchange;
import com.mypack.microservices.repo.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository currencyRepository;
	
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from , @PathVariable String to )
	{
		CurrencyExchange currencyExchange = currencyRepository.findByFromAndTo(from, to);
		
		if(currencyExchange == null)
		{
			throw new RuntimeException("Unable to find Data for "+ from+" to "+to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
	

}
