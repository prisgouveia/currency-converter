/**
 * 
 */
package com.jaya.currencyconverter.exchangeratesapi.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Priscila Gouveia
 *
 */
@Data
public class Rates {
	
	@JsonProperty("BRL")
    private BigDecimal BRL;
	
	@JsonProperty("EUR")
	private BigDecimal EUR;
	
	@JsonProperty("USD")
	private BigDecimal USD;
	
	@JsonProperty("GBP")
	private BigDecimal GBP;
	
	@JsonProperty("JPY")
	private BigDecimal JPY;
	
	@JsonProperty("AUD")
	private BigDecimal AUD;
	
	@JsonProperty("CHF")
	private BigDecimal CHF;
	
	@JsonProperty("CAD")
	private BigDecimal CAD;
	
	@JsonProperty("ARS")
	private BigDecimal ARS;
	
	@JsonProperty("TRY")
	private BigDecimal TRY;
}
