package br.com.caelum.jdbc.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import br.com.caelum.jdbc.ConnectionFactory;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos"
				+ "nome, email, endereco,dataNascimento"
				+ "values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,  contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
