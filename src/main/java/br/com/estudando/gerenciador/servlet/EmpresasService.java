package br.com.estudando.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.estudando.gerenciador.modelo.Banco;
import br.com.estudando.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		List<Empresa> empresas = new Banco().getEmpresas();

		String tipo = request.getHeader("Accept");

		System.out.println(tipo);
		
		if (tipo.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresas", Empresa.class);
			String xml = xstream.toXML(empresas);

			response.setContentType("application/json");
			response.getWriter().print(xml);
		} else if (tipo.contains("json")) {

			Gson gson = new Gson();
			String json = gson.toJson(empresas);

			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'sem conte?do'}");
		}

	}

}
