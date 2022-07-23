package br.com.conecta.afya.ACadastrarNovoColaborador.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.conecta.afyaConnection.ConnectionFactory;

public class CadastroBeneficiosDAO {

	public void cadastrarBeneficios() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(
					"insert into conectadev.t_transporte (id, confirma_mesmo_trajeto_ida_volta, deleted, linha_ou_empresa,tipo_trajeto,"
							+ "tipo_transporte, valor_tarifa, fk_colaborador,img_adesao_vale_transporte)"
							+ "values((select max(T.id)+1 id from conectadev.t_transporte T),1, 0, 'Transporte Banco', 'IDA',"
							+ "'ONIBUS', '1', (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1),"
							+ "'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F28612091004%2Fadesao-vale-transporte.pdf')");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"insert into conectadev.t_transporte(id, confirma_mesmo_trajeto_ida_volta, deleted, linha_ou_empresa, tipo_trajeto, tipo_transporte, valor_tarifa, fk_colaborador, img_adesao_vale_transporte)values((select max(T.id)+1 id from conectadev.t_transporte T)"
							+ ",1, 0, 'Transporte Banco', 'VOLTA', 'ONIBUS', '1', (select(id_colaborador)from conectadev.t_colaborador where cpf =28612091004 order by id_colaborador desc limit 1),'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F28612091004%2Fadesao-vale-transporte.pdf')");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"insert into conectadev.t_odontologico (id, deleted, incluir_dependente, tipo_plano_odontologico, fk_colaborador, fk_plano_odontologico, img_adesao_plano_odontologico, desconto_mensal) values "
							+ "((select max(O.id)+1 id from conectadev.t_odontologico O),0,1, 'ESSENCIAL_PLUS', (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1), 1, 'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F28612091004%2Fadesao-plano-odontologico.pdf','27.68')");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"insert into conectadev.t_dependente(id, created_at, deleted, enabled, last_update, name, search,user_update, cpf_dependente, data_nascimento_dependente, grau_dependencia, img_carteirinha_vacinacao,"
							+ "img_certidao_nascimento, irrf_dependencia, nome_dependente,fk_tenant, fk_colaborador, porcentagem_part_beneficio, idade,img_comprovante, img_comprovante_dependencia,img_comprovante_ensino_superior, img_relatorio_medico,img_termo_cautela, img_termo_judicial_tutela) "
							+ "values ((select max(d.id)+1 id from conectadev.t_dependente d),NULL, 0, NULL, NULL, NULL, NULL, NULL, '95104364020','2000-01-01 00:00:00',"
							+ " 'CONJUGE', NULL, NULL, NULL, 'Banco Conjuge', NULL,(select(id_colaborador)from conectadev.t_colaborador where cpf =28612091004 order by id_colaborador desc limit 1), NULL, NULL,NULL, NULL, NULL, NULL, NULL, NULL)");

			stmt.executeUpdate();

			stmt = con.prepareStatement("insert into conectadev.t_documento_dependente (documento_id, dependente_id) "
					+ "values ((select (id)from conectadev.t_documento where fk_colaborador = (select(id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)),"
					+ "(select (dep.id) from conectadev.t_dependente dep where fk_colaborador ="
					+ "(select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)))");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"insert into conectadev.t_alimentacao (id, deleted, desconto_mes, tipo_alimentacao, valerefeicao_e_valealimentacao, valor_alimentacao_mes, valor_restaurante_dia_util, valor_total_estimado_mes, fk_colaborador, img_adesao_alimentacao) "
							+ "values ((select max(a.id)+1 id from conectadev.t_alimentacao  a),0, 5, NULL, 0, '569.36', '25.88', '569.36', (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1), NULL)");

			stmt.executeUpdate();

			stmt = con.prepareStatement("update conectadev.t_alimentacao set tipo_alimentacao = 'INTEGRAL_ALIMENTACAO',"
					+ "img_adesao_alimentacao = 'https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F28612091004%2Fadesao-alimentacao-refeicao-afya.pdf'"
					+ "where fk_colaborador = (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)");

			stmt.executeUpdate();

			stmt = con.prepareStatement("insert into conectadev.t_saude_dependente (saude_id, dependente_id) values"
					+ "((select id from conectadev.t_saude where fk_colaborador = (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)), "
					+ "(select (dep.id) from conectadev.t_dependente dep where fk_colaborador = "
					+ "(select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)))");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_ASO' where cpf = 28612091004 order by id_colaborador desc limit 1");

			stmt.executeUpdate();

			//JOptionPane.showMessageDialog(null, "salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	public void deletarBeneficios() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("update conectadev.t_colaborador set enabled = 'ENABLED_BENEFICIOS' where cpf = 28612091004 order by id_colaborador desc limit 1");
			stmt.executeUpdate();

			stmt = con.prepareStatement("delete from conectadev.t_saude_dependente where saude_id = (select (id)from conectadev.t_saude where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = 28612091004 order by id_colaborador desc limit 1))");
			stmt.executeUpdate();

			stmt = con.prepareStatement("delete from conectadev.t_alimentacao  where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement("delete from conectadev.t_odontologico_dependente where odontologico_id = (select (id)from conectadev.t_odontologico o where fk_colaborador = (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1))");
			stmt.executeUpdate();

			stmt = con.prepareStatement("delete from conectadev.t_odontologico where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();
			
			
			stmt = con.prepareStatement("delete from conectadev.t_documento_dependente where dependente_id = (select (dep.id) from conectadev.t_dependente dep where fk_colaborador = (select (id_colaborador)from  conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1))");
			stmt.executeUpdate();

			stmt = con.prepareStatement("delete from conectadev.t_dependente where fk_colaborador = (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

    		stmt = con.prepareStatement("delete from conectadev.t_transporte where fk_colaborador =(select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)");
    		stmt.executeUpdate();
    		
			//JOptionPane.showMessageDialog(null, "salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

}
