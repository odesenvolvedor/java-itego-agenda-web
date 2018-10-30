package br.com.javaweb.jdbc.test;

import br.com.javaweb.jdbc.dao.ContatoDao;
import br.com.javaweb.jdbc.modelo.Contato;
import java.util.Calendar;

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
