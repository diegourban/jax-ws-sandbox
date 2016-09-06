package br.com.urban.sandbox.jax_ws_sandbox.exception;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.urban.sandbox.jax_ws_sandbox.model.usuario.InfoFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6128414939520196904L;

	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Token inválido", new Date());
	}

}
