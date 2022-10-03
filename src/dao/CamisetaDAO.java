package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Camiseta;

public class CamisetaDAO {
	private Connection connection;
	
	public CamisetaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Camiseta c) {
		int inseriu = 0;
		String sql = "INSERT INTO Camiseta VALUES (?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getCodigo());
			stmt.setString(2, c.getTamanho());
			stmt.setString(3, c.getCor());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
}
