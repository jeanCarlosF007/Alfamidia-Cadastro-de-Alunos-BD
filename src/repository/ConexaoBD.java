package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	private static Connection connection;
	private static final String URL = "jdbc:mysql://localhost:3306/exercicios_aula_12";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public static Connection obterConexao() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			}
			return connection;
		} catch (SQLException e) {
			System.out.println("Erro ao obter conexão: " + e.getMessage());
		}
		return null;
	}
	
	public static void fecharConexao() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão: " + e.getMessage());
		}
		
	}

}
