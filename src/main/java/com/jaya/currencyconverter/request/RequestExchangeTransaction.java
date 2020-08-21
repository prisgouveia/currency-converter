/**
 * 
 */
package com.jaya.currencyconverter.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author Priscila Gouveia
 *
 */
@Data
@JsonInclude
public class RequestExchangeTransaction {
	
	@NotNull
	private Long userId;
	
	@NotNull
	private String fromCurrency;
	
	@NotNull
	private String toCurrency;
	
	@NotNull
	private BigDecimal amount;
}
