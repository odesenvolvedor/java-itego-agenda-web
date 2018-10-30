package br.com.javaweb.jdbc.test;

import br.com.javaweb.jdbc.dao.ContatoDao;
import br.com.javaweb.jdbc.modelo.Contato;

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
