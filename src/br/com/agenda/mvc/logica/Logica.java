package br.com.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	String lista(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	String remove(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	String adiciona(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	String atualiza(HttpServletRequest req, HttpServletResponse res) throws Exception;

}
