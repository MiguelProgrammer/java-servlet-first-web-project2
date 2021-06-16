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
import br.com.estudando.gerenciador.acao.MostraEmpresa;
import br.com.estudando.gerenciador.acao.NovaEmpresa;
import br.com.estudando.gerenciador.acao.NovaEmpresaForm;
import br.com.estudando.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String pagina = null;

		if (acao.equals("ListaEmpresas")) {
			ListaEmpresas le = new ListaEmpresas();
			pagina = le.executa(request, response);
		} else if (acao.equals("RemoverEmpresa")) {
			RemoveEmpresa re = new RemoveEmpresa();
			pagina = re.executa(request, response);
		} else if (acao.equals("EditarEmpresa")) {
				EditarEmpresa ee = new EditarEmpresa();
			pagina = ee.executa(request, response);
		} else if (acao.equals("MostraEmpresa")) {
			MostraEmpresa me = new MostraEmpresa();
			pagina = me.executa(request, response);
		} else if (acao.equals("NovaEmpresa")) {
			NovaEmpresa ne = new NovaEmpresa();
			pagina = ne.executa(request, response);
		} else if (acao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm nef = new NovaEmpresaForm();
			pagina = nef.executa(request, response);
		}
		
		if(pagina != null) {

			String[] acaoPagina = pagina.split(":");

			if (acaoPagina[0].equals("forward")) {
				System.out.println("WEB-INF/view/" + acaoPagina[1]);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoPagina[1]);
				rd.forward(request, response);
				
			} else {
				response.sendRedirect(acaoPagina[1]);
			}
		}

	}

}
