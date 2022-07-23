package br.com.conecta.afyaConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {

	public Connection conectaBD() {

		Connection conn = null;

		try {
             //https://www.youtube.com/watch?v=1OmhFEhav-8
			//https://www.youtube.com/watch?v=b5RZkC_gVVI
			String url = "jdbc:mysql://mysqlafyaeua.mysql.database.azure.com:3306/conectadev?user=user_conectadev@mysqlafyaeua&password=5?SWuTx%25";
			conn = DriverManager.getConnection(url);
			System.out.println("Conectou mannn!!" + url);
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro na Classe ConexaoDAO: " + e.getMessage());

		}

		return conn;

	}

}
