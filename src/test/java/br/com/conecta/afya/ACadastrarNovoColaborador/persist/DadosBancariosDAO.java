package br.com.conecta.afya.ACadastrarNovoColaborador.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.conecta.afyaConnection.ConnectionFactory;

public class DadosBancariosDAO {

	public void cadastrarDadosBancarios() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update conectadev.t_documento set enabled = 'ENABLED_BENEFICIOS',"
					+ "agencia = '001',img_comprovante_conta_bancaria = 'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F28612091004%2Fcomprovante-conta-bancaria-img.jpg',"
					+ "numero_conta = '0003001',documentos_enviados =  1, dados_bancarios_cadastrados = 1 where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = '28612091004' order by id_colaborador desc limit 1)");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_BENEFICIOS' where cpf = '28612091004' order by id_colaborador desc limit 1");

			stmt.executeUpdate();

			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	public void deletarDadosBancarios() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update conectadev.t_documento set enabled = 'ENABLED_DADOS_BANCARIOS',"
					+ "agencia = null,img_comprovante_conta_bancaria = null,"
					+ "numero_conta = null,documentos_enviados =  0, dados_bancarios_cadastrados = 1 where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = '28612091004' order by id_colaborador desc limit 1)");

			stmt.executeUpdate();
			
			
			//JOptionPane.showMessageDialog(null, "salvo com sucesso");
			
			stmt = con.prepareStatement("update conectadev.t_colaborador set enabled = 'ENABLED_DADOS_BANCARIOS' where cpf = '28612091004' order by id_colaborador desc limit 1");
			
			stmt.executeUpdate();
			
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

}
