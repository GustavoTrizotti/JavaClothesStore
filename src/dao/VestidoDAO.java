package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Roupa;
import bean.Vestido;

public class VestidoDAO {
	private Connection connection;
	
	public VestidoDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Vestido v) {
		int inseriu = 0;
		String sql = "INSERT INTO Vestido VALUES (?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, v.getCodigo());
			stmt.setString(2, v.getEstampa());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
}
