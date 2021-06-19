package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudando.gerenciador.acao.Acao;

//@WebFilter(urlPatterns = "/entrada")
public class ControladorFiltro implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControladorFiltro");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
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
