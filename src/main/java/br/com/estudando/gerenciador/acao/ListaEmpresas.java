package br.com.estudando.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Banco;
import br.com.estudando.gerenciador.modelo.Empresa;

public class ListaEmpresas extends AcaoEmpresa {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();

		request.setAttribute("nomeEmpresas", listaEmpresas);
		

		return "forward:listaEmpresa.jsp";
	}

}
