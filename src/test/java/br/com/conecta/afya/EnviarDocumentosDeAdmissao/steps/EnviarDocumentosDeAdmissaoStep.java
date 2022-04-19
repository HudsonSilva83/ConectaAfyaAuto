package br.com.conecta.afya.EnviarDocumentosDeAdmissao.steps;

import java.util.Map;

import org.junit.Assert;
import br.com.conecta.afya.page.EnviarDocumentacaoPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.InformacoesPessoaisPage;
import br.com.conecta.afya.page.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class EnviarDocumentosDeAdmissaoStep {

	private String feature = "Enviar Documentos de Admissao";
	private String cenario = "";

	@Before
	public void setCenario(Scenario cen) {
		// feature = cen.getId().split(";")[0];
		cenario = cen.getName();

	}

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	EnviarDocumentacaoPage enviarDocPage = new EnviarDocumentacaoPage();
	LoginPage login = new LoginPage();

	@Dado("que eu esteja na tela Home do app")
	public void que_eu_esteja_na_tela_home_do_app() {
		Assert.assertEquals("Já tenho uma conta", home.verificarHomeJaTenhoConta());
	}

	@Quando("aciono a opcao para logar ja com um conta {string}")
	public void aciono_a_opcao_para_logar_ja_com_um_conta(String jaTenhoUmaConta) {

		home.clicarCampoCodigoAcesso(jaTenhoUmaConta);

	}

	@Quando("o app apresenta o campo CPF, preeencho com cpf {string} e aciono avancar")
	public void o_app_apresenta_o_campo_cpf_preeencho_com_cpf_e_aciono_avancar(String CPF) throws InterruptedException {

		Assert.assertTrue(login.verificarCampoCPF().contains("Entre com seu CPF"));
		login.preencherCpf(CPF);
		login.botaoAvancar();

	}

	@Quando("o app apresenta o campo senha, preencho com a senha {string} e aciono avancar")
	public void o_app_apresenta_o_campo_senha_preencho_com_a_senha_e_aciono_avancar(String senha)
			throws InterruptedException {

		Assert.assertTrue(login.verificarCampoSenha().contains("Senha"));
		login.preencherSenha(senha);
		login.botaoAvancarSenha();

	}

	@Quando("aciono o comando para Enviar Documentos")
	public void aciono_o_comando_para_enviar_documentos() throws InterruptedException {

		Thread.sleep(7000);
		login.botaoEnviarDocumentos();

	}

	@Quando("o app apresenta tela com instrucao de quais documentos necessarios para envio")
	public void o_app_apresenta_tela_com_instrucao_de_quais_documentos_necessarios_para_envio() {

		Assert.assertTrue(enviarDocPage.telaDocumentosNecessarios().contains(
				"Você só pode concluir o processo se estiver com os documentos abaixo, com exceção do que não se aplica"));

	}

	@Quando("aciono o comando Continuar")
	public void aciono_o_comando_continuar() throws InterruptedException {

		enviarDocPage.botaoContinuar();

	}

	@Quando("aciono o comando Enviar para iniciar o envio do documento eSocial")
	public void aciono_o_comando_enviar_para_iniciar_o_envio_do_documento_e_social() throws InterruptedException {

		enviarDocPage.scroll(0.9, 0.1);
		enviarDocPage.botaoEnviar();

	}

	@Quando("aciono o comando para anexar o documento eSocial")
	public void aciono_o_comando_para_anexar_o_documento_e_social() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Quando("seleciono o arquivo eSocial para anexar e aciono o comando Enviar Arquivo")
	public void seleciono_o_arquivo_e_social_para_anexar_e_aciono_o_comando_enviar_arquivo()
			throws InterruptedException {

		enviarDocPage.selecionarArquivoeSocial();
		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem {string}")
	public void o_app_apresenta_mensagem(String mensagem) {

		Assert.assertEquals(mensagem, login.verificarMensagemESocial(mensagem));

	}

	@Entao("o app apresenta a tela para iniciar o envio do documento de identidade")
	public void o_app_apresenta_a_tela_para_iniciar_o_envio_do_documento_de_identidade() throws InterruptedException {

		Assert.assertTrue(enviarDocPage.verificarTelaIdentidade().contains("Documento de identidade"));

	}

	@Entao("aciono o comando Enviar para iniciar o envio do documento de identidade")
	public void aciono_o_comando_enviar_para_iniciar_o_envio_do_documento_de_identidade() throws InterruptedException {

		Thread.sleep(2000);
		enviarDocPage.scroll(0.9, 0.1);
		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos de identidade com os seguintes dados e avancando apos o seu preenchimento")
	public void preencho_os_campos_de_identidade_com_os_seguintes_dados_e_avancando_apos_o_seu_preenchimento(
			DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String RG = map.get("RG");
		String OrgaoEmissor = map.get("Orgao Emissor");
		String dataEmissaoRG = map.get("data de emissao RG");
		String ufEmissao = map.get("UF de emissao");
		String nacionalidade = map.get("Nacionalidade");
		String EstadoNatal = map.get("Estado Natal");
		String cidadeNatal = map.get("Cidade Natal");
		String dataNascimento = map.get("Data Nascimento");
		String nomeMae = map.get("Nome Mae");

		enviarDocPage.preencherRG(RG);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherOrgaoEmissor(OrgaoEmissor);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoRG(dataEmissaoRG);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeUF(ufEmissao);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeNacionalidade(nacionalidade);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeEstadoNatal(EstadoNatal);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeCidadeNatal(cidadeNatal);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaDataNascimento(dataNascimento);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaNomeMae(nomeMae);

	}

	@Entao("aciono o comando para finalizar a secao de preeenchimento dos documentos de identidade")
	public void aciono_o_comando_para_finalizar_a_secao_de_preeenchimento_dos_documentos_de_identidade() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela de confirmacao do RG")
	public void o_app_apresenta_a_tela_de_confirmacao_do_rg() {

		Assert.assertTrue(enviarDocPage.verificarTelaConfirmacaoRG().contains("Confirmação do RG"));

	}

	@Entao("aciono o comando para anexar a identidade Foto frente e verso")
	public void aciono_o_comando_para_anexar_a_identidade_foto_frente_e_verso() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono a primeira foto para anexar")
	public void seleciono_a_primeira_foto_para_anexar() throws InterruptedException {

		enviarDocPage.pegarArquivoIdentidadeFrente();

	}

	@Entao("seleciono a segunda foto para anexar")
	public void seleciono_a_segunda_foto_para_anexar() throws InterruptedException {

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoIdentidadeVerso();

	}

	@Entao("aciono o comando para enviar o arquivo")
	public void aciono_o_comando_para_enviar_o_arquivo() throws InterruptedException {

		enviarDocPage.descerTela();

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("apresenta a tela para iniciar o envio do documento carteira de trabalho")
	public void apresenta_a_tela_para_iniciar_o_envio_do_documento_carteira_de_trabalho() throws InterruptedException {

		Thread.sleep(6000);

		// TELA A SER IMPLEMENTADA

		enviarDocPage.descerTela();
		Thread.sleep(1000);
		enviarDocPage.descerTela();

	}

	@Entao("aciono o comando Enviar para iniciar o envio do documento carteira de trabalho")
	public void aciono_o_comando_enviar_para_iniciar_o_envio_do_documento_carteira_de_trabalho()
			throws InterruptedException {

		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos da carteira de trabalho com os seguintes dados e avancando apos o seu preenchimento")
	public void preencho_os_campos_da_carteira_de_trabalho_com_os_seguintes_dados_e_avancando_apos_o_seu_preenchimento(
			DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		enviarDocPage.preencherNumeroCarteiraTrabalho(map.get("NumeroCarteiraTrabalho"));
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroSerieCarteiraTrabalho(map.get("SerieCarteiraTrabalho"));
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherUFCarteiraTrabalho(map.get("UFCarteiraTrabalho"));
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoCTPS(map.get("DataEmissaoCTPS"));

	}

	@Entao("aciono o comando para finalizar a secao de preeenchimento dos documentos de carteira de Trabalho")
	public void aciono_o_comando_para_finalizar_a_secao_de_preeenchimento_dos_documentos_de_carteira_de_trabalho() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela de confirmacao do Carteira de Trabalho")
	public void o_app_apresenta_a_tela_de_confirmacao_do_carteira_de_trabalho() throws InterruptedException {

		Thread.sleep(3000);

		// IMPLEMENTAR A CHCAGEM DA TELA AQUI

	}

	@Entao("aciono o comando para anexar a carteira de trabalho")
	public void aciono_o_comando_para_anexar_a_carteira_de_trabalho() throws InterruptedException {

		enviarDocPage.descerTela();
		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono a primeira pagina para anexar")
	public void seleciono_a_primeira_pagina_para_anexar() {

		enviarDocPage.pegarArquivoCTPSFrente();

	}

	@Entao("seleciono a segunda pagina para anexar")
	public void seleciono_a_segunda_pagina_para_anexar() throws InterruptedException {

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoCTPSDados();
		enviarDocPage.descerTela();

	}

	@Entao("aciono o comando para enviar o arquivo da carteira de trabalho")
	public void aciono_o_comando_para_enviar_o_arquivo_da_carteira_de_trabalho() {

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem do envio da carteira de trabalho {string}")
	public void o_app_apresenta_mensagem_do_envio_da_carteira_de_trabalho(String mensagem) {

		enviarDocPage.verificarMensagemCarteiraTrabalho(mensagem);

	}

	@Entao("o app apresenta a tela para iniciar as informações do Endereco")
	public void o_app_apresenta_a_tela_para_iniciar_as_informações_do_endereco() throws InterruptedException {

		// IMPLEMNTAR A TELA A SER VERIFICADA
		Thread.sleep(2000);

	}

	@Entao("aciono o comando Enviar para iniciar o preeenchimento do endereco")
	public void aciono_o_comando_enviar_para_iniciar_o_preeenchimento_do_endereco() throws InterruptedException {

		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos de endereco e avancando apos o seu preenchimento")
	public void preencho_os_campos_de_endereco_e_avancando_apos_o_seu_preenchimento(DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		enviarDocPage.preencherCep(map.get("CEP"));
		enviarDocPage.enderecoVisivel();
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroEndereco(map.get("Numero"));
		enviarDocPage.preencherComplemento(map.get("Complemento"));

	}

	@Entao("aciono o comando para finalizar a secao de preeenchimento do endereco")
	public void aciono_o_comando_para_finalizar_a_secao_de_preeenchimento_do_endereco() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela do anexar o comprovante de residencia")
	public void o_app_apresenta_a_tela_do_anexar_o_comprovante_de_residencia() {

	}

	@Entao("aciono o comando para anexar o comprovante de residencia")
	public void aciono_o_comando_para_anexar_o_comprovante_de_residencia() {

		enviarDocPage.anexarComprovanteResidencia();

	}

	@Entao("seleciono o arquivo para anexar")
	public void seleciono_o_arquivo_para_anexar() {

		enviarDocPage.selecionarArquivoPDF();
		enviarDocPage.scroll(0.8, 0.1);
		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta a tela para anexar o documento foto 3x4")
	public void o_app_apresenta_a_tela_para_anexar_o_documento_foto_3x4() {

		enviarDocPage.verificarTelaFoto3x4();

	}

	@Entao("aciono o comando para anexar a foto")
	public void aciono_o_comando_para_anexar_a_foto() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono a foto para anexar")
	public void seleciono_a_foto_para_anexar() {

		enviarDocPage.selecionarArquivoJPG();
		enviarDocPage.scroll(0.9, 0.1);
		

	}
	
	
	
	
	@Entao("aciono o comando para enviar o arquivo foto")
	public void aciono_o_comando_para_enviar_o_arquivo_foto() {
		
		enviarDocPage.botaoEnviarArquivo();
	   
	}

	@Entao("o app apresenta mensagem de sucesso para o arquivo foto {string}")
	public void o_app_apresenta_mensagem_de_sucesso_para_o_arquivo_foto(String mensagem) {
	 
		
		enviarDocPage.verificarMensagemFoto3X4(mensagem);
	}
	
	
	
	

	@Entao("o app apresenta a tela para selecionar o Estado civil")
	public void o_app_apresenta_a_tela_para_selecionar_o_estado_civil() {
		
		//enviarDocPage.verificarTelaFoto3x4();
		

	}

	@Entao("informo qual estado civil {string}")
	public void informo_qual_estado_civil(String string) {

	}

	@Entao("aciono o comando avancar")
	public void aciono_o_comando_avancar() {

	}

	@Entao("o app apresenta a tela para anexar certidao nascimento")
	public void o_app_apresenta_a_tela_para_anexar_certidao_nascimento() {

	}

	@Entao("aciono o comando para anexar a certidao de nascimento")
	public void aciono_o_comando_para_anexar_a_certidao_de_nascimento() {

	}

	@Entao("o app apresenta a tela para informar o numero do PIS")
	public void o_app_apresenta_a_tela_para_informar_o_numero_do_pis() {

	}

	@Entao("aciono o comando Preencher Pis")
	public void aciono_o_comando_preencher_pis() {

	}

	@Entao("informo o numero do PIS {string}")
	public void informo_o_numero_do_pis(String string) {

	}

	@Entao("aciono o comando para finalizar a secao de informe do PIS")
	public void aciono_o_comando_para_finalizar_a_secao_de_informe_do_pis() {

	}

	@Entao("o app apresenta a tela para iniciar as informacoes do Titulo de eleitor")
	public void o_app_apresenta_a_tela_para_iniciar_as_informacoes_do_titulo_de_eleitor() {

	}

	@Entao("aciono o comando Enviar")
	public void aciono_o_comando_enviar() {

	}

	@Entao("preencho os campos referente ao título de eleitor e avancando apos o seu preenchimento")
	public void preencho_os_campos_referente_ao_título_de_eleitor_e_avancando_apos_o_seu_preenchimento(
			DataTable dataTable) {

	}

	@Entao("aciono o comando para finalizar a secao do Titulo Eleitor")
	public void aciono_o_comando_para_finalizar_a_secao_do_titulo_eleitor() {

	}

	@Entao("o app apresenta a tela do anexar o Titulo de Eleitor")
	public void o_app_apresenta_a_tela_do_anexar_o_titulo_de_eleitor() {

	}

	@Entao("aciono o comando anexar o arquivo")
	public void aciono_o_comando_anexar_o_arquivo() {

	}

	@Entao("seleciono o arquivo")
	public void seleciono_o_arquivo() {

	}

	@Entao("aciono o comando Enviar Arquivo")
	public void aciono_o_comando_enviar_arquivo() {

	}

	@Entao("o app apresenta a tela para anexar o Comprovante da ultima votacao")
	public void o_app_apresenta_a_tela_para_anexar_o_comprovante_da_ultima_votacao() {

	}

	@Entao("aciono o comando anexar arquivo")
	public void aciono_o_comando_anexar_arquivo() {

	}

	@Entao("o app apresenta a tela para anexar o Certificado de reservista")
	public void o_app_apresenta_a_tela_para_anexar_o_certificado_de_reservista() {

	}

	@Entao("o app apresenta a tela para enviar o Diploma ou comprovante de escolaridade")
	public void o_app_apresenta_a_tela_para_enviar_o_diploma_ou_comprovante_de_escolaridade() {

	}

	@Entao("seleciono a opcao referente ao Grau de Instituicao {string} e acionando avancar")
	public void seleciono_a_opcao_referente_ao_grau_de_instituicao_e_acionando_avancar(String string) {

	}

	@Entao("o app apresenta a tela do anexar o Diploma ou Comprovante de escolaridade")
	public void o_app_apresenta_a_tela_do_anexar_o_diploma_ou_comprovante_de_escolaridade() {

	}

	@Entao("o app apresenta a tela de Declaracao de dependentes")
	public void o_app_apresenta_a_tela_de_declaracao_de_dependentes() {

	}

	@Entao("aciono a opcao referente a dependentes {string}")
	public void aciono_a_opcao_referente_a_dependentes(String string) {

	}

	@Entao("o app apresenta a tela com o check ou marcação verde em todos os documentos")
	public void o_app_apresenta_a_tela_com_o_check_ou_marcação_verde_em_todos_os_documentos() {

	}

	@Entao("aciono o comando Concluir Envio")
	public void aciono_o_comando_concluir_envio() {

	}

	@Entao("o app apresenta a tela de Declaracao de envio")
	public void o_app_apresenta_a_tela_de_declaracao_de_envio() {

	}

	@Entao("aceito o termo e aciono o comando Concluir Envio")
	public void aceito_o_termo_e_aciono_o_comando_concluir_envio() {

	}

	@Entao("o app apresenta tela de Documentos enviados com sucesso.")
	public void o_app_apresenta_tela_de_documentos_enviados_com_sucesso() {

	}

}
