package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Cliente;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Cliente c) {
		int inseriu = 0;
		String sql = "INSERT INTO Cliente VALUES (?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
}
