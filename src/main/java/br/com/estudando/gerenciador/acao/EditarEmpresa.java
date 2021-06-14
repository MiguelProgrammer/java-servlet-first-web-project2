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

public class EditarEmpresa extends AcaoEmpresa {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Editando a Empresa;");

		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		Date dtAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dtAbertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPorId(Integer.parseInt(request.getParameter("idEmpresa")));

		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dtAbertura);

		response.sendRedirect("entrada?acao=ListaEmpresas");

	}
}