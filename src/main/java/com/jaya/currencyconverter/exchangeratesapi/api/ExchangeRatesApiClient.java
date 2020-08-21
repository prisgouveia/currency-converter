/**
 * 
 */
package com.jaya.currencyconverter.exchangeratesapi.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaya.currencyconverter.exchangeratesapi.model.ExchangeRates;


/**
 * @author Priscila Gouveia
 *
 */
@FeignClient(url = "https://api.exchangeratesapi.io", name = "exchangeratesapi")
public interface ExchangeRatesApiClient {
	
	@GetMapping(value = "/latesmt")
	public ExchangeRates getExchangeRate(@RequestParam(name="base") String base, @RequestParam(name="symbols") String symbols); 

}
