package br.com.agenda.jdbc.test;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.agenda.jdbc.dao.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaLista {

    public static void main(String[] args) {
        ContatoDao contatoDao = new ContatoDao();

        List<Contato> contatos = contatoDao.getLista();
        
        TestaLista test = new TestaLista();
        //test.iteraNormal(contatos);
        test.iteraFuncional(contatos);
    }
    
    private void iteraNormal(List<Contato> contatos) {
        for (Contato contato : contatos) {
            System.out.println("ID #" + contato.getId());
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data de Nascimento: "
                               + contato.getDataNascimento().getTime()
                               + "\n");            
        }        
    }
    
    private void iteraFuncional(List<Contato> contatos) {
        contatos.forEach((contato) -> {
            
            //Formatar data para brasileiro
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyy");	
            
            System.out.println("ID #" + contato.getId());
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data de Nascimento: " 
                    + sdf.format(contato.getDataNascimento().getTime()) 
                    + "\n");            
        });
    }
    
}
