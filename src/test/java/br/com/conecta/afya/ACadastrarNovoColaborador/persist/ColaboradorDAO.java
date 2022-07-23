package br.com.conecta.afya.ACadastrarNovoColaborador.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.conecta.afya.model.scriptColaboradorObterIdColaborador;
import br.com.conecta.afya.utils.gerarData;
import br.com.conecta.afya.model.script01ColaboradorParte1;
import br.com.conecta.afya.model.script02ColaboradorParte2;
import br.com.conecta.afya.model.script03ColaboradorParte3;
import br.com.conecta.afya.model.script04ColaboradorParte4;
import br.com.conecta.afya.model.script05ColaboradorParte5;
import br.com.conecta.afya.model.script06ColaboradorParte6;
import br.com.conecta.afya.model.script07ColaboradorParte7;
import br.com.conecta.afya.model.script08ColaboradorParte8;
import br.com.conecta.afya.model.script09ColaboradorParte9;
import br.com.conecta.afyaConnection.ConnectionFactory;

public class ColaboradorDAO {

	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	int idCol;

	gerarData dataInsert = new gerarData();

	public void cadastrarColaborador() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(
					"insert into conectadev.t_colaborador (id_colaborador,created_at,deleted,enabled,last_update,name, search, user_update, apelido, cargo, coligada, confirma_gympass, confirma_kit_admissional, confirma_plano_odontologico, confirma_plano_saude, confirma_vale_alimentacao, confirma_vale_transporte, cor, cpf, dat_alteracao, dat_insercao, email, filial, genero, id_plataforma, assinatura, login, nome_social, senha, status_correcao, telefone, tipo_admissao, token, unidade, fk_tenant, confirma_seguro_de_vida, data_admissao, confirma_cetificado_reservista, salario, t_colaboradorcol, chamado_beneficios, img_contrato_individual)"
							+ "VALUES"
							+ "((select max(C.id_colaborador)+1 id_colaborador from conectadev.t_colaborador C)"
							+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			script01ColaboradorParte1 colaborador01 = new script01ColaboradorParte1();

			stmt.setString(1, dataInsert.gerarDataForm02());
			// stmt.setString(1, colaborador01.getCreated_at());
			stmt.setInt(2, colaborador01.getDeleted());
			stmt.setString(3, colaborador01.getEnabled());
			stmt.setString(4, colaborador01.getLast_update());
			stmt.setString(5, colaborador01.getName());
			stmt.setString(6, colaborador01.getSearch());
			stmt.setString(7, colaborador01.getUser_update());
			stmt.setString(8, colaborador01.getApelido());
			stmt.setString(9, colaborador01.getCargo());
			stmt.setInt(10, colaborador01.getColigada());
			stmt.setString(11, colaborador01.getConfirma_gympass());
			stmt.setInt(12, colaborador01.getConfirma_kit_admissional());
			stmt.setInt(13, colaborador01.getConfirma_plano_odontologico());
			stmt.setInt(14, colaborador01.getConfirma_plano_saude());
			stmt.setInt(15, colaborador01.getConfirma_vale_alimentacao());
			stmt.setInt(16, colaborador01.getConfirma_vale_transporte());
			stmt.setString(17, colaborador01.getCor());
			stmt.setString(18, colaborador01.getCPF());
			stmt.setString(19, dataInsert.gerarDataForm02());
			stmt.setString(20, dataInsert.gerarDataForm02());
			stmt.setString(21, colaborador01.getEmail());
			stmt.setInt(22, colaborador01.getFilial());
			stmt.setString(23, colaborador01.getGenero());
			stmt.setString(24, colaborador01.getId_plataforma());
			stmt.setString(25, colaborador01.getAssinatura());
			stmt.setString(26, colaborador01.getLogin());
			stmt.setString(27, colaborador01.getNome_social());
			stmt.setString(28, colaborador01.getSenha());
			stmt.setString(29, colaborador01.getStatus_correcao());
			stmt.setString(30, colaborador01.getTelefone());
			stmt.setString(31, colaborador01.getTipo_admissao());
			stmt.setString(32, colaborador01.getToken());
			stmt.setString(33, colaborador01.getUnidade());
			stmt.setString(34, colaborador01.getFk_tenant());
			stmt.setInt(35, colaborador01.getConfirma_seguro_de_vida());
			stmt.setString(36, colaborador01.getData_admissao());
			stmt.setString(37, colaborador01.getConfirma_cetificado_reservista());
			stmt.setString(38, colaborador01.getSalario());
			stmt.setString(39, colaborador01.getT_colaboradorcol());
			stmt.setString(40, colaborador01.getChamado_beneficios());
			stmt.setString(41, colaborador01.getImg_contrato_individual());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"insert into conectadev.t_user_auth (id, created_at, deleted, enabled, last_update, name, search, user_update, codigo_verificacao, crypt_password, login, password, fk_tenant, fk_colaborador) VALUES ((select max(A.id)+1 id from conectadev.t_user_auth A),?,?,?,?,?,?,?,?,?,?,?,?,(select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1))");

