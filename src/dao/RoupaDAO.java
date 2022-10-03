package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cliente;
import bean.Roupa;

public class RoupaDAO {
	private Connection connection;
	
	public RoupaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Roupa r) {
		int inseriu = 0;
		String sql = "INSERT INTO Roupa VALUES (?, ?, null);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, r.getCodigo());
			stmt.setDouble(2, r.getPreco());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}

	public ArrayList<Roupa> getCodigos() {
		String sql = "SELECT codigo FROM Roupa;";
		PreparedStatement stmt;
		Roupa r;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Roupa> codigos = new ArrayList<>();
			while (rs.next()) {
				r = new Roupa();
				r.setCodigo(rs.getInt("codigo"));
				codigos.add(r);
			}
			rs.close();
			stmt.close();
			return codigos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
