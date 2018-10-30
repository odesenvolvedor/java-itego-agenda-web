package br.com.javaweb.jdbc.test;

import br.com.javaweb.jdbc.dao.ContatoDao;
import br.com.javaweb.jdbc.modelo.Contato;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestaAltera {

    public static void main(String[] args) {
       
        Contato contato = new Contato();
        Long id = new Long(2);
       
        //Seta uma data: (ano, mes, dia).
        //Detalhe no mes, o mês inicia a contagem do 0, ou seja, 0 é janeiro
        
        Calendar calendar = new GregorianCalendar(1985, 10, 6);

        contato.setId(id);
        contato.setNome("Java Web Alterado");
        contato.setEmail("contato@javaweb.com.br");
        contato.setEndereco("R. dos Javeiros 3185 cj87");
        contato.setDataNascimento(calendar);

        ContatoDao bd = new ContatoDao();

        bd.altera(contato);

        System.out.println("Alterado!");

    }

}
