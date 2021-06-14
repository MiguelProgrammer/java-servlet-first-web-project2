package br.com.estudando.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Banco;
import br.com.estudando.gerenciador.modelo.Empresa;

public class ListaEmpresas extends AcaoEmpresa {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Listando Empresas");
		
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();

		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa.jsp");
		request.setAttribute("nomeEmpresas", listaEmpresas);
		rd.forward(request, response);
	}

}
