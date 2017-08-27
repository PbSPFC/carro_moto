package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/carro", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
