package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Banco;

@WebServlet("/removeEmpresa")
public class RemoveEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveEmpresasServlet() {
		super();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		banco.remover(Integer.parseInt(request.getParameter("idEmpresa")));
		response.sendRedirect("listaEmpresas");
	}

}
