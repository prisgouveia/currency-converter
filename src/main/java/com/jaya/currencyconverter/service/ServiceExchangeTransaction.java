/**
 * 
 */
package com.jaya.currencyconverter.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaya.currencyconverter.entity.EntityExchangeTransaction;
import com.jaya.currencyconverter.exchangeratesapi.api.ExchangeRatesApiClient;
import com.jaya.currencyconverter.exchangeratesapi.enums.Currency;
import com.jaya.currencyconverter.exchangeratesapi.model.ExchangeRates;
import com.jaya.currencyconverter.repository.RepositoryExchangeTransaction;
import com.jaya.currencyconverter.request.RequestExchangeTransaction;
import com.jaya.currencyconverter.response.ResponseExchangeTransaction;
import com.jaya.currencyconverter.utils.ExchangeRateUtils;
import com.jaya.currencyconverter.utils.MapExchangeTransaction;

/**
 * @author Priscila Gouveia
 *
 */
@Service
public class ServiceExchangeTransaction {

	@Autowired
	ExchangeRatesApiClient exchangeRatesClient;

	@Autowired
	ExchangeRateUtils utils;

	@Autowired
	RepositoryExchangeTransaction repository;

	ExchangeRates exchange;

	public ResponseExchangeTransaction toConvertAmount(RequestExchangeTransaction request) {
		EntityExchangeTransaction transaction = MapExchangeTransaction.fromRequest(request);

		exchange = exchangeRatesClient.getExchangeRate(transaction.getFromCurrency().getCode(),
				transaction.getToCurrency().getCode());
		BigDecimal rate = utils.getRate(exchange.getRate(), transaction.getToCurrency().getCode());
		BigDecimal convertedAmount = rate.multiply(transaction.getAmount());

		transaction.setExchangeDate(LocalDateTime.now(ZoneOffset.UTC));
		transaction.setExchangeRate(rate);

		transaction = repository.save(transaction);

		return MapExchangeTransaction.fromEntity(transaction, convertedAmount);
	}

	public List<ResponseExchangeTransaction> getTransactionsByUser(Long userId) {
		List<EntityExchangeTransaction> exchangeTransaction = repository.findAllTransactionsByUserId(userId);
		List<ResponseExchangeTransaction> responses = new ArrayList<>();
		exchangeTransaction.forEach(transaction -> {
			responses.add(MapExchangeTransaction.fromEntity(transaction, null));
		});
		return responses;
	}

	public Map<String, String> getCurrencies() {
		return Currency.getAllCurrencies();
	}
}
