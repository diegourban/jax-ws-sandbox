package br.com.urban.sandbox.jax_ws_sandbox.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.urban.sandbox.jax_ws_sandbox.model.item.Filtro;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.Filtros;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.Item;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens")
	@RequestWrapper(localName="listaItens")
	@ResponseWrapper(localName="itens")
	@WebResult(name = "item")
	public List<Item> getItens() {
		System.out.println("Chamando getItens()");
		ArrayList<Item> itensResultado = dao.todosItens();
		return itensResultado;
	}
	
//	@WebMethod(operationName = "todosOsItens")
//	@ResponseWrapper(localName="itens")
//	@WebResult(name = "itens")
//	public List<Item> getItensFiltrados(@WebParam(name="filtros") Filtros filtros) {
//		System.out.println("Chamando getItens()");
//		List<Filtro> listaDeFiltros = filtros.getLista();
//		ArrayList<Item> itensResultado = dao.todosItens(listaDeFiltros);
//		return itensResultado;
//	}
	
	@WebMethod(exclude=true)
    public void outroMetodo() { 
        //nao vai fazer parte do WSDL
    }

}
