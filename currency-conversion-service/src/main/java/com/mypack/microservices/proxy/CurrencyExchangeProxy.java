package com.mypack.microservices.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mypack.microservices.entity.CurrencyConversion;


//@FeignClient(name = "currency-exchange" , url="localhost:8000")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy
{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeValue(@PathVariable String from , @PathVariable String to );
	

}
