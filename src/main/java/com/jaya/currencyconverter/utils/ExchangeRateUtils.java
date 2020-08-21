/**
 * 
 */
package com.jaya.currencyconverter.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.jaya.currencyconverter.exchangeratesapi.enums.Currency;
import com.jaya.currencyconverter.exchangeratesapi.model.Rates;

/**
 * @author Priscila Gouveia
 *
 */
@Component
public class ExchangeRateUtils {


	public BigDecimal getRate(Rates rate, String toCurrency) {

		Currency currency = Currency.getCurrency(toCurrency);
		switch (currency) {
		case BRL:
			return rate.getBRL();
		case EUR:
			return rate.getEUR();
		case USD:
			return rate.getUSD();
		case GBP:
			return rate.getGBP();
		case JPY:
			return rate.getJPY();
		case AUD:
			return rate.getAUD();
		case CHF:
			return rate.getCHF();
		case CAD:
			return rate.getBRL();
		case ARS:
			return rate.getARS();
		case TRY:
			return rate.getTRY();
		default:
			return null;
		}
	}

}
