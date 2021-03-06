package br.com.urban.sandbox.jax_ws_sandbox.model.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	private Date dataErro;
	private String mensagem;

	public InfoFault(String mensagem, Date dataErro) {
		this.mensagem = mensagem;
		this.dataErro = dataErro;
	}

	public Date getDataErro() {
		return dataErro;
	}

	public String getMensagem() {
		return mensagem;
	}

	// JAX-B precisa
	InfoFault() {
	}

}
