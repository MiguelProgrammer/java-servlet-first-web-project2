package br.com.estudando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Banco;

public class RemoveEmpresa extends AcaoEmpresa {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Removendo Empresas");
		
		Banco banco = new Banco();
		banco.remover(Integer.parseInt(request.getParameter("idEmpresa")));
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
