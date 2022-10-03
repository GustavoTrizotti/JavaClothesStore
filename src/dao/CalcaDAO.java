package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Calca;
import bean.Roupa;

public class CalcaDAO {
	private Connection connection;
	
	public CalcaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Calca c) {
		int inseriu = 0;
		String sql = "INSERT INTO Calca VALUES (?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getCodigo());
			stmt.setInt(2, c.getNumero());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
}
