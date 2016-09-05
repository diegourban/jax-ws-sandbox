package br.com.urban.sandbox.jax_ws_sandbox.ws;

import java.util.List;

import javax.jws.WebService;

import br.com.urban.sandbox.jax_ws_sandbox.model.item.Item;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	public List<Item> getItens() {
		System.out.println("Chamando getItens()");
		return dao.todosItens();
	}

}
