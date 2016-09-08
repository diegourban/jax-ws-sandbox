package br.com.urban.sandbox.jax_ws_sandbox.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.urban.sandbox.jax_ws_sandbox.exception.AutorizacaoException;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.Item;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.ItemDao;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.ItemValidador;
import br.com.urban.sandbox.jax_ws_sandbox.model.usuario.TokenDao;
import br.com.urban.sandbox.jax_ws_sandbox.model.usuario.TokenUsuario;

@WebService
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "TodosOsItens")
	@RequestWrapper(localName = "listaItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public List<Item> getItens() {
		System.out.println("Chamando getItens()");
		ArrayList<Item> itensResultado = dao.todosItens();
		return itensResultado;
	}

	// @WebMethod(operationName = "todosOsItens")
	// @ResponseWrapper(localName="itens")
	// @WebResult(name = "itens")
	// public List<Item> getItensFiltrados(@WebParam(name="filtros") Filtros
	// filtros) {
	// System.out.println("Chamando getItens()");
	// List<Filtro> listaDeFiltros = filtros.getLista();
	// ArrayList<Item> itensResultado = dao.todosItens(listaDeFiltros);
	// return itensResultado;
	// }

	@WebMethod(action="CadastrarItem", operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario tokenUsuario,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		
		System.out.println("Token " + tokenUsuario);
		System.out.println("Cadastrando item " + item);
		
		boolean valido = new TokenDao().ehValido(tokenUsuario);
		
		if(!valido) {
			throw new AutorizacaoException("Autorização falhou");
		}
		
		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		return item;
	}

	@WebMethod(exclude = true)
	public void outroMetodo() {
		// nao vai fazer parte do WSDL
	}

}
