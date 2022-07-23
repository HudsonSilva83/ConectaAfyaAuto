package br.com.conecta.afya.ACadastrarNovoColaborador.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.conecta.afya.utils.gerarData;
import br.com.conecta.afyaConnection.ConnectionFactory;

public class ExameAdmissionalDAO {

	public void agendarExemaAdmissional() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			con = ConnectionFactory.getConnection();

			stmt = con.prepareStatement(
					"insert into conectadev.t_clinica (id,endereco,name,telefone) values ((select max(c.id)+1 id from conectadev.t_clinica c),'Rua da Automacao 999','Clinica Automacao','31999999999')");
			stmt.executeUpdate();

			gerarData dataInsert = new gerarData();
			stmt = con.prepareStatement(
					"insert conectadev.t_agendamento (id,created_at,deleted,enabled,last_update,name,search,user_update,data_exame,"
							+ "id_plataforma,img_comprovante_exame,justificativa_status,status_comprovante,status_exame,fk_tenant,fk_clinica)values("
							+ "(select max(a.id)+1 id from conectadev.t_agendamento a),?,0,null,null,null,null,null,?,"
							+ "(select (id_plataforma) from conectadev.t_colaborador where cpf ='28612091004' order by id_colaborador desc limit 1),"
							+ "null,null,'NAO_ENVIADO','EXAME_AGENDADO',null,(select(id) from conectadev.t_clinica where name = 'Clinica Automacao' order by id desc limit 1))");

			stmt.setString(1, dataInsert.gerarDataForm02());
			stmt.setString(2, dataInsert.gerarDataForm01());

			stmt.executeUpdate();

			System.out.println("agendado com sucesso");
			//JOptionPane.showMessageDialog(null, "agendado com sucesso");

		} catch (SQLException e1) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e1);
			e1.printStackTrace();
			System.out.println("erro ao cadastrar exame " + e1);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	public void confirmarEnviarExemaAdmissional() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			con = ConnectionFactory.getConnection();

			stmt = con.prepareStatement(
					"update conectadev.t_agendamento set status_exame = 'DISPONIVEL' where  id_plataforma = (select (id_plataforma) from conectadev.t_colaborador where cpf ='28612091004' order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_agendamento set img_comprovante_exame = 'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F14636167082%2Faso-img.jpeg',"
							+ "status_comprovante = 'COMPROVANTE_EM_ANALISE',"
							+ "status_exame = 'COMPROVANTE_ENVIADO' where id_plataforma = (select (id_plataforma) from conectadev.t_colaborador where cpf ='28612091004' order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_agendamento set status_comprovante = 'COMPROVANTE_OK' where id_plataforma = (select (id_plataforma) from conectadev.t_colaborador where cpf ='28612091004' order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_DOCUMENTO_ADMISSIONAL' where cpf = 28612091004 order by id_colaborador desc limit 1");

			stmt.executeUpdate();

			//JOptionPane.showMessageDialog(null, "confirmado e enviado com sucesso");

		} catch (SQLException e1) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e1);
			e1.printStackTrace();
			System.out.println("erro ao cadastrar exame " + e1);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	public void aprovarExemaAdmissional() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			con = ConnectionFactory.getConnection();

			stmt = con.prepareStatement(
					"update conectadev.t_agendamento set status_comprovante = 'COMPROVANTE_OK' where id_plataforma = (select (id_plataforma) from conectadev.t_colaborador where cpf ='28612091004' order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_DOCUMENTO_ADMISSIONAL' where cpf = 28612091004 order by id_colaborador desc limit 1");

			stmt.executeUpdate();
			System.out.println("aprovado com sucesso");
			//JOptionPane.showMessageDialog(null, "aprovado com sucesso");

		} catch (SQLException e1) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e1);
			e1.printStackTrace();
			System.out.println("erro ao cadastrar exame " + e1);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