			script02ColaboradorParte2 colaborador02 = new script02ColaboradorParte2();

			stmt.setString(1, dataInsert.gerarDataForm02());
			stmt.setInt(2, colaborador02.getDeleted());
			stmt.setString(3, colaborador02.getEnabled());
			stmt.setString(4, dataInsert.gerarDataForm02());
			stmt.setString(5, colaborador02.getName());
			stmt.setString(6, colaborador02.getSearch());
			stmt.setString(7, colaborador02.getUser_update());
			stmt.setString(8, colaborador02.getCodigo_verificacao());
			stmt.setInt(9, colaborador02.getCrypt_password());
			stmt.setString(10, colaborador02.getLogin());
			stmt.setString(11, colaborador02.getPassword());
			stmt.setString(12, colaborador02.getFk_tenant());

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

			stmt = con.prepareStatement("insert into conectadev.t_user_auth_role (fk_user, role) values"
					+ "((select id from conectadev.t_user_auth where fk_colaborador = "
					+ "(select (id_colaborador)from conectadev.t_colaborador where cpf = " + colaborador01.getCPF()
					+ " order by id_colaborador desc limit 1)),?)");

			script04ColaboradorParte4 colaborador04 = new script04ColaboradorParte4();
			stmt.setInt(1, colaborador04.getRole());

			stmt.executeUpdate();

			stmt = con.prepareStatement("insert into conectadev.t_saude (id, deleted, incluir_dependente,"
					+ "plano_saude, unidade_plano_saude, fk_colaborador,img_adesao_plano_saude, valor, desconto_mensal)"
					+ "values ((select max(s.id)+1 from conectadev.t_saude s),?,?,?,?,(select id_colaborador from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1),?,?,?)");

			script05ColaboradorParte5 colaborador05 = new script05ColaboradorParte5();

			stmt.setInt(1, colaborador05.getDeleted());
			stmt.setString(2, colaborador05.getIncluir_dependente());
			stmt.setString(3, colaborador05.getPlano_saude());
			stmt.setString(4, colaborador05.getUnidade_plano_saude());

			stmt.setString(5, colaborador05.getImg_adesao_plano_saude());
			stmt.setString(6, colaborador05.getValor());
			stmt.setInt(7, colaborador05.getDesconto_mensal());

			stmt.executeUpdate();

			stmt = con.prepareStatement("insert into conectadev.t_alimentacao (id, deleted, desconto_mes,"
					+ " tipo_alimentacao, valerefeicao_e_valealimentacao,"
					+ "valor_alimentacao_mes,valor_restaurante_dia_util,"
					+ "valor_total_estimado_mes,fk_colaborador, img_adesao_alimentacao)"
					+ "values((select max(a.id)+1 id from conectadev.t_alimentacao a),?,?,?,?,?,?,?,(select id_colaborador from conectadev.t_colaborador where cpf = '28612091004' order by id_colaborador desc limit 1),?)");

