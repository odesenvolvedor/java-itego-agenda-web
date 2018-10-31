package br.com.agenda.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.agenda.jdbc.ConnectionFactory;

public class TestaInserePrimeiro {

    public static void main(String[] args) throws SQLException {
        String nome = "Java Web";     
        String email = "contato@javaweb.com.br";
        String endereco = "R. dos Javeiros 3185 cj87";
        String dataNascimento = "1980-10-02";

        Connection connection = new ConnectionFactory().getConnection();        
        
        String sql
                = "insert into contatos "
                + "(nome,email,endereco, dataNascimento)"
                + " values ('"
                + nome
                + "', '"
                + email
                + "', '"
                + endereco
                + "', '"
                + dataNascimento
                + "')";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Gravado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        
    }
}
