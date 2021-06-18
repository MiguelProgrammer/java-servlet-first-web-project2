package br.com.estudando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudando.gerenciador.modelo.Usuario;

public class Login extends Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario laranja = new Usuario();
		laranja.setLogin(login);
		laranja.setSenha(senha);
		
		if(laranja.eIgual(login, senha)) {
			System.out.println(login + " Acessando ...");
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		return "forward:formLogin.jsp";
	}

}


