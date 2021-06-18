package br.com.estudando.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer idSequencial = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(idSequencial++);
		empresa1.setNome("Minha Empresa - MP");
		listaEmpresas.add(empresa1);
		Empresa empresa2 = new Empresa();
		empresa2.setId(idSequencial++);
		empresa2.setNome("Nossa Empresa - jP");
		listaEmpresas.add(empresa2);
		
		Usuario s1 = new Usuario();
		s1.setLogin("1234");
		s1.setSenha("4321");
		
		Usuario s2 = new Usuario();
		s2.setLogin("1234");
		s2.setSenha("4321");

		listaUsuarios.add(s1);
		listaUsuarios.add(s2);
	}
	
	@SuppressWarnings("static-access")
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.idSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	@SuppressWarnings("static-access")
	public void remover(Integer idEmpresa) {
		
		Iterator<Empresa> iter = getEmpresas().iterator();
		
		while(iter.hasNext()) {
			Empresa emp = iter.next();
			if(emp.getId() == idEmpresa) {
				iter.remove();
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}

	public Empresa buscaEmpresaPorId(Integer idEmpresa) {
		for (Empresa emp : getEmpresas()) {
			if(emp.getId() == idEmpresa) {
				return emp;
			}
		}
		return null;
	}

}
