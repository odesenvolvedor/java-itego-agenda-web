package br.com.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RemoveContato")

public class RemoveContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveContato() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {
		super.destroy();
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse	response)
					throws	IOException, ServletException	{

		PrintWriter	out	= response.getWriter();
		
		// buscando os parâmetros no request
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Contato revomido com sucesso");
		out.println("<a class='btn btn-sm btn-default' href='lista-contatos.jsp' role='button'></a>");
		out.println("</body>");
		out.println("</html>");		
		
	}	
}
