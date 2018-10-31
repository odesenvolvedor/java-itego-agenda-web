package br.com.agenda.jdbc.test;

import br.com.agenda.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class TestaConexao {
    
    public static void main(String args[]) throws SQLException {    
        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Conexão aberta!");
        }        
    }
}
