package br.com.estudando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Banco;
import br.com.estudando.gerenciador.modelo.Empresa;

public class MostraEmpresa extends AcaoEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco bb = new Banco();
		
		Empresa empresaTemporaria = bb.buscaEmpresaPorId(Integer.parseInt(request.getParameter("idEmpresa")));
		request.setAttribute("empresa", empresaTemporaria);
		return "forward:formAlteraEmpresa.jsp";
	}
}
