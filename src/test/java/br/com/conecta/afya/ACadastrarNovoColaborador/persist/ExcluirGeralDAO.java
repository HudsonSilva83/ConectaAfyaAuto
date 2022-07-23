package br.com.conecta.afya.ACadastrarNovoColaborador.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.conecta.afya.model.script01ColaboradorParte1;
import br.com.conecta.afya.model.script03ColaboradorParte3;
import br.com.conecta.afya.utils.gerarData;
import br.com.conecta.afyaConnection.ConnectionFactory;

public class ExcluirGeralDAO {

	PreparedStatement stmt = null;
	Connection con;
	gerarData dataInsert = new gerarData();

	public void excluirGeral() {

		try {

			con = ConnectionFactory.getConnection();

			// agendamento
			stmt = con.prepareStatement(
					"delete from conectadev.t_agendamento where id_plataforma =(select (id_plataforma)from conectadev.t_colaborador  where cpf = '28612091004' order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_clinica where name = 'Clinica Automacao' order by id desc limit 1");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_ASO' where cpf = 28612091004 order by id_colaborador desc limit 1");
			stmt.executeUpdate();

			// Beneficios

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_BENEFICIOS' where cpf = 28612091004 order by id_colaborador desc limit 1");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_saude_dependente where saude_id = (select (id)from conectadev.t_saude where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = 28612091004 order by id_colaborador desc limit 1))");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_alimentacao  where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_odontologico_dependente where odontologico_id = (select (id)from conectadev.t_odontologico o where fk_colaborador = (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1))");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_odontologico where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_documento_dependente where dependente_id = (select (dep.id) from conectadev.t_dependente dep where fk_colaborador = (select (id_colaborador)from  conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1))");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_dependente where fk_colaborador = (select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_transporte where fk_colaborador =(select (id_colaborador)from conectadev.t_colaborador where cpf = 28612091004 order by id_colaborador desc limit 1)");
			stmt.executeUpdate();

			// Dados bancarios

			stmt = con.prepareStatement("update conectadev.t_documento set enabled = 'ENABLED_DADOS_BANCARIOS',"
					+ "agencia = null,img_comprovante_conta_bancaria = null,"
					+ "numero_conta = null,documentos_enviados =  0, dados_bancarios_cadastrados = 1 where fk_colaborador = (select (id_colaborador) from  conectadev.t_colaborador where  cpf = '28612091004' order by id_colaborador desc limit 1)");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_DADOS_BANCARIOS' where cpf = '28612091004' order by id_colaborador desc limit 1");

			stmt.executeUpdate();

			// documentos

			stmt = con.prepareStatement(
					"delete from conectadev.t_img_comprovante_escolaridade where fk_img_comprovante_escolaridade "
							+ "=(select (id)from conectadev.t_documento where fk_colaborador = (select (id_colaborador) from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1))");

			stmt.executeUpdate();

			stmt = con.prepareStatement("delete from conectadev.t_img_identidade where fk_img_identidade ="
					+ "(select (id)from conectadev.t_documento where fk_colaborador = (select (id_colaborador) from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1))");

			stmt.executeUpdate();

			stmt = con
					.prepareStatement("delete from  conectadev.t_img_carteira_trabalho where fk_img_carteira_trabalho ="
							+ "(select (id)from conectadev.t_documento where fk_colaborador = (select (id_colaborador) from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1))");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_documento where fk_colaborador =(select (id_colaborador) from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1)");

			stmt.executeUpdate();

			stmt = con.prepareStatement("insert into conectadev.t_documento"
					+ "(id, created_at, deleted, enabled, last_update, name, search, user_update, admissao, agencia, "
					+ "area, bairro,bairro_anterior, cargo, categoria_cert_reservista, categoria_cnh, complemento, cpf_cnh, "
					+ "data_emissao_carteira_trabalho,  data_emissao_identidade, data_nascimento, documento_corrigido, "
					+ "emissao_cnh, estado_civil, ferias, forma_pagamento,"
					+ "grau_escolaridade, horario, img_assinatura_contrato, img_assinatura_ficha, img_certidao_casamento, "
					+ "img_certidao_nascimento,  img_certificado_reservista, img_comprovante_conta_bancaria, img_comprovante_esocial, "
					+ "img_comprovante_residencia, img_comprovante_votacao, img_titulo_eleitor, img_tres_por_quatro, jornada,"
					+ " logradouro, logradouro_anterior, nacionalidade,  nome_banco, nome_mae, nome_pai, numero, numero_anterior,"
					+ " numero_carteira_trabalho, numero_cert_reservista, numero_conta,  numero_identidade, numero_pis, numero_titulo, "
					+ "opcao_fgts, orgao_emissao_identidade, orgao_emissor_cnh, periodo_aquisitivo,  periodo_gozo, registro_cnh,"
					+ " registro_profissional, salario, salario_hora, secao_titulo, serie_carteira_trabalho, status_retificacao, "
					+ "uf_carteira_trabalho, uf_emissao_identidade, zona_titulo, fk_tenant, fk_cidade, fk_cidade_anterior, "
					+ "fk_colaborador, fk_empresa, cidade_naturalidade, estado_naturalidade, data_emissao_titulo, uf_emissao_titulo,"
					+ " documentos_enviados,  complemento_anterior, chapa, cep, algum_doc_enviado, dados_bancarios_cadastrados,"
					+ " img_contrato_assinado)" + "values((select max(doc.id)+1 id from conectadev.t_documento doc),"
					+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ " ?, ?, ?, ? , ?, ?, ?, ?, ?, ?," + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ " ?, ?, ? , ?, ?, ?, ?, ?, ?, ?," + " ?,"
					+ "(select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			script03ColaboradorParte3 colaborador03 = new script03ColaboradorParte3();

			stmt.setString(1, dataInsert.gerarDataForm02());
			stmt.setInt(2, colaborador03.getDeleted());
			stmt.setString(3, colaborador03.getEnabled());
			stmt.setString(4, colaborador03.getLast_update());
			stmt.setString(5, colaborador03.getName());
			stmt.setString(6, colaborador03.getSearch());
			stmt.setString(7, colaborador03.getUser_update());
			stmt.setString(8, colaborador03.getAdmissao());
			stmt.setString(9, colaborador03.getAgencia());
			stmt.setString(10, colaborador03.getArea());
			stmt.setString(11, colaborador03.getBairro());
			stmt.setString(12, colaborador03.getBairro_anterior());
			stmt.setString(13, colaborador03.getCargo());
			stmt.setString(14, colaborador03.getCategoria_cert_reservista());
			stmt.setString(15, colaborador03.getCategoria_cnh());
			stmt.setString(16, colaborador03.getComplemento());
			stmt.setString(17, colaborador03.getCpf_cnh());
			stmt.setString(18, colaborador03.getData_emissao_carteira_trabalho());
			stmt.setString(19, colaborador03.getData_emissao_identidade());
			stmt.setString(20, colaborador03.getData_nascimento());
			stmt.setString(21, colaborador03.getDocumento_corrigido());
			stmt.setString(22, colaborador03.getEmissao_cnh());
			stmt.setString(23, colaborador03.getEstado_civil());
			stmt.setString(24, colaborador03.getFerias());
			stmt.setString(25, colaborador03.getForma_pagamento());
			stmt.setString(26, colaborador03.getGrau_escolaridade());
			stmt.setString(27, colaborador03.getHorario());
			stmt.setString(28, colaborador03.getImg_assinatura_contrato());
			stmt.setString(29, colaborador03.getImg_assinatura_ficha());
			stmt.setString(30, colaborador03.getImg_certidao_casamento());
			stmt.setString(31, colaborador03.getImg_certidao_nascimento());
			stmt.setString(32, colaborador03.getImg_certificado_reservista());
			stmt.setString(33, colaborador03.getImg_comprovante_conta_bancaria());
			stmt.setString(34, colaborador03.getImg_comprovante_esocial());
			stmt.setString(35, colaborador03.getImg_comprovante_residencia());
			stmt.setString(36, colaborador03.getImg_comprovante_votacao());
			stmt.setString(37, colaborador03.getImg_titulo_eleitor());
			stmt.setString(38, colaborador03.getImg_tres_por_quatro());
			stmt.setString(39, colaborador03.getJornada());
			stmt.setString(40, colaborador03.getLogradouro());
			stmt.setString(41, colaborador03.getLogradouro_anterior());
			stmt.setString(42, colaborador03.getNacionalidade());
			stmt.setString(43, colaborador03.getNome_banco());
			stmt.setString(44, colaborador03.getNome_mae());
			stmt.setString(45, colaborador03.getNome_pai());
			stmt.setString(46, colaborador03.getNumero());
			stmt.setString(47, colaborador03.getNumero_anterior());
			stmt.setString(48, colaborador03.getNumero_carteira_trabalho());
			stmt.setString(49, colaborador03.getNumero_cert_reservista());
			stmt.setString(50, colaborador03.getNumero_conta());
			stmt.setString(51, colaborador03.getNumero_identidade());
			stmt.setString(52, colaborador03.getNumero_pis());
			stmt.setString(53, colaborador03.getNumero_titulo());
			stmt.setString(54, colaborador03.getOpcao_fgts());
			stmt.setString(55, colaborador03.getOrgao_emissao_identidade());
			stmt.setString(56, colaborador03.getOrgao_emissor_cnh());
			stmt.setString(57, colaborador03.getPeriodo_aquisitivo());
			stmt.setString(58, colaborador03.getPeriodo_gozo());
			stmt.setString(59, colaborador03.getRegistro_cnh());
			stmt.setString(60, colaborador03.getRegistro_profissional());
			stmt.setString(61, colaborador03.getSalario());
			stmt.setString(62, colaborador03.getSalario_hora());
			stmt.setString(63, colaborador03.getSecao_titulo());
			stmt.setString(64, colaborador03.getSerie_carteira_trabalho());
			stmt.setString(65, colaborador03.getStatus_retificacao());
			stmt.setString(66, colaborador03.getUf_carteira_trabalho());
			stmt.setString(67, colaborador03.getUf_emissao_identidade());
			stmt.setString(68, colaborador03.getZona_titulo());
			stmt.setString(69, colaborador03.getFk_tenant());
			stmt.setString(70, colaborador03.getFk_cidade());
			stmt.setString(71, colaborador03.getFk_cidade_anterior());
			stmt.setInt(72, colaborador03.getFk_empresa());
			stmt.setString(73, colaborador03.getCidade_naturalidade());
			stmt.setString(74, colaborador03.getEstado_naturalidade());
			stmt.setString(75, colaborador03.getData_emissao_titulo());
			stmt.setString(76, colaborador03.getUf_emissao_titulo());
			stmt.setString(77, colaborador03.getDocumentos_enviados());
			stmt.setString(78, colaborador03.getComplemento_anterior());
			stmt.setString(79, colaborador03.getChapa());
			stmt.setString(80, colaborador03.getCep());
			stmt.setString(81, colaborador03.getAlgum_doc_enviado());
			stmt.setInt(82, colaborador03.getDados_bancarios_cadastrados());
			stmt.setString(83, colaborador03.getImg_assinatura_contrato());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set enabled = 'ENABLED_CADASTRO' where cpf = 28612091004 order by id_colaborador desc limit 1");

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_user_deficiencia where fk_user_deficiencia =(select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1)");

			script01ColaboradorParte1 parte01 = new script01ColaboradorParte1();

			stmt.setString(1, parte01.getCPF());
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_alimentacao where fk_colaborador = (select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1)");

			stmt.setString(1, parte01.getCPF());
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_saude where fk_colaborador = (select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1)");

			stmt.setString(1, parte01.getCPF());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_documento where fk_colaborador = (select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1)");

			stmt.setString(1, parte01.getCPF());
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_user_auth_role where fk_user = (select(id) from  conectadev.t_user_auth where fk_colaborador = (select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1))");

			stmt.setString(1, parte01.getCPF());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_user_auth_device where fk_user = (select (id)from conectadev.t_user_auth where fk_colaborador = (select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1))");

			stmt.setString(1, parte01.getCPF());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from  conectadev.t_user_auth where fk_colaborador = (select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1)");

			stmt.setString(1, parte01.getCPF());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_colaborador  where cpf = ? order by id_colaborador desc limit 1");

			stmt.setString(1, parte01.getCPF());

			stmt.executeUpdate();

			System.out.println("apaguei sim");
			// JOptionPane.showMessageDialog(null, "EXCLUÍMOS A PORRA TODA");

		} catch (SQLException e1) {
			// JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e1);
			// e1.printStackTrace();
			System.out.println("Teve nada pra apagar");

		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

}
