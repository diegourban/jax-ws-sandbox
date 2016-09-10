package br.com.urban.sandbox.jax_ws_sandbox.client;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.urban.sandbox.jax_ws_sandbox.model.item.Filtro;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.Item;
import br.com.urban.sandbox.jax_ws_sandbox.model.item.TipoItem;
import br.com.urban.sandbox.jax_ws_sandbox.ws.EstoqueWS;

public class ClienteEstoqueDinamico {
	
	public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/estoquews?wsdl");
        QName qname = new QName("http://ws.jax_ws_sandbox.sandbox.urban.com.br/", "EstoqueWSService");

        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);

        Filtro filtro = new Filtro();
        filtro.setNome("IPhone");
        filtro.setTipo(TipoItem.CELULAR);;

        List<Item> itens = cliente.getItens();

        for (Item item : itens) {
            System.out.println(item.getNome());
        }
    }

}
