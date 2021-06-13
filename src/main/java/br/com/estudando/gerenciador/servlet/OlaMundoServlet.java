package br.com.estudando.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ola")
public class OlaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest requisicao, HttpServletResponse resposta) throws IOException {

		PrintWriter pw = resposta.getWriter();
		pw.println("<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Meu Sistema Web Com Java</title>" + "</head>"
				+ "<body>" + "	<h2>Você escreveu o 1* Servlet - Parabéns!</h2>" + "</body>" + "</html>");
		
		System.out.println("O Servlet OlaMundoServlet foi chamado!");
	}

}
