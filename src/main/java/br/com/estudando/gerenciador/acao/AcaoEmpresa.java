package br.com.estudando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public abstract class AcaoEmpresa {


	public abstract void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