//	 public void aprovarExemaAdmissional() throws SQLException {
//	
//	 Connection con = ConnectionFactory.getConnection();
//	 PreparedStatement stmt = null;
//	
//	 try {
//	
//	 con = ConnectionFactory.getConnection();
//	
//	 stmt = con.prepareStatement("insert into conectadev.t_clinica (id,endereco,name,telefone) values((select max(c.id)+1 id from conectadev.t_clinica c),'Rua daautomacao','Clinica Automacao','31999999999')");
//	 stmt.executeUpdate();
//	
//	 gerarData dataInsert = new gerarData();
//	 stmt = con.prepareStatement("insert conectadev.t_agendamento
//	 (id,created_at,deleted,enabled,last_update,name,search,user_update,data_exame,"
//	 +
//	 "id_plataforma,img_comprovante_exame,justificativa_status,status_comprovante,status_exame,fk_tenant,fk_clinica)values("
//	 + "(select max(a.id)+1 id from conectadev.t_agendamento
//	 a),?,0,null,null,null,null,null,?,"
//	 + "(select (id_plataforma) from conectadev.t_colaborador where cpf
//	 ='28612091004' order by id_colaborador desc limit 1),"
//	 + "null,null,'NAO_ENVIADO','EXAME_AGENDADO',null,(select(id) from
//	 conectadev.t_clinica where name = 'Clinica Automacao' order by id desc
//	 limit 1))");
//	
//	 stmt.setString(1, dataInsert.gerarDataForm02());
//	 stmt.setString(2, dataInsert.gerarDataForm01());
//	
//	
//	 stmt.executeUpdate();
//	
//	 stmt = con.prepareStatement(
//	 "update conectadev.t_agendamento set status_exame = 'DISPONIVEL' where
//	 id_plataforma = (select (id_plataforma) from conectadev.t_colaborador
//	 where cpf ='28612091004' order by id_colaborador desc limit 1)");
//	 stmt.executeUpdate();
//	
//	 stmt = con.prepareStatement("update conectadev.t_agendamento set
//	 img_comprovante_exame =
//	 'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F14636167082%2Faso-img.jpeg',"
//	 + "status_comprovante = 'COMPROVANTE_EM_ANALISE',"
//	 + "status_exame = 'COMPROVANTE_ENVIADO' where id_plataforma = (select
//	 (id_plataforma) from conectadev.t_colaborador where cpf ='28612091004'
//	 order by id_colaborador desc limit 1)");
//	 stmt.executeUpdate();
//	
//	 stmt = con.prepareStatement(
//	 "update conectadev.t_agendamento set status_comprovante =
//	 'COMPROVANTE_OK' where id_plataforma = (select (id_plataforma) from
//	 conectadev.t_colaborador where cpf ='28612091004' order by id_colaborador
//	 desc limit 1)");
//	 stmt.executeUpdate();
//	
//	 stmt = con.prepareStatement(
//	 "update conectadev.t_colaborador set enabled =
//	 'ENABLED_DOCUMENTO_ADMISSIONAL' where cpf = 28612091004 order by
//	 id_colaborador desc limit 1");
//	
//	 stmt.executeUpdate();
//	
//	 JOptionPane.showMessageDialog(null, "Salvo com sucesso");
//	
//	 } catch (SQLException e1) {
//	 // JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e1);
//	 e1.printStackTrace();
//	 System.out.println("erro ao cadastrar exame " + e1);
//	
//	 } finally {
//	 ConnectionFactory.closeConnection(con, stmt);
//	
//	 }
//	
//	 }

	public void deletarExemaAdmissional() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(
					"delete from conectadev.t_agendamento where id_plataforma =(select (id_plataforma)from conectadev.t_colaborador  where cpf = '28612091004' order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_clinica where name = 'Clinica Automacao' order by id desc limit 1");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_ASO' where cpf = 28612091004 order by id_colaborador desc limit 1");
			stmt.executeUpdate();
System.out.println("deletado com sucesso");
			//JOptionPane.showMessageDialog(null, "deletado com sucesso");

		} catch (SQLException e1) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e1);
			//e1.printStackTrace();
			System.out.println("erro ao deletar o exame ");// + //e1);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

}
