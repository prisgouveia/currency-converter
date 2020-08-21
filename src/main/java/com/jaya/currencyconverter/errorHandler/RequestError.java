/**
 * 
 */
package com.jaya.currencyconverter.errorHandler;

/**
 * @author Priscila Gouveia
 *
 */
public class RequestError {
	private String campo; 
	private String erro;
	
	public RequestError(String campo, String erro) {
	    this.campo = campo;
	    this.erro = erro;
	}

	public String getCampo() {
	    return campo;
	}

	public String getErro() {
	    return erro;
	}
}
