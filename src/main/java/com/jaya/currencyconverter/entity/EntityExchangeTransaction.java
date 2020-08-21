/**
 * 
 */
package com.jaya.currencyconverter.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jaya.currencyconverter.exchangeratesapi.enums.Currency;

import lombok.Data;

/**
 * @author Priscila Gouveia
 *
 */
@Data
@Entity
@Table(name = "ExchangeTransaction")
public class EntityExchangeTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Currency fromCurrency;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Currency toCurrency;
	
	@NotNull
	private BigDecimal amount;
	
	private BigDecimal exchangeRate;
	
	private LocalDateTime exchangeDate;
}
