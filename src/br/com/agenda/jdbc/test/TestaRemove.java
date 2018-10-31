package br.com.agenda.jdbc.test;

import br.com.agenda.jdbc.dao.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaRemove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Long id = new Long(4);
        Contato contato = new Contato();
        contato.setId(id);
        
        ContatoDao bd = new ContatoDao();
        
        bd.remove(contato);
        
        System.out.println("Removido!");
    }
    
}
