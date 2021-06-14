package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.acao.ListaEmpresas;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		if(acao.equals("ListaEmpresas")) {

			ListaEmpresas le = new ListaEmpresas();
			le.executa(request,response);
			
		} else if(acao.equals("RemoverEmpresa")) {
			System.out.println("Removendo empresa.");
		} else if(acao.equals("MostraEmpresa")) {
		System.out.println("Mostrando empresa.");
	}
		
	}

}
