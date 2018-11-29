package br.com.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.mvc.logica.Logica;

public class PrimeiraLogica implements Logica{

	@Override
	public String lista(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a logica...");
		System.out.println("Retornando o nome da página	JSP...");
		return "primeira-logica.jsp";		
	}

	@Override
	public String remove(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String adiciona(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualiza(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
