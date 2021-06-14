package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.acao.EditarEmpresa;
import br.com.estudando.gerenciador.acao.ListaEmpresas;
import br.com.estudando.gerenciador.acao.NovaEmpresa;
import br.com.estudando.gerenciador.acao.RemoveEmpresa;
import br.com.estudando.gerenciador.modelo.Banco;
import br.com.estudando.gerenciador.modelo.Empresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("ListaEmpresas")) {

			ListaEmpresas le = new ListaEmpresas();
			le.executa(request, response);

		} else if (acao.equals("RemoverEmpresa")) {
			RemoveEmpresa re = new RemoveEmpresa();
			re.executa(request, response);
		} else if (acao.equals("EditarEmpresa")) {
			Banco bb = new Banco();
			Empresa emp = bb.buscaEmpresaPorId((Integer.parseInt(request.getParameter("idEmpresa"))));

			request.setAttribute("empresa", emp);
			RequestDispatcher rd = request.getRequestDispatcher("/FormAlteraEmpresa.jsp");
			rd.forward(request, response);
		} else if (acao.equals("AtualizarEmpresa")) {
			EditarEmpresa ee = new EditarEmpresa();
			ee.executa(request, response);
		} else if (acao.equals("NovaEmpresa")) {
			RequestDispatcher rd = request.getRequestDispatcher("/FormNovaEmpresa.jsp");
			rd.forward(request, response);
		} else if (acao.equals("InserirNovaEmpresa")) {
			NovaEmpresa ne = new NovaEmpresa();
			ne.executa(request, response);
		}

	}

}
