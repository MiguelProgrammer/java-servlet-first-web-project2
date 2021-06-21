package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFiltro implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("AutorizaçãoFiltro");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String acao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		Boolean paginaProtegida = !acao.equals("Login") && !acao.equals("LoginForm");
		
		if(paginaProtegida && sessao.getAttribute("usuarioLogado") == null) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
