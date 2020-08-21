/**
 * 
 */
package com.jaya.currencyconverter.errorHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Priscila Gouveia
 *
 */
@RestControllerAdvice
public class ValidationErrorHandler {

	    @Autowired
	    private MessageSource messageSource;

	    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class) 
	    public List<RequestError>handle(MethodArgumentNotValidException exception) {

	        List<RequestError> dto = new ArrayList<>();

	        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors(); 

	        for(FieldError fieldError : fieldErrors) {

	            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
	            RequestError erro = new RequestError(fieldError.getField(), mensagem); 
	            dto.add(erro);
	        }
	        return dto;

	    }
}
