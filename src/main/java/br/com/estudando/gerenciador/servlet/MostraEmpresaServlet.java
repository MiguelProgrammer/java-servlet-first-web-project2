package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostraEmpresaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Banco banco = new Banco();

		Empresa empresa = banco.buscaEmpresaPorId(Integer.parseInt(request.getParameter("idEmpresa")));

		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/FormAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

}
