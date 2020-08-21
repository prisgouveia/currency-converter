/**
 * 
 */
package com.jaya.currencyconverter.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jaya.currencyconverter.exchangeratesapi.enums.Currency;

import lombok.Data;

/**
 * @author Priscila Gouveia
 *
 */
@Data
@JsonInclude
public class ResponseExchangeTransaction {
	
	private Long transactionId;
	
	private Long userId;
	
	private Currency fromCurrency;

	private Currency toCurrency;
	
	private BigDecimal amount;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal convertedAmount;
	
	private BigDecimal exchangeRate;
	
	private LocalDateTime exchangeDate;
	
	
}
