package br.com.urban.sandbox.jax_ws_sandbox.model.item;

import java.util.List;

public class Filtros {

	private List<Filtro> filtros;

	public Filtros(List<Filtro> filtros) {
		this.filtros = filtros;
	}

	Filtros() {
	}
	
	public List<Filtro> getLista() {
		return filtros;
	}
	
}
