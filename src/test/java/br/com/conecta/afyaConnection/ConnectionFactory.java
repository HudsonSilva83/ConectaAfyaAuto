package br.com.conecta.afyaConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://mysqlafyaeua.mysql.database.azure.com:3306/conectadev?";
	private static final String user = "user_conectadev@mysqlafyaeua";
	private static final String password = "5?SWuTx%";
	
	
	//String url = "jdbc:mysql://mysqlafyaeua.mysql.database.azure.com:3306/conectadev?user=user_conectadev@mysqlafyaeua&password=5?SWuTx%25";
	

	public static Connection getConnection() throws SQLException {

		try {
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(DRIVER);

			System.out.println("Conectado com sucesso");
			//JOptionPane.showMessageDialog(null, "Conectado com sucesso Hudson parabêns");
			
			return DriverManager.getConnection(URL, user, password);
			
			
			

		} catch (ClassNotFoundException e) {

			throw new RuntimeException("Erro na connexao: ", e);

		}

	}

	public static void closeConnection(Connection con) {

		try {

			if (con != null) {

				con.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {

		closeConnection(con);

		try {

			if (stmt != null) {

				stmt.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

		closeConnection(con, stmt);

		try {

			if (rs != null) {

				rs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
