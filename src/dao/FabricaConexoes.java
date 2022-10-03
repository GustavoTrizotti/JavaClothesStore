package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	public Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3066/lojaroupa?useSSL=false", "root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}