package br.com.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.mvc.logica.Logica;

@WebServlet("/mvc")

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {
		super.destroy();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramentro = request.getParameter("logica");
		String acao = request.getParameter("acao");
		String nomeDaClasse = "br.com.agenda.mvc.logica." + paramentro;
		try	{
			Class<?>  classe = Class.forName(nomeDaClasse);			
			Logica logica = (Logica) classe.newInstance();
			String pagina = "";
			
			switch (acao) {
				case "lista" :
					pagina = logica.lista(request, response);	
					break;
				case "adiciona" :
					pagina = logica.adiciona(request, response);	
					break;
				case "remove" :
					pagina = logica.remove(request, response);	
					break;
				case "atualiza" :
					pagina = logica.atualiza(request, response);	
					break;
			}
								
			request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (Exception e) {
						
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
