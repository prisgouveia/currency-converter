/**
 * 
 */
package com.jaya.currencyconverter.exchangeratesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Priscila Gouveia
 *
 */
@Data
public class ExchangeRates {
	
	@JsonProperty("base")
	private String base;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("rates")
	private Rates rate;
}
