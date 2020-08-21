/**
 * 
 */
package com.jaya.currencyconverter.utils;

import java.math.BigDecimal;

import com.jaya.currencyconverter.entity.EntityExchangeTransaction;
import com.jaya.currencyconverter.exchangeratesapi.enums.Currency;
import com.jaya.currencyconverter.request.RequestExchangeTransaction;
import com.jaya.currencyconverter.response.ResponseExchangeTransaction;

/**
 * @author Priscila Gouveia
 *
 */
public class MapExchangeTransaction {
	
	public static EntityExchangeTransaction fromRequest(RequestExchangeTransaction request) {
		EntityExchangeTransaction exchangeTransaction = new EntityExchangeTransaction();

		exchangeTransaction.setUserId(request.getUserId());
		exchangeTransaction.setFromCurrency(Currency.getCurrency(request.getFromCurrency()));
		exchangeTransaction.setToCurrency(Currency.getCurrency(request.getToCurrency()));
		exchangeTransaction.setAmount(request.getAmount());
		
		return exchangeTransaction;
	}
	
	public static ResponseExchangeTransaction fromEntity(EntityExchangeTransaction entity, BigDecimal convertedAmount) {
		ResponseExchangeTransaction response = new ResponseExchangeTransaction();
		
		response.setTransactionId(entity.getId());
		response.setUserId(entity.getUserId());
		response.setFromCurrency(entity.getFromCurrency());
		response.setToCurrency(entity.getToCurrency());
		response.setAmount(entity.getAmount());
		response.setConvertedAmount(convertedAmount);
		response.setExchangeRate(entity.getExchangeRate());
		response.setExchangeDate(entity.getExchangeDate());
		
		return response;
	}
	
}
