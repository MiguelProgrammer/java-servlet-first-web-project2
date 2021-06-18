package br.com.estudando.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudando.gerenciador.modelo.Banco;
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
		
		Banco bb = new Banco();
		
		if(laranja.eIgual(login, senha) && bb.existeUsuario(laranja) != null) {
			System.out.println(login + " Acessando ...");
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", laranja);
			
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		return "forward:formLogin.jsp";
	}

}


