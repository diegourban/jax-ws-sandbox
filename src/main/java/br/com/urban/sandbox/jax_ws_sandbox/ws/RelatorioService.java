package br.com.urban.sandbox.jax_ws_sandbox.ws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RelatorioService {
	
	@Oneway
	@WebMethod(operationName="GerarRelatorio")
    public void gerarRelatorio() { 
        // código omitido
    }

}
