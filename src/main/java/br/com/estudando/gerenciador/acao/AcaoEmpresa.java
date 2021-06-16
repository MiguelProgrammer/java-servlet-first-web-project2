package br.com.estudando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AcaoEmpresa {


	public abstract String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
