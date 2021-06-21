package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudando.gerenciador.acao.Acao;
import br.com.estudando.gerenciador.acao.EditarEmpresa;
import br.com.estudando.gerenciador.acao.ListaEmpresas;
import br.com.estudando.gerenciador.acao.MostraEmpresa;
import br.com.estudando.gerenciador.acao.NovaEmpresa;
import br.com.estudando.gerenciador.acao.NovaEmpresaForm;
import br.com.estudando.gerenciador.acao.RemoveEmpresa;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String nomeDaClasse = "br.com.estudando.gerenciador.acao." + acao;
		String pagina = null;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Acao ae = (Acao) classe.newInstance();
			pagina = ae.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
				
		String[] acaoPagina = pagina.split(":");

		if (acaoPagina[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoPagina[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(acaoPagina[1]);
		}

	}

}
