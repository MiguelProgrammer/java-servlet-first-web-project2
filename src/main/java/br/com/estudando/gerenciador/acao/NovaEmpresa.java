 	package br.com.estudando.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Banco;
import br.com.estudando.gerenciador.modelo.Empresa;

public class NovaEmpresa extends AcaoEmpresa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Gravando Nova Empresa");
		
		Empresa empresa = new Empresa();
		String nomeEmpresa = request.getParameter("nome");
		empresa.setNome(nomeEmpresa);
		

		String dataAbertura = request.getParameter("data");
		Date dtAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dtAbertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		empresa.setDataAbertura(dtAbertura);
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		request.setAttribute("dataAbertura", empresa.getDataAbertura());
		

		return "forward:listaEmpresa.jsp";
		
	}

}
