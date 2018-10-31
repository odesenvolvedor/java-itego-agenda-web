package br.com.agenda.jdbc.test;

import java.util.Calendar;

import br.com.agenda.jdbc.dao.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaInsere {

    public static void main(String[] args) {

        Contato contato = new Contato();

        contato.setNome("Elaine Rodrigues");
        contato.setEmail("elaininha_p2@hotmail.com");
        contato.setEndereco("Cond. Torres do Mirante");
        contato.setDataNascimento(Calendar.getInstance());

        ContatoDao bd = new ContatoDao();

        bd.adiciona(contato);

        System.out.println("Gravado!");
        
    }
}