			script06ColaboradorParte6 colaborador06 = new script06ColaboradorParte6();

			stmt.setInt(1, colaborador06.getDeleted());
			stmt.setInt(2, colaborador06.getDesconto_mes());
			stmt.setString(3, colaborador06.getTipo_alimentacao());
			stmt.setInt(4, colaborador06.getValerefeicao_e_valealimentacao());
			stmt.setString(5, colaborador06.getValor_alimentacao_mes());
			stmt.setString(6, colaborador06.getValor_restaurante_dia_util());
			stmt.setString(7, colaborador06.getValor_total_estimado_mes());
			stmt.setString(8, colaborador06.getImg_adesao_alimentacao());

			stmt.executeUpdate();

			script07ColaboradorParte7 colaborador07 = new script07ColaboradorParte7();

			stmt = con.prepareStatement("insert into conectadev.t_user_deficiencia (fk_user_deficiencia, deficiencia)"
					+ "values((select id_colaborador from conectadev.t_colaborador where cpf = "
					+ colaborador01.getCPF() + " order by id_colaborador desc limit 1),?)");

			stmt.setInt(1, colaborador07.getDeficiencia());
			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_colaborador set created_at = ?, deleted = ?, enabled = ?, last_update = ?,"
							+ "name = ?, search = ?, user_update = ?, apelido = ?, cargo = ?,"
							+ " coligada = ?, confirma_gympass = ?, confirma_kit_admissional = ?, confirma_plano_odontologico = ?,"
							+ "confirma_plano_saude = ?,confirma_vale_alimentacao = ?, confirma_vale_transporte = ?, cor = ?, cpf = ?, "
							+ "dat_alteracao= ?, dat_insercao = ?, email =? , filial = ?, genero = ?, id_plataforma = ?, assinatura = ?,"
							+ "login = ?, nome_social = ?, senha = ?, status_correcao = ?, telefone = ?, tipo_admissao = ?, token =?,"
							+ " unidade = ?, fk_tenant = ?, confirma_seguro_de_vida = ?, data_admissao = ?,confirma_cetificado_reservista = ?,"
							+ " salario = ?, t_colaboradorcol= ?, chamado_beneficios = ?, img_contrato_individual = ? "
							+ "where id_colaborador =((select max(fk_colaborador) from conectadev.t_user_auth where id =((select max(id) id from conectadev.t_user_auth))))");

			script08ColaboradorParte8 colaborador08 = new script08ColaboradorParte8();

			stmt.setString(1, dataInsert.gerarDataForm02());
			// stmt.setString(1, colaborador08.getCreated_at());
			stmt.setInt(2, colaborador08.getDeleted());
			stmt.setString(3, colaborador08.getEnabled());
			stmt.setString(4, colaborador08.getLast_update());
			stmt.setString(5, colaborador08.getName());
			stmt.setString(6, colaborador08.getSearch());
			stmt.setString(7, dataInsert.gerarDataForm03());
			// stmt.setString(7, colaborador08.getUser_update());
			stmt.setString(8, colaborador08.getApelido());
			stmt.setString(9, colaborador08.getCargo());
			stmt.setInt(10, colaborador08.getColigada());
			stmt.setString(11, colaborador08.getConfirma_gympass());
			stmt.setInt(12, colaborador08.getConfirma_kit_admissional());
			stmt.setInt(13, colaborador08.getConfirma_plano_odontologico());
			stmt.setInt(14, colaborador08.getConfirma_plano_saude());
			stmt.setInt(15, colaborador08.getConfirma_vale_alimentacao());
			stmt.setInt(16, colaborador08.getConfirma_vale_transporte());
			stmt.setString(17, colaborador08.getCor());
			stmt.setString(18, colaborador08.getCpf());
			stmt.setString(19, dataInsert.gerarDataForm02());
			stmt.setString(20, dataInsert.gerarDataForm02());
			stmt.setString(21, colaborador08.getEmail());
			stmt.setInt(22, colaborador08.getFilial());
			stmt.setString(23, colaborador08.getGenero());
			stmt.setString(24, colaborador08.getId_plataforma());
			stmt.setString(25, colaborador08.getAssinatura());
			stmt.setString(26, colaborador08.getLogin());
			stmt.setString(27, colaborador08.getNome_social());
			stmt.setString(28, colaborador08.getSenha());
			stmt.setString(29, colaborador08.getStatus_correcao());
			stmt.setString(30, colaborador08.getTelefone());
			stmt.setString(31, colaborador08.getTipo_admissao());
			stmt.setString(32, colaborador08.getToken());
			stmt.setString(33, colaborador08.getUnidade());
			stmt.setString(34, colaborador08.getFk_tenant());
			stmt.setInt(35, colaborador08.getConfirma_seguro_de_vida());
			stmt.setString(36, colaborador08.getData_admissao());
			stmt.setInt(37, colaborador08.getConfirma_cetificado_reservista());
			stmt.setString(38, colaborador08.getSalario());
			stmt.setString(39, colaborador08.getT_colaboradorcol());
			stmt.setString(40, colaborador08.getChamado_beneficios());
			stmt.setString(41, colaborador08.getImg_contrato_individual());

			stmt.executeUpdate();

			stmt = con.prepareStatement(
					"update conectadev.t_user_auth set created_at = ?, deleted = ?, enabled = ?, last_update = ?,name = ?, search = ?, user_update = ?, codigo_verificacao = ?, crypt_password = ?, login = ?, password = ?, fk_tenant = ? where fk_colaborador = (select id_colaborador from conectadev.t_colaborador where cpf ="
							+ colaborador01.getCPF() + " order by id_colaborador desc limit 1)");

			script09ColaboradorParte9 colaborador09 = new script09ColaboradorParte9();

			stmt.setString(1, colaborador09.getCreated_at());
			stmt.setInt(2, colaborador09.getDeleted());
			stmt.setString(3, colaborador09.getEnabled());
			stmt.setString(4, colaborador09.getLast_update());
			stmt.setString(5, colaborador09.getName());
			stmt.setString(6, colaborador09.getSearch());
			stmt.setString(7, colaborador09.getUser_update());
			stmt.setString(8, colaborador09.getCodigo_verificacao());
			stmt.setInt(9, colaborador09.getCrypt_password());
			stmt.setString(10, colaborador09.getLogin());
			stmt.setString(11, colaborador09.getPassword());
			stmt.setString(12, colaborador09.getFk_tenant());

			stmt.executeUpdate();

			// JOptionPane.showMessageDialog(null, "salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	// public void cadastrarColaboradorparte02(scriptColaboradorParte01
	// colaborador01) throws SQLException {
	//
	// Connection con = ConnectionFactory.getConnection();
	// PreparedStatement stmt = null;
	//
	// try {
	// stmt = con.prepareStatement(
	// "insert into conectadev.t_colaborador
	// (id_colaborador,created_at,deleted,enabled,last_update,name, search,
	// user_update, apelido, cargo, coligada, confirma_gympass,
	// confirma_kit_admissional, confirma_plano_odontologico,
	// confirma_plano_saude, confirma_vale_alimentacao,
	// confirma_vale_transporte, cor, cpf, dat_alteracao, dat_insercao, email,
	// filial, genero, id_plataforma, assinatura, login, nome_social, senha,
	// status_correcao, telefone, tipo_admissao, token, unidade, fk_tenant,
	// confirma_seguro_de_vida, data_admissao, confirma_cetificado_reservista,
	// salario, t_colaboradorcol, chamado_beneficios, img_contrato_individual)
	// VALUES ((select max(C.id_colaborador)+1 id_colaborador from
	// conectadev.t_colaborador
	// C),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	//
	// stmt.setString(2, colaborador01.getCreated_at());
	// stmt.setInt(3, colaborador01.getDeleted());
	// stmt.setString(4, colaborador01.getEnabled());
	// stmt.setString(5, colaborador01.getLast_update());
	// stmt.setString(6, colaborador01.getName());
	// stmt.setString(7, colaborador01.getSearch());
	// stmt.setString(8, colaborador01.getUser_update());
	// stmt.setString(9, colaborador01.getApelido());
	// stmt.setString(10, colaborador01.getCargo());
	// stmt.setInt(11, colaborador01.getColigada());
	// stmt.setString(12, colaborador01.getConfirma_gympass());
	// stmt.setInt(13, colaborador01.getConfirma_kit_admissional());
	// stmt.setInt(14, colaborador01.getConfirma_plano_odontologico());
	// stmt.setInt(15, colaborador01.getConfirma_plano_saude());
	// stmt.setInt(16, colaborador01.getConfirma_vale_alimentacao());
	// stmt.setInt(17, colaborador01.getConfirma_vale_transporte());
	// stmt.setString(18, colaborador01.getCor());
	// stmt.setString(19, colaborador01.getCPF());
	// stmt.setString(20, colaborador01.getDat_alteracao());
	// stmt.setString(21, colaborador01.getDat_insercao());
	// stmt.setString(22, colaborador01.getEmail());
	// stmt.setInt(23, colaborador01.getFilial());
	// stmt.setString(24, colaborador01.getGenero());
	// stmt.setString(25, colaborador01.getId_plataforma());
	// stmt.setString(26, colaborador01.getAssinatura());
	// stmt.setString(27, colaborador01.getLogin());
	// stmt.setString(28, colaborador01.getNome_social());
	// stmt.setString(29, colaborador01.getSenha());
	// stmt.setString(30, colaborador01.getStatus_correcao());
	// stmt.setString(31, colaborador01.getTelefone());
	// stmt.setString(32, colaborador01.getTipo_admissao());
	// stmt.setString(33, colaborador01.getToken());
	// stmt.setString(34, colaborador01.getUnidade());
	// stmt.setString(35, colaborador01.getFk_tenant());
	// stmt.setInt(36, colaborador01.getConfirma_seguro_de_vida());
	// stmt.setString(37, colaborador01.getData_admissao());
	// stmt.setString(38, colaborador01.getConfirma_cetificado_reservista());
	// stmt.setString(39, colaborador01.getSalario());
	// stmt.setString(40, colaborador01.getT_colaboradorcol());
	// stmt.setString(41, colaborador01.getChamado_beneficios());
	// stmt.setString(41, colaborador01.getImg_contrato_individual());
	//
	// stmt.executeUpdate();
	//
	// JOptionPane.showMessageDialog(null, "salvo com sucesso");
	//
	// } catch (SQLException e) {
	// JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
	// } finally {
	// ConnectionFactory.closeConnection(con, stmt);
	//
	// }

	// }

	public int pesquisaIdColaborador(String cpf) throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		stmt = con.prepareStatement(
				"select (id_colaborador) id_colaborador from conectadev.t_colaborador where cpf = ? order by id_colaborador desc limit 1");

		script01ColaboradorParte1 parte01 = new script01ColaboradorParte1();

		stmt.setString(1, cpf);

		// stmt.setString(1, parte01.getCPF());

		try {

			// stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs != null && rs.next()) {

				scriptColaboradorObterIdColaborador id = new scriptColaboradorObterIdColaborador();
				id.setId_colaborador(rs.getInt("id_colaborador"));
				idCol = rs.getInt("id_colaborador");

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "metodo pesquisar colaboradorDAO :  " + erro);
			System.out.println(erro);
		}

		return idCol;

	}

	public void deletarColaborador() throws SQLException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

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

			// stmt = con.prepareStatement(
			// "update conectadev.t_colaborador set deleted = 1 where cpf = ?
			// order by id_colaborador desc limit 1");
			//
			// stmt.setString(1, parte01.getCPF());

			// stmt.executeUpdate();

			stmt = con.prepareStatement(
					"delete from conectadev.t_colaborador  where cpf = ? order by id_colaborador desc limit 1");

			stmt.setString(1, parte01.getCPF());

			stmt.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}

	}

	

}
