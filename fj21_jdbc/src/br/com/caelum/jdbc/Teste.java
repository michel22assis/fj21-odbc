package br.com.caelum.jdbc;

import br.com.caelum.jdbc.modelo.Contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao aberta!");
		connection.close();
		
		Contato c = new Contato();
		c.setNome("Francisco Michel");
		System.out.println(c.getNome());
		
		
		
	}
}