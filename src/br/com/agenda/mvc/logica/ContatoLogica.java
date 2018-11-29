package br.com.agenda.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.jdbc.dao.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class ContatoLogica implements Logica {

	@Override
	public String lista(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Contato> contatos = new ContatoDao().getLista();
		req.setAttribute("contatos", contatos);

		return "lista-contatos.jsp";
	}

	@Override
	public String remove(HttpServletRequest req, HttpServletResponse res) {
		try {
			Long id = new Long(req.getParameter("id"));

			Contato contato = new Contato();
			contato.setId(id);

			ContatoDao contatoDao = new ContatoDao();

			contatoDao.remove(contato);

			req.setAttribute("success", "Contato removido com sucesso");

		} catch (Exception e) {
			req.setAttribute("error", "Erro ao remover contato");
		}
		return "mvc?logica=ContatoLogica&acao=lista";
	}

	@Override
	public String adiciona(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String method = req.getMethod();

		if (method == "POST") {

			try {
				String nome = req.getParameter("nome");
				String endereco = req.getParameter("endereco");
				String email = req.getParameter("email");
				String dataEmTexto = req.getParameter("dataNascimento");

				Calendar dataNascimento = null;

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);

					dataNascimento = Calendar.getInstance();

					dataNascimento.setTime(date);

				} catch (ParseException e) {

					req.setAttribute("error", "Erro de conversão da data");
					;
				}

				Contato contato = new Contato();
				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);

				ContatoDao dao = new ContatoDao();
				dao.adiciona(contato);

				req.setAttribute("success", "Contato " + contato.getNome() + " adicionado com sucesso");

				return "mvc?logica=ContatoLogica&acao=lista";
				
			} catch (Exception e) {
				
				req.setAttribute("error", "Erro ao salvar o contato");
				
			}
		}
		return "index.html";
	}

	@Override
	public String atualiza(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String method = req.getMethod();
		Long id = new Long(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		System.out.println("id " + id);
		
		if (method == "POST") {

			try {
				String nome = req.getParameter("nome");
				String endereco = req.getParameter("endereco");
				String email = req.getParameter("email");
				String dataEmTexto = req.getParameter("dataNascimento");

				Calendar dataNascimento = null;

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
					dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(date);

				} catch (ParseException e) {
					req.setAttribute("error", "Erro de conversão da data");
				}

				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);

				ContatoDao dao = new ContatoDao();
				dao.altera(contato);

				req.setAttribute("success", "Contato " + contato.getNome() + " atualizado com sucesso");

				return "mvc?logica=ContatoLogica&acao=lista";
				
			} catch (Exception e) {				
				req.setAttribute("error", "Erro ao salvar o contato");				
			}
			
		} else {
			try {
				ContatoDao dao = new ContatoDao();
				dao.buscaContato(id);
				System.out.println("id " + id);
				System.out.println("nome " + contato.getNome());
				req.setAttribute("contato", contato);
				return "mvc?logica=ContatoLogica&acao=lista";
				//return "atualiza-contato.jsp";
			} catch (Exception e) {				
				req.setAttribute("error", "Erro ao buscar o contato");				
			}
			
		}
		return "mvc?logica=ContatoLogica&acao=lista";
	}
}
