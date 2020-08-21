/**
 * 
 */
package com.jaya.currencyconverter.exchangeratesapi.enums;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Priscila Gouveia
 *
 */
@Getter
@AllArgsConstructor
public enum Currency {
	BRL("BRL", "Real"), 
	EUR("EUR", "Euro"),  
	USD("USD", "Dollar"),  
	GBP("GBP", "Great British Pound"),  
	JPY("JPY", "Japanese Yen"),  
	AUD("AUD", "Australian Dollar"),  
	CHF("CHF", "Swiss Franc"),  
	CAD("CAD", "Canadian Dollar"),  
	ARS("ARS", "Argentine Peso"),  
	TRY("TRY", "Turkish Lira"),
	NOT_SUPPORTED("","");
	
	private String code;
	private String name;
	
	public static Map<String, String> getAllCurrencies() {

		Map<String,String> currencies = new HashMap<>();
        
        for(Currency currency : Currency.values()){
            currencies.put(currency.getCode(), currency.getName());
        }
        return currencies;
    }
	
	public static Currency getCurrency(String code) {
		
		for (Currency currency : Currency.values()) {
			if(currency.code.equals(code))
				return currency;
		}
		return Currency.NOT_SUPPORTED;
	}
	
}
