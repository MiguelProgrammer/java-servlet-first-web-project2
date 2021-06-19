package br.com.estudando.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/entrada")
public class FiltroMonitoramento implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filtro)
			throws IOException, ServletException {

		long antes = System.currentTimeMillis();
		
		
		filtro.doFilter(request, response);

		long depois = System.currentTimeMillis();
		System.out.println("TEMPO DE EXECUÇÃO DA ACAO " + request.getParameter("acao") + " = " + (depois- antes));
		
	}

}
