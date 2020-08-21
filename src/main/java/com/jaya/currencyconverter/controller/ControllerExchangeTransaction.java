/**
 * 
 */
package com.jaya.currencyconverter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaya.currencyconverter.request.RequestExchangeTransaction;
import com.jaya.currencyconverter.service.ServiceExchangeTransaction;

/**
 * @author Priscila Gouveia
 *
 */
@RestController
@RequestMapping("/converter")
public class ControllerExchangeTransaction {

	@Autowired
	private ServiceExchangeTransaction service;
	
	@PostMapping
	public ResponseEntity<?> toConvertAmount(@Valid @RequestBody RequestExchangeTransaction request) {
		try{
			return ResponseEntity.ok(service.toConvertAmount(request));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getTransactionsByUser(@Valid @PathVariable Long userId) {
		try{
			return ResponseEntity.ok(service.getTransactionsByUser(userId));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/currencies")
	public ResponseEntity<?> getAllCurrencies() {
		try{
			return ResponseEntity.ok(service.getCurrencies());
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
