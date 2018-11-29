package br.com.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.jdbc.dao.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

@WebServlet("/AdicionaContato")

public class AdicionaContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionaContato() {
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
		
		String	nome		= request.getParameter("nome");
		String	endereco	= request.getParameter("endereco");
		String	email		= request.getParameter("email");
		String	dataEmTexto	= request.getParameter("dataNascimento");
		
		Calendar dataNascimento	= null;
		

		try	{
			Date date = new	SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);

			dataNascimento 	= Calendar.getInstance();
			
			dataNascimento.setTime(date);
			
		} catch	(ParseException	e)	{
			out.println("Erro de conversão da data");
			return;
		}
		
		Contato	contato	= new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome()	+
				" adicionado com	sucesso");
		out.println("<a class='btn btn-sm btn-default' href='/' role='button'></a>");
		out.println("</body>");
		out.println("</html>");		
	}
	

}
