package br.com.conecta.afya.ECadastrarBeneficios.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import org.apache.http.StatusLine;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import br.com.conecta.afya.ACadastrarNovoColaborador.persist.CadastroBeneficiosDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ColaboradorDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.DadosBancariosDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.EnviarDocumentosDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ExcluirGeralDAO;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.CadastroBeneficiosPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import br.com.conecta.afya.services.ExcluirDependentes;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarBeneficiosStep {

	
	static ColaboradorDAO colaboradorDao = new ColaboradorDAO();
	static EnviarDocumentosDAO documentosDao = new EnviarDocumentosDAO();
	static DadosBancariosDAO dadosBancariosDao = new DadosBancariosDAO();
	static CadastroBeneficiosDAO beneficiosDao = new CadastroBeneficiosDAO();
	static ExcluirGeralDAO bancoGeral = new ExcluirGeralDAO();
	
	
	 
	
	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	CadastroBeneficiosPage cadBeneficios = new CadastroBeneficiosPage();

	 @Before
	 public void excluirDependentes() throws IOException, SQLException {
		 bancoGeral.excluirGeral();
		 colaboradorDao.cadastrarColaborador();
		 documentosDao.cadastroDocumento();
		 dadosBancariosDao.cadastrarDadosBancarios();
		 
		 
//	 ExcluirDependentes excluir = new ExcluirDependentes();
//	 StatusLine status1 = excluir.excluirDependentes();
//	 StatusLine status2 = excluir.excluirDependentes();
//	 String code = status2.toString();
//	
//	 String apenasCode = code.replace("HTTP/1.1 ", "").replace(" OK", "");
//	 String codeF = apenasCode.trim();
//	 System.out.println(codeF);
		 
		 
		 
		 
		 
		 
	
	 }

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "AdicionarDadosBancarios");

	}

	@After
	public static void finalizaCenario() throws SQLException {

		beneficiosDao.deletarBeneficios();
		dadosBancariosDao.deletarDadosBancarios();
		documentosDao.deletarDocumento();
		colaboradorDao.deletarColaborador();
		bancoGeral.excluirGeral();
		
		 DriverFactory.KillDriver();

	}

	@Dado("que eu esteja logado e que ja tenha enviado os documentos para admissao e adicionado os Dados Bancarios")
	public void que_eu_esteja_logado_e_que_ja_tenha_enviado_os_documentos_para_admissao_e_adicionado_os_dados_bancarios(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		String CPF = map.get("CPF");
		String Senha = map.get("Senha");

		home.clicarJaTenhoUmaConta();
		Thread.sleep(3000);
		login.preencherCpf(CPF);
		login.botaoAvancar();
		Thread.sleep(1000);
		login.preencherSenha(Senha);
		login.botaoAvancarSenha();

	}

	@Entao("o app apresenta a tela para iniciar as informacoes dos dados do Beneficio")
	public void o_app_apresenta_a_tela_para_iniciar_as_informacoes_dos_dados_do_beneficio()
			throws InterruptedException {

		Thread.sleep(1000);

		 //String etapasConcluidas = cadBeneficios.verificarEtapasConcluidas();
		//
		// Assert.assertTrue(etapasConcluidas.contains("Cadastro Realizado com
		// sucesso :)"));
		// Assert.assertTrue(etapasConcluidas.contains("Envio de documentos
		// Realizado com sucesso :)"));
		// Assert.assertTrue(etapasConcluidas.contains("Dados Bancários
		// Realizado com sucesso :)"));
		Thread.sleep(5000);
		cadBeneficios.scrollar(0.8, 0.1);
		cadBeneficios.verificarInicioBeneficioTela();

	}

	@Entao("aciono o comando para comecar")
	public void aciono_o_comando_para_comecar() {

		cadBeneficios.clicarBotaoComecar();

	}

	@Entao("o app apresenta a tela com os beneficios disponiveis")
	public void o_app_apresenta_a_tela_com_os_beneficios_disponiveis() {

		cadBeneficios.verificaroBeneficioDisponiveisTela();

	}

	@Quando("aciono o comando para comecar para iniciar")
	public void aciono_o_comando_para_comecar_para_iniciar() {

		cadBeneficios.clicarBotaoComecar();

	}

	@Entao("o app apresenta a tela para selecionar se deseja vale transporte")
	public void o_app_apresenta_a_tela_para_selecionar_se_deseja_vale_transporte() {

		cadBeneficios.verificaroValeTransporteTela();

	}

	@Entao("seleciono a opcao {string} e aciono avancar")
	public void seleciono_a_opcao_e_aciono_avancar(String opcao) {

		cadBeneficios.selecionarOpcaoValeTransporte(opcao);
		cadBeneficios.botaoAvancarValeTransporte();

	}

	@Entao("o app apresenta as opcoes de transporte a ser utilizado")
	public void o_app_apresenta_as_opcoes_de_transporte_a_ser_utilizado() {

		Assert.assertEquals("Ônibus", cadBeneficios.verificarOpcaoOnibusTela());
		Assert.assertEquals("+", cadBeneficios.verificarOpcaoAdicionarOnibus());
		cadBeneficios.verificarOpcaoMetroTela();
		cadBeneficios.verificarOpcaoAdicionarMetro();
		cadBeneficios.verificarOpcaoTremTela();
		cadBeneficios.verificarOpcaoAdicionarTrem();

	}

	@Entao("seleciono a quantidade de onibus para a Ida ao trabalho {string} aciono avancar, preencho os dados do onibus a ser utilizado")
	public void seleciono_a_quantidade_de_onibus_para_a_ida_ao_trabalho_aciono_avancar_preencho_os_dados_do_onibus_a_ser_utilizado(
			String quantidadeOnibusIda, io.cucumber.datatable.DataTable dataTable) {

		cadBeneficios.selecionarQuantidadeOnibusIda(quantidadeOnibusIda);
		cadBeneficios.botaoAvancarValeOnibus();

		Assert.assertEquals("Informe a linha ou nome da empresa de transporte.",
				cadBeneficios.verificarTelaInformacoesOnibus());
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		switch (quantidadeOnibusIda) {
		case "1":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			break;

		case "2":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			break;

		case "3":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			break;

		case "4":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha4"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa4"));
			cadBeneficios.botaoAvancarQuartoOnibus();

			break;

		}

	}

	@Entao("o app apresenta a pergunta referente ao trajeto ida e volta")
	public void o_app_apresenta_a_pergunta_referente_ao_trajeto_ida_e_volta() {

		Assert.assertEquals("Informe se o trajeto é o mesmo de ida e volta do trabalho",
				cadBeneficios.verificarTrajetoIdaVoltaTela());

	}

	@Entao("seleciono a opcao {string} como o mesmo trajeto e aciono avancar")
	public void seleciono_a_opcao_como_o_mesmo_trajeto_e_aciono_avancar(String opcao) throws InterruptedException {

		cadBeneficios.selecionarIdaVolta(opcao);
		cadBeneficios.botaoAvancarIdaVolta();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do vale transporte com os respectivos valores e aciono avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_vale_transporte_com_os_respectivos_valores_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) {

		Assert.assertEquals("Confirme seu pedido do vale transporte", cadBeneficios.verificarConfirmarPedidoTela());

		// cadBeneficios.clicarAbrirInfoDesconto();
		// Assert.assertTrue(cadBeneficios.verificarTextoInfoDesconto().trim()
		// .contains("Será descontado até 6% do valor de seu salário bruto para
		// o pagamento do VT."));
		// cadBeneficios.clicarFecharInfoDesconto();

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		// Assert.assertEquals((map.get("valorTrajetoIda")),
		// cadBeneficios.valorTrajetoIdaTela().substring(3, 7));
		// Assert.assertEquals((map.get("valorTrajetoVolta")),
		// cadBeneficios.valorTrajetoVoltaTela().substring(3, 7));
		// Assert.assertEquals((map.get("valorTotalDiario")),
		// cadBeneficios.valorTotalDiarioTela().substring(3, 7));
		// Assert.assertEquals((map.get("descontoMensal")),
		// cadBeneficios.valorDescontoTela().substring(3, 9).trim());

		cadBeneficios.botaoAvancarTelaConfirmacao();

	}

	@Entao("o app apresenta a tela do termo de aceite")
	public void o_app_apresenta_a_tela_do_termo_de_aceite() {

		Assert.assertEquals("Termo de aceite do vale transporte", cadBeneficios.verificarAceiteTela());

	}

	@Quando("aciono aceitar e aciono finalizar")
	public void aciono_aceitar_e_aciono_finalizar() throws InterruptedException {
		Thread.sleep(1000);
		cadBeneficios.aceitarTermoVale();
		cadBeneficios.botaoFinalizar();

	}

	@Entao("o app apresenta a tela de vale transporte concluido e aciono comando avancar")
	public void o_app_apresenta_a_tela_de_vale_transporte_concluido_e_aciono_comando_avancar() {

		Assert.assertEquals("Vale transporte concluído!", cadBeneficios.verificaConclusaoValeTela());
		cadBeneficios.botaoAvancar();

	}

	@Entao("o app apresenta a tela de Plano Odontologico")
	public void o_app_apresenta_a_tela_de_Plano_Odontologico() throws InterruptedException {

		Assert.assertEquals("Plano odontológico", cadBeneficios.verificaPlanoOdontologico());

	}

	@Quando("escolho a opcao de ter plano odontologico")
	public void escolho_a_opcao_de_ter_plano_odontologico() throws InterruptedException {

		cadBeneficios.scroll(0.7, 0.1);

		cadBeneficios.botaoQueroPlanoOndotologico();
		// cadBeneficios.botaoNaoQueroPlanoOndotologico();

	}

	@Entao("o app apresenta as informacoes de planos disponiveis")
	public void o_app_apreseta_as_informacoes_de_planos_disponiveis() throws InterruptedException {
		Thread.sleep(3000);
		cadBeneficios.scroll(0.7, 0.1);

		Assert.assertEquals("Essencial Plus", cadBeneficios.verificaPlanoOdontologicoEssencialPlus());

		Thread.sleep(1000);
		cadBeneficios.lado();

		Assert.assertEquals("Essencial Top", cadBeneficios.verificaPlanoOdontologicoEssencialTop());
		cadBeneficios.lado2();
		cadBeneficios.lado();

		Assert.assertEquals("Premium Top", cadBeneficios.verificaPlanoOdontologicoPremium());

		cadBeneficios.paraLadoEsquerdo();

	}

	@Entao("escolho um dos planos disponiveis no caso {string} e aciono continuar")
	public void escolho_um_dos_planos_disponiveis_no_caso_e_aciono_continuar(String opcao) throws InterruptedException {

		Thread.sleep(2000);
		cadBeneficios.clicarNoPlano(opcao);
		// cadBeneficios.scroll(0.7, 0.1);
		cadBeneficios.botaoContinuar();

		Thread.sleep(3000);

	}

	@Entao("o app apresenta tela para incluir dependentes")
	public void o_app_apresenta_tela_para_incluir_dependentes() throws InterruptedException {

		Assert.assertEquals("Dependentes", cadBeneficios.verificarTelaIncluirDependentes());

	}

	@E("aciono comando para incluir dependentes")
	public void aciono_comando_para_incluir_dependentes() throws InterruptedException {

		cadBeneficios.botaoIncluirDependentes();

	}

	@E("incluo o dependente com suas informacoes e aciono avancar")
	public void incluo_o_dependente_com_suas_informacoes_e_aciono_avancar(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		// cadBeneficios.selecionarDependente((map.get("grauParentesto")));
		String opcao = (map.get("grauParentesto"));

		switch (opcao) {

		case "Cônjuge":

			cadBeneficios.selecionarDependente("Cônjuge");
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherNome(map.get("nomeCompeto"));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherDataNascimento((map.get("dataNascimento")));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherCPF((map.get("CPF")));
			cadBeneficios.botaoFinalizarDependente();

			break;

		case "Filho(a)":

			cadBeneficios.scroll(0.7, 0.1);
			cadBeneficios.clicar(MobileBy.AccessibilityId("Filho(a)"));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.selecionarIdade((map.get("idade")));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherNome(map.get("nomeCompeto"));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherDataNascimento((map.get("dataNascimento")));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherCPF((map.get("CPF")));
			cadBeneficios.botaoFinalizarDependente();

			break;

		case "Companheiro(a)":

			cadBeneficios.scroll(0.3, 0.1);
			cadBeneficios.selecionarDependente("Companheiro(a)");
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherNome(map.get("nomeCompeto"));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherDataNascimento((map.get("dataNascimento")));
			cadBeneficios.botaoSetaPraBaixo();
			cadBeneficios.preencherCPF((map.get("CPF")));
			cadBeneficios.botaoFinalizarDependente();

			break;

		}

	}

	@Entao("o app apresenta a tela de certidao de nascimento")
	public void o_app_apresenta_a_tela_de_certidao_de_nascimento() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Certidão de nascimento", cadBeneficios.verificarTelaCertidaoNascimento());

	}

	@E("aciono o comando anexar a certidao de nascimento")
	public void aciono_o_comando_anexar_arquivo_da_declaracao_de_dependentes() {

		cadBeneficios.anexarArquivo();

	}

	@E("seleciono o arquivo da certidao de nascimento")
	public void seleciono_o_arquivo_da_certidao_de_nascimento() throws InterruptedException {

		cadBeneficios.selecionarArquivo();

	}

	@E("aciono comando de enviar o arquivo da certidao de nascimento")
	public void aciono_comando_de_enviar_o_arquivo_da_certidao_de_nascimento() throws InterruptedException {

		cadBeneficios.botaoEnviarArquivo();

	}

	@Entao("o app apresenta a tela de carteirinha de vacinacao")
	public void o_app_apresenta_a_tela_de_carteirinha_de_vacinacao() throws InterruptedException {

		Thread.sleep(2000);
		Assert.assertEquals("Carteirinha de vacinação", cadBeneficios.verificarTelaCarteitinhaVacinacao());

	}

	@Entao("aciono comando de anexar a carteirinha de vacinacao")
	public void aciono_comando_de_anexar_a_carteirinha_de_vacinacao() {

		cadBeneficios.anexarArquivo();

	}

	@Entao("seleciono o arquivo da carteirinha de vacinacao")
	public void seleciono_o_arquivo_da_carteirinha_de_vacinacao() throws InterruptedException {

		cadBeneficios.selecionarArquivo();

	}

	@Entao("aciono comando de enviar a carteirinha de vacinacao")
	public void aciono_comando_de_enviar_a_carteirinha_de_vacinacao() {
		cadBeneficios.scroll(0.6, 0.1);
		cadBeneficios.botaoEnviarArquivo();

	}

	@E("seleciono o dependente e aciono avancar")
	public void seleciono_o_dependente_e_aciono_avancar() throws InterruptedException {

		cadBeneficios.checkSelecionarDependente();
		cadBeneficios.botaoAvancarDependente();

	}

	@Entao("o app apresenta a tela com dados de confirmacao do plano ondotologico {string}")
	public void o_app_apresenta_a_tela_com_dados_de_confirmacao_do_plano_ondotologico(String plano)
			throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Assert.assertEquals(plano, cadBeneficios.telaPlanoConfirmacao(plano));

	}

	@E("aciono o comando avancar da tela de confirmacao")
	public void aciono_o_comando_avancar_da_tela_de_confirmacao() throws InterruptedException {

		cadBeneficios.botaoAvancarConfirmacao();

	}

	@Entao("o app apresenta a tela termo de escolha do plano odontologico")
	public void o_app_apresenta_a_tela_termo_de_escolha_do_plano_odontologico() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Termos de escolha do plano odontológico", cadBeneficios.telaTermoOndotologico());

	}

	@E("aciono o comando de aceitar o termo e finalizar")
	public void aciono_o_comando_de_aceitar_o_termo_e_finalizar() throws InterruptedException {

		cadBeneficios.scroll(0.6, 0.1);
		cadBeneficios.checkSelecionarTermo();
		cadBeneficios.botaoFinalizarTermo();

	}

	@Entao("o app apresenta a tela plano odontologico concluida com sucesso e aciono avancar")
	public void o_app_apresenta_a_tela_plano_odontologico_concluida_com_sucesso_e_aciono_avancar()
			throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Plano odontológico concluído!", cadBeneficios.telaPlanoOndotologicoConcluido());

		cadBeneficios.botaoAvancar();

	}

	@Entao("o app apresenta a tela para informar o ticket restaurante e alimentação")
	public void o_app_apresenta_a_tela_para_informar_o_ticket_restaurante_e_alimentação() {

		Assert.assertEquals("Ticket restaurante e alimentação", cadBeneficios.telaPlanoTickets());
		cadBeneficios.scroll(0.8, 0.1);
		cadBeneficios.scroll(0.6, 0.1);

	}

	@Quando("aciono o comando para customizar o beneficio")
	public void aciono_o_comando_para_customizar_o_beneficio() {

		cadBeneficios.botaoCustomizarBeneficios();

	}

	@Entao("o app apresenta a tela de opção para receber como alimentação ou restaurante")
	public void o_app_apresenta_a_tela_de_opção_para_receber_como_alimentação_ou_restaurante() {

		cadBeneficios.scroll(0.8, 0.1);
		Assert.assertEquals("Valor integral como Ticket Alimentação", cadBeneficios.TicketAlimentacao());
		Assert.assertEquals("Valor integral como Ticket Restaurante", cadBeneficios.TicketRestaurante());

	}

	@Quando("aciono a opção de beneficio ticket {string} e aciono avancar do beneficio")
	public void aciono_a_opção_de_beneficio_ticket_e_aciono_avancar_do_beneficio(String opcaoTicket) {

		cadBeneficios.selecaoBeneficioTicket(opcaoTicket);
		cadBeneficios.botaoAvancarBeneficioTicket();

	}

	@Entao("o app apresenta a tela de confirmação da escolha {string} e aciono finalizar")
	public void o_app_apresenta_a_tela_de_confirmação_da_escolha_e_aciono_finalizar(String opcaoTicket)
			throws InterruptedException {

		Thread.sleep(2000);

		Assert.assertEquals("Confirme sua escolha", cadBeneficios.telaConfirmacaoTicket());

		Assert.assertEquals(opcaoTicket, cadBeneficios.opcaoConfirmacaoTicket(opcaoTicket));

		cadBeneficios.botaoFinalizar();

	}

	@Entao("o app apresenta a tela do termo de escolha do beneficio do Ticket")
	public void o_app_apresenta_a_tela_do_termo_de_escolha_do_beneficio_do_ticket() throws InterruptedException {

		Thread.sleep(1000);

		Assert.assertEquals("Termos de escolha do benefício", cadBeneficios.termoEscolhaTicket());

	}

	@Quando("aciono o comando de aceitar o termo de escolha do beneficio e finalizar")
	public void aciono_o_comando_de_aceitar_o_termo_de_escolha_do_beneficio_e_finalizar() throws InterruptedException {

		cadBeneficios.aceitarTermoBeleficioTicket();
		cadBeneficios.botaoFinalizar();

	}

	@Entao("o app apresenta a tela de escolha salva do Ticket e aciono comando avancar")
	public void o_app_apresenta_a_tela_de_escolha_salva_do_ticket_e_aciono_comando_avancar() {

		Assert.assertEquals("Sua escolha foi salva!", cadBeneficios.verificarTelasTicketSalvo());
		cadBeneficios.botaoAvancarTelaSalva();

	}

	@Entao("o app apresenta a tela de informacoes do Gympass")
	public void o_app_apresenta_a_tela_de_informacoes_do_gympass_e_aciono_continuar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Assert.assertEquals("Gympass", cadBeneficios.telaGympass());

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.scroll(0.3, 0.1);
		Thread.sleep(2000);
		Assert.assertEquals(map.get("carrossel01"), cadBeneficios.obterTextoGympassCarrossel01());
		// System.out.println(cadBeneficios.obterTextoGympassCarrossel01());

		// cadBeneficios.lado(0.6, 0.1);
		// Assert.assertEquals(map.get("carrossel02"),
		// cadBeneficios.obterTextoGympassCarrossel02());
		// Assert.assertEquals(map.get("carrossel03"),
		// cadBeneficios.obterTextoGympassCarrossel03());
		// cadBeneficios.lado(0.6, 0.1);
		// cadBeneficios.lado(0.6, 0.1);
		// cadBeneficios.lado(0.5, 0.1);
		// Assert.assertEquals(map.get("carrossel04"),
		// cadBeneficios.obterTextoGympassCarrossel04());
		// cadBeneficios.lado(0.5, 0.1);
		// cadBeneficios.lado(0.6, 0.1);
		//
		// Assert.assertEquals(map.get("carrossel05"),
		// cadBeneficios.obterTextoGympassCarrossel05());

		cadBeneficios.scroll(0.6, 0.1);

	}

	@E("o app apresenta os passos para o Gympass e aciono continuar")
	public void o_app_apresenta_os_passos_para_o_Gympass_e_aciono_continuar(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(1000);
		// Assert.assertEquals(map.get("passo01"),
		// cadBeneficios.obterTextoGympassPasso1());
		// Assert.assertEquals(map.get("passo02"),
		// cadBeneficios.obterTextoGympassPasso2());
		// Assert.assertEquals(map.get("passo03"),
		// cadBeneficios.obterTextoGympassPasso3());
		// Assert.assertEquals(map.get("passo04"),
		// cadBeneficios.obterTextoGympassPasso4());
		// Assert.assertEquals(map.get("passo05"),
		// cadBeneficios.obterTextoGympassPasso5());
		// Assert.assertEquals(map.get("passo06"),
		// cadBeneficios.obterTextoGympassPasso6());

		Thread.sleep(1000);
		cadBeneficios.botaoContinuar();

	}

	@Entao("o app apresenta a tela da escolha salva e informando que foi enviado email sobre o Gympass e aciono avancar")
	public void o_app_apresenta_a_tela_da_escolha_salva_e_informando_que_foi_enviado_email_sobre_o_gympass_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(2000);

		// Assert.assertEquals(map.get("texto01"), cadBeneficios.textoSalvo());
		// Assert.assertEquals(map.get("texto02"),
		// cadBeneficios.obterTextoDeenvioEmail());
		cadBeneficios.botaoAvancar();

	}

	@Entao("o app apresenta a tela de informacoes do Plano de Saude")
	public void o_app_apresenta_a_tela_de_informacoes_do_plano_de_saude(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(1000);
		Assert.assertEquals(map.get("titulo"), cadBeneficios.tituloDoPlanoSaude());
		// Assert.assertEquals(map.get("texto01"),
		// cadBeneficios.texto01DoPlanoSaude());
		// Assert.assertEquals(map.get("texto02"),
		// cadBeneficios.texto02DoPlanoSaude());
		// Assert.assertEquals(map.get("texto03"),
		// cadBeneficios.texto03DoPlanoSaude());

		Thread.sleep(500);
		// Assert.assertEquals(map.get("texto04"),
		// cadBeneficios.texto04DoPlanoSaude());
		// Assert.assertEquals(map.get("texto05"),
		// cadBeneficios.texto05DoPlanoSaude());

		cadBeneficios.scroll(0.9, 0.1);

		// validando o carrossel

		Thread.sleep(2000);
		// Assert.assertEquals(map.get("carrossel01"),
		// cadBeneficios.textoSaudeDoCarrossel01());
		// Assert.assertEquals(map.get("carrossel02"),
		// cadBeneficios.textoSaudeDoCarrossel02());

		// cadBeneficios.lado(0.6, 0.1);
		// Assert.assertEquals(map.get("carrossel03"),
		// cadBeneficios.textoSaudeDoCarrossel03());

		// cadBeneficios.lado(0.9, 0.1);
		Thread.sleep(500);
		// cadBeneficios.lado(0.6, 0.1);
		// Assert.assertEquals(map.get("carrossel04"),
		// cadBeneficios.textoSaudeDoCarrossel04());

	}

	@E("aciono comando para adicionar dependentes")
	public void aciono_comando_para_adicionar_dependentes() throws InterruptedException {
		Thread.sleep(500);

		// cadBeneficios.clicarBotaoAdicionarDependentes();
		cadBeneficios.botaoAvancar();

	}

	@E("seleciono o dependente e aciono avancar da selecao do dependentes")
	public void seleciono_o_dependente_e_aciono_avancar_da_selecao_do_dependentes() {

		cadBeneficios.checkSelecionarDependente();
		cadBeneficios.botaoAvancarDependenteSaude();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do plano de saude e depois aciona avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_plano_de_saude_e_depois_aciona_avancar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Thread.sleep(2000);

		// System.out.println(cadBeneficios.tituloPlanoSelecionadoSaude());

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		// System.out.println(cadBeneficios.tituloPlanoSelecionadoSaude());
		// System.out.println(cadBeneficios.textoPlanoSelecionadoSaude());
		// System.out.println(cadBeneficios.textoTipoPlanoSelecionadoSaude());
		// System.out.println(cadBeneficios.nomeCadastradoNoPlano());
		// System.out.println(cadBeneficios.valorDescontoMensalPlanoSaude());
		//

		Assert.assertEquals(map.get("titulo"), cadBeneficios.tituloPlanoSelecionadoSaude());
		Assert.assertEquals(map.get("texto01"), cadBeneficios.textoPlanoSelecionadoSaude());
		Assert.assertEquals(map.get("texto02"), cadBeneficios.textoTipoPlanoSelecionadoSaude());
		Assert.assertEquals(map.get("Cadastrado no Plano"), cadBeneficios.nomeCadastradoNoPlano());
		Assert.assertEquals(map.get("Desconto mensal"), cadBeneficios.valorDescontoMensalPlanoSaude());
		cadBeneficios.botaoSetaAvancarSaude();

	}

	@Entao("o app apresenta a tela do termo de aceite do plano de saude")
	public void o_app_apresenta_a_tela_do_termo_de_aceite_do_plano_de_saude() throws InterruptedException {

		Thread.sleep(2000);
		// System.out.println(cadBeneficios.verificarTextoTermoSaude());
		Assert.assertEquals("Termos de escolha do benefício", cadBeneficios.verificarTextoTermoSaude());

	}

	@Quando("aciono aceitar o termo")
	public void aciono_aceitar_o_termo() throws InterruptedException {

		cadBeneficios.scroll(0.7, 0.1);
		cadBeneficios.clicarTermoSaude();
		cadBeneficios.clicarBotaoAceitar();

	}

	@Entao("o app apresenta a tela com o plano cadastro concluido e aciono o comando avancar")
	public void o_app_apresenta_a_tela_com_o_plano_cadastro_concluido_e_aciono_o_comando_avancar()
			throws InterruptedException {

		Thread.sleep(2000);
		// System.out.println(cadBeneficios.verificarTelaConcluidoPlanoSaude());
		Assert.assertEquals("Plano de saúde concluído!", cadBeneficios.verificarTelaConcluidoPlanoSaude());
		cadBeneficios.botaoAvancar();

	}

	@Entao("apresenta as informacoes sobre o beneficio flash e aciono comando continuar")
	public void apresenta_as_informacoes_sobre_o_beneficio_flash_e_aciono_comando_continuar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Thread.sleep(2000);

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Assert.assertEquals(map.get("texto01"), cadBeneficios.descricaoTextoFlash01());
		Assert.assertEquals(map.get("texto02"), cadBeneficios.descricaoTextoFlash02());

		cadBeneficios.scroll(0.7, 0.1);
		Thread.sleep(2000);

		Assert.assertEquals(map.get("texto03"), cadBeneficios.descricaoTextoFlash03());

		Thread.sleep(1000);

		cadBeneficios.lado(0.9, 0.1);
		Thread.sleep(2000);
		Assert.assertEquals(map.get("texto04"), cadBeneficios.descricaoTextoFlash04());

		Thread.sleep(2000);
		cadBeneficios.botaoComoUtilizarCartao();

		cadBeneficios.scroll(0.5, 0.1);
		Thread.sleep(2000);

		// System.out.println(cadBeneficios.descricaoTextoFlash05());
		// System.out.println(cadBeneficios.descricaoTextoFlash06());
		// System.out.println(cadBeneficios.descricaoTextoFlash07());

		Thread.sleep(1000);
		Assert.assertEquals(map.get("texto05"), cadBeneficios.descricaoTextoFlash05());
		Assert.assertEquals(map.get("texto06"), cadBeneficios.descricaoTextoFlash06());
		Assert.assertEquals(map.get("texto07"), cadBeneficios.descricaoTextoFlash07());
		cadBeneficios.botaoComoUtilizarCartao();
		Thread.sleep(1000);
		cadBeneficios.botaoContinuar();

	}

	@Entao("apresenta a tela de conclusao dos beneficios cadastrados")
	public void apresenta_a_tela_de_conclusao_dos_beneficios_cadastrados(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(2000);

		Assert.assertEquals(map.get("titulo"), cadBeneficios.textoConclusaoCadastroBeneficios());

	}

	// zerar o cadastro de beneficios (chamar o script do banco de dados)

	@Entao("seleciono a quantidade de onibus para a Ida ao trabalho {string} e a quantidade de metro {string} e aciono avancar e preencho os dados do onibus e metro a ser utilizado")
	public void seleciono_a_quantidade_de_onibus_para_a_ida_ao_trabalho_e_a_quantidade_de_metro_e_aciono_avancar_e_preencho_os_dados_do_onibus_e_metro_a_ser_utilizado(
			String quantidadeOnibusIda, String quantidadeMetro, io.cucumber.datatable.DataTable dataTable) {

		cadBeneficios.selecionarQuantidadeOnibusIda(quantidadeOnibusIda);
		cadBeneficios.selecionarQuantidadeMetro(quantidadeMetro);

		cadBeneficios.botaoAvancarValeOnibus();

		Assert.assertEquals("Informe a linha ou nome da empresa de transporte.",
				cadBeneficios.verificarTelaInformacoesOnibus());
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		switch (quantidadeOnibusIda) {
		case "1":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			break;

		case "2":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			break;

		case "3":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			break;

		case "4":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha4"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa4"));
			cadBeneficios.botaoAvancarQuartoOnibus();

			break;

		}

		cadBeneficios.preencgerCampoMetro(map.get("nomeLinhaMetro"));
		cadBeneficios.preencgerCampoPrecoPassagemMetro(map.get("valorTarifaMetro"));
		cadBeneficios.botaoAvancarQuartoOnibus();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do vale transporte do Onibus e metro com os respectivos valores e aciono avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_vale_transporte_do_onibus_e_metro_com_os_respectivos_valores_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Assert.assertEquals("Confirme seu pedido do vale transporte", cadBeneficios.verificarConfirmarPedidoTela());

		// cadBeneficios.clicarAbrirInfoDesconto();
		// Assert.assertTrue(cadBeneficios.verificarTextoInfoDesconto().trim()
		// .contains("Será descontado até 6% do valor de seu salário bruto para
		// o pagamento do VT."));
		// cadBeneficios.clicarFecharInfoDesconto();

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.scroll(0.5, 0.1);

		Assert.assertEquals(map.get("valorTrajetoIdaOnibus"), cadBeneficios.valorTrajetoIdaTelaOnibusMetro());
		Assert.assertEquals(map.get("valorTrajetoIdaMetro"), cadBeneficios.valorTrajetoIdaTelaMetro());
		Assert.assertEquals((map.get("valorTrajetoVoltaOnibus")), cadBeneficios.valorTrajetoVoltaOnibusMetroTela());
		Assert.assertEquals((map.get("valorTrajetoVoltaMetro")), cadBeneficios.valorTrajetoVoltaTelaMetro());
		Assert.assertEquals((map.get("valorTotalDiario")), cadBeneficios.valorTotalDiarioTelaOnibusEMetro());
		Assert.assertEquals((map.get("descontoMensal")), cadBeneficios.valorDescontoTelaOnibusEMetro());

		cadBeneficios.botaoAvancarTelaConfirmacao();

	}

	@Quando("o app apresenta a tela de outros para anexar o comprovante das informacoes anteriores")
	public void o_app_apresenta_a_tela_de_outros_para_anexar_o_comprovante_das_informacoes_anteriores() {

		Assert.assertEquals("Outros", cadBeneficios.verificarTelaAnexarOutrosComprovante());

	}

	@Quando("anexo o arquivo de comprovacao e aciono enviar")
	public void anexo_o_arquivo_de_comprovacao_e_aciono_avancar() throws InterruptedException {

		cadBeneficios.botaoAnexarArquivo();
		cadBeneficios.selecionarArquivo();
		cadBeneficios.botaoEnviarArquivo();

	}

	@Entao("o app apresenta a tela com dados de confirmacao do plano ondotologico")
	public void o_app_apresenta_a_tela_com_dados_de_confirmacao_do_plano_ondotologico(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Assert.assertEquals(map.get("plano"), cadBeneficios.verificarNomePlanoTela());
		Thread.sleep(500);
		Assert.assertEquals(map.get("nome cadastrado no plano"), cadBeneficios.verificarNomeCadastradoPlanoTela());
		Assert.assertEquals(map.get("valor do cadastrado no plano"), cadBeneficios.verificarValorCadastradoPlanoTela());
		Assert.assertEquals(map.get("desconto Mensal"), cadBeneficios.verificarValorDescontoPlanoTela());

	}

	@Entao("seleciono a quantidade de onibus para a Ida ao trabalho {string} a quantidade de metro {string} a quantidade de trem {string} e aciono avancar e preencho os dados do onibus metro e trem a ser utilizados")
	public void seleciono_a_quantidade_de_onibus_para_a_ida_ao_trabalho_a_quantidade_de_metro_a_quantidade_de_trem_e_aciono_avancar_e_preencho_os_dados_do_onibus_metro_e_trem_a_ser_utilizados(
			String quantidadeOnibusIda, String quantidadeMetro, String quantidaTrem,
			io.cucumber.datatable.DataTable dataTable) {

		cadBeneficios.selecionarQuantidadeOnibusIda(quantidadeOnibusIda);
		cadBeneficios.selecionarQuantidadeMetro(quantidadeMetro);
		cadBeneficios.selecionarQuantidaTrem(quantidaTrem);

		cadBeneficios.botaoAvancarValeOnibus();

		Assert.assertEquals("Informe a linha ou nome da empresa de transporte.",
				cadBeneficios.verificarTelaInformacoesOnibus());

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		switch (quantidadeOnibusIda) {
		case "1":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			break;

		case "2":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			break;

		case "3":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			break;

		case "4":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha4"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa4"));
			cadBeneficios.botaoAvancarQuartoOnibus();

			break;

		}

		cadBeneficios.preencgerCampoMetro(map.get("nomeLinhaMetro"));
		cadBeneficios.preencgerCampoPrecoPassagemMetro(map.get("valorTarifaMetro"));
		cadBeneficios.botaoAvancarVale();

		cadBeneficios.preencgerCampoTrem(map.get("nomeLinhaTrem"));
		cadBeneficios.preencgerCampoPrecoPassagemTrem(map.get("valorTarifaTrem"));
		cadBeneficios.botaoAvancarVale();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do vale transporte do Onibus metro e trem com os respectivos valores e aciono avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_vale_transporte_do_onibus_metro_e_trem_com_os_respectivos_valores_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(5000);

		cadBeneficios.scroll(0.7, 0.1);

		Assert.assertEquals(map.get("valorTrajetoIdaOnibus"), cadBeneficios.valorTrajetoIdaTelaOnibusMetroETrem());
		Assert.assertEquals(map.get("valorTrajetoIdaMetro"), cadBeneficios.valorTrajetoIdaTelaMetroETrem());
		Assert.assertEquals(map.get("valorTrajetoIdaTrem"), cadBeneficios.valorTrajetoIdaTelaTrem());
		Assert.assertEquals((map.get("valorTrajetoVoltaOnibus")),
				cadBeneficios.valorTrajetoVoltaOnibusMetroTelaETrem());
		Assert.assertEquals((map.get("valorTrajetoVoltaMetro")), cadBeneficios.valorTrajetoVoltaTelaMetroETrem());
		Assert.assertEquals((map.get("valorTrajetoVoltaTrem")), cadBeneficios.valorTrajetoVoltaTelaTrem());
		Assert.assertEquals((map.get("valorTotalDiario")), cadBeneficios.valorTotalDiarioTelaOnibusMetroETrem());
		Assert.assertEquals((map.get("descontoMensal")), cadBeneficios.valorDescontoTelaOnibusMetroETrem());

		Thread.sleep(500);
		cadBeneficios.botaoAvancarTelaConfirmacao();

	}

	@Entao("seleciono a quantidade de metro {string} a quantidade de trem {string} e aciono avancar e preencho os dados do metro e trem a serem utilizados")
	public void seleciono_a_quantidade_de_metro_a_quantidade_de_trem_e_aciono_avancar_e_preencho_os_dados_do_metro_e_trem_a_serem_utilizados(
			String quantidadeMetro, String quantidadeTrem, io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.selecionarQuantidadeMetro(quantidadeMetro);
		cadBeneficios.selecionarQuantidaTrem(quantidadeTrem);
		Thread.sleep(100);
		cadBeneficios.botaoAvancarValeTeste();

		cadBeneficios.preencgerCampoMetro(map.get("nomeLinhaMetro"));
		cadBeneficios.preencgerCampoPrecoPassagemMetro(map.get("valorTarifaMetro"));
		cadBeneficios.botaoAvancarVale();

		cadBeneficios.preencgerCampoTrem(map.get("nomeLinhaTrem"));
		cadBeneficios.preencgerCampoPrecoPassagemTrem(map.get("valorTarifaTrem"));
		cadBeneficios.botaoAvancarVale();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do vale transporte do metro e trem com os respectivos valores e aciono avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_vale_transporte_do_metro_e_trem_com_os_respectivos_valores_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Assert.assertEquals(map.get("valorTrajetoIdaMetro"), cadBeneficios.valorTrajetoIdaTelaMetroTrem());
		Assert.assertEquals(map.get("valorTrajetoIdaTrem"), cadBeneficios.valorTrajetoIdaTelaTremMetro());
		Assert.assertEquals((map.get("valorTrajetoVoltaMetro")), cadBeneficios.valorTrajetoVoltaTelaMetroTrem());
		Assert.assertEquals((map.get("valorTrajetoVoltaTrem")), cadBeneficios.valorTrajetoVoltaTelaTremMetro());

		Assert.assertEquals((map.get("valorTotalDiario")), cadBeneficios.valorTotalDiarioTelaMetroETrem());

		Assert.assertEquals((map.get("descontoMensal")), cadBeneficios.valorDescontoTelaMetroETrem());

		cadBeneficios.botaoAvancarTelaConfirmacao();

	}

	@Entao("seleciono a quantidade de onibus {string} a quantidade de trem {string} e aciono avancar e preencho os dados do onibus e trem a serem utilizados")
	public void seleciono_a_quantidade_de_onibus_a_quantidade_de_trem_e_aciono_avancar_e_preencho_os_dados_do_onibus_e_trem_a_serem_utilizados(
			String quantidadeOnibus, String quantidadeTrem, io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		cadBeneficios.selecionarQuantidadeOnibusIda(quantidadeOnibus);
		cadBeneficios.selecionarQuantidaTrem(quantidadeTrem);

		cadBeneficios.botaoAvancarValeOnibus();

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		switch (quantidadeOnibus) {
		case "1":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			break;

		case "2":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			break;

		case "3":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			break;

		case "4":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha4"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa4"));
			cadBeneficios.botaoAvancarQuartoOnibus();

			break;

		}

		cadBeneficios.preencgerCampoTrem(map.get("nomeLinhaTrem"));
		cadBeneficios.preencgerCampoPrecoPassagemTrem(map.get("valorTarifaTrem"));
		cadBeneficios.botaoAvancarVale();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do vale transporte do Onibus e trem com os respectivos valores e aciono avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_vale_transporte_do_onibus_e_trem_com_os_respectivos_valores_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(7000);

		cadBeneficios.scroll(0.7, 0.1);
		Thread.sleep(500);

		Assert.assertEquals(map.get("valorTrajetoIdaOnibus"), cadBeneficios.valorTrajetoIdaTelaOnibusTrem());
		Assert.assertEquals(map.get("valorTrajetoIdaTrem"), cadBeneficios.valorTrajetoIdaTelaTremOnibus());
		Assert.assertEquals((map.get("valorTrajetoVoltaOnibus")), cadBeneficios.valorTrajetoVoltaOnibusTremTela());
		Assert.assertEquals((map.get("valorTrajetoVoltaTrem")), cadBeneficios.valorTrajetoVoltaTremOnibusTela());
		Assert.assertEquals((map.get("valorTotalDiarioOnibusETrem")), cadBeneficios.valorTotalDiarioTelaOnibusTrem());
		Assert.assertEquals((map.get("descontoMensalOnibusETrem")), cadBeneficios.valorDescontoTelaOnibusETrem());

		cadBeneficios.botaoAvancarTelaConfirmacao();

	}

	@Entao("seleciono a quantidade de onibus para a Ida ao trabalho {string} aciono avancar, preencho os dados do onibus a ser utilizado no cadastro")
	public void seleciono_a_quantidade_de_onibus_para_a_ida_ao_trabalho_aciono_avancar_preencho_os_dados_do_onibus_a_ser_utilizado_no_cadastro(
			String quantidadeOnibusIda, io.cucumber.datatable.DataTable dataTable) {

		cadBeneficios.selecionarQuantidadeOnibusIda(quantidadeOnibusIda);
		cadBeneficios.botaoAvancarValeOnibus();

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		switch (quantidadeOnibusIda) {
		case "1":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro1"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa1"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			break;

		case "2":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro1"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa1"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			break;

		case "3":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro1"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa1"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			break;

		case "4":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro1"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa1"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinhaCadastro4"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorCadastroTarifa4"));
			cadBeneficios.botaoAvancarQuartoOnibus();

			break;

		}

	}

	@Entao("aciono o comando para alterar O\\(s) onibus {string} do trajeto de ida, altero os dados, aciono salvar e verifico os dados alterados")
	public void aciono_o_comando_para_alterar_o_s_onibus_do_trajeto_de_ida_altero_os_dados_aciono_salvar_e_verifico_os_dados_alterados(
			String quantidadeOnibusIda, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.botaoAlterarValeIda0();

		switch (quantidadeOnibusIda) {
		case "1":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(3000);

			Assert.assertEquals(map.get("nomeLinha1"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa());
			Assert.assertEquals(map.get("valorTarifa1"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa());

			break;

		case "2":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinha1"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa());
			Assert.assertEquals(map.get("valorTarifa1"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda02();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa2"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinha2"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_02_02());
			Assert.assertEquals(map.get("valorTarifa2"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_02_02());

			break;

		case "3":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinha1"),
					cadBeneficios.verificarAlteracaoNomeLinha01EmpresacomTresOnibus());
			Assert.assertEquals(map.get("valorTarifa1"),
					cadBeneficios.verificarAlteracaoValorLinha01EmpresaComTresOnibus());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda02();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa2"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinha2"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_02_03());
			Assert.assertEquals(map.get("valorTarifa2"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_02_03());

			cadBeneficios.scroll(0.7, 0.1);

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda03();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa3"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			cadBeneficios.scroll(0.5, 0.1);
			Thread.sleep(500);
			Assert.assertEquals(map.get("nomeLinha3"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_03_03());
			Assert.assertEquals(map.get("valorTarifa3"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_03_03());

			break;

		case "4":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinha1"),
					cadBeneficios.verificarAlteracaoNomeLinha01EmpresacomTresOnibus());
			Assert.assertEquals(map.get("valorTarifa1"),
					cadBeneficios.verificarAlteracaoValorLinha01EmpresaComTresOnibus());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda02();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa2"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinha2"),
					cadBeneficios.verificarAlteracaoNomeLinha02EmpresacomTresOnibus());
			Assert.assertEquals(map.get("valorTarifa2"),
					cadBeneficios.verificarAlteracaoValorLinha02EmpresaComTresOnibus());

			Assert.assertEquals(map.get("nomeLinha2"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_02_04());
			Assert.assertEquals(map.get("valorTarifa2"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_02_04());

			cadBeneficios.scroll(0.7, 0.1);

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda03_03_04onibus();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa3"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			cadBeneficios.scroll(0.5, 0.1);
			Thread.sleep(1000);
			Assert.assertEquals(map.get("nomeLinha3"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_03_04());
			Assert.assertEquals(map.get("valorTarifa3"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_03_04());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda03_04onibus();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinha4"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifa4"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			cadBeneficios.scroll(0.5, 0.1);

			Assert.assertEquals(map.get("nomeLinha4"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_04());
			Assert.assertEquals(map.get("valorTarifa4"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_04());

			break;

		}

	}

	@E("aciono o comando para voltar para a tela de confirmacao")
	public void aciono_o_comando_para_voltar_para_a_tela_de_confirmacao() {

		cadBeneficios.botaoVoltar();

	}

	// VOLTA

	@Entao("aciono o comando para alterar O\\(s) onibus {string} do trajeto de volta, altero os dados, aciono salvar e verifico os dados alterados")
	public void aciono_o_comando_para_alterar_o_s_onibus_do_trajeto_de_volta_altero_os_dados_aciono_salvar_e_verifico_os_dados_alterados(
			String quantidadeOnibusVolta, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.botaoAlterarValeVolta();

		switch (quantidadeOnibusVolta) {
		case "1":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta1"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa());
			Assert.assertEquals(map.get("valorTarifaVolta1"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa());

			break;

		case "2":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta1"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa());
			Assert.assertEquals(map.get("valorTarifaVolta1"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda02();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta2"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta2"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta2"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_02_02());
			Assert.assertEquals(map.get("valorTarifaVolta2"),
					cadBeneficios.verificarAlteracaoValorLinhaEmpresa_02_02());

			break;

		case "3":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta1"),
					cadBeneficios.verificarAlteracaoNomeLinha01EmpresacomTresOnibus());
			Assert.assertEquals(map.get("valorTarifaVolta1"),
					cadBeneficios.verificarAlteracaoValorLinha01EmpresaComTresOnibus());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda02();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta2"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta2"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta2"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_02_03());
			Assert.assertEquals(map.get("valorTarifaVolta2"),
					cadBeneficios.verificarAlteracaoValorLinhaEmpresa_02_03());

			cadBeneficios.scroll(0.7, 0.1);

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda03();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta3"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta3"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			cadBeneficios.scroll(0.5, 0.1);
			Thread.sleep(500);
			Assert.assertEquals(map.get("nomeLinhaVolta3"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_03_03());
			Assert.assertEquals(map.get("valorTarifaVolta3"),
					cadBeneficios.verificarAlteracaoValorLinhaEmpresa_03_03());

			break;

		case "4":

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda01();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta1"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta1"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta1"),
					cadBeneficios.verificarAlteracaoNomeLinha01EmpresacomTresOnibus());
			Assert.assertEquals(map.get("valorTarifaVolta1"),
					cadBeneficios.verificarAlteracaoValorLinha01EmpresaComTresOnibus());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda02();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta2"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta2"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			Assert.assertEquals(map.get("nomeLinhaVolta2"),
					cadBeneficios.verificarAlteracaoNomeLinha02EmpresacomTresOnibus());
			Assert.assertEquals(map.get("valorTarifaVolta2"),
					cadBeneficios.verificarAlteracaoValorLinha02EmpresaComTresOnibus());

			Assert.assertEquals(map.get("nomeLinhaVolta2"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_02_04());
			Assert.assertEquals(map.get("valorTarifaVolta2"),
					cadBeneficios.verificarAlteracaoValorLinhaEmpresa_02_04());

			cadBeneficios.scroll(0.7, 0.1);

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda03_03_04onibus();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta3"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta3"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			cadBeneficios.scroll(0.5, 0.1);
			Thread.sleep(1000);
			Assert.assertEquals(map.get("nomeLinhaVolta3"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_03_04());
			Assert.assertEquals(map.get("valorTarifaVolta3"),
					cadBeneficios.verificarAlteracaoValorLinhaEmpresa_03_04());

			Thread.sleep(500);
			cadBeneficios.botaoAlterarValeIda03_04onibus();
			cadBeneficios.preencherCampolinhaEmpresa(map.get("nomeLinhaVolta4"));
			cadBeneficios.preencherCampoValorlinhaEmpresa(map.get("valorTarifaVolta4"));
			cadBeneficios.botaoSalvar();
			Thread.sleep(2000);

			cadBeneficios.scroll(0.5, 0.1);

			Assert.assertEquals(map.get("nomeLinhaVolta4"), cadBeneficios.veriricarAlteracaoNomeLinhaEmpresa_04());
			Assert.assertEquals(map.get("valorTarifaVolta4"), cadBeneficios.verificarAlteracaoValorLinhaEmpresa_04());

			break;

		}

	}

	@Entao("aciono comando salvar alteraçoes e verifico os dados alterados da ida e volta na tela de confirmação")
	public void aciono_comando_salvar_alteraçoes_e_verifico_os_dados_alterados_da_ida_e_volta_na_tela_de_confirmação(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Thread.sleep(1000);
		cadBeneficios.botaSalvarAlteracoes();
		Thread.sleep(1000);

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Assert.assertEquals(map.get("TrajetoIdaOnibus"), cadBeneficios.verificarValorTrajetoIdaTotal());
		Assert.assertEquals(map.get("TrajetoVoltaOnibus"), cadBeneficios.verificarValorTrajetoVoltaTotal());
		Assert.assertEquals(map.get("ValorDiarioOnibus"), cadBeneficios.verificarValorTrajetoDiarioTotal());
		Assert.assertEquals(map.get("DescontoMensalOnibus"), cadBeneficios.verificarValorTrajetoDesconto());

	}

	@Entao("aciono pular o envio de documentos da declaração de dependentes")
	public void aciono_pular_o_envio_de_documentos_da_declaração_de_dependentes() throws InterruptedException {

		cadBeneficios.pularEnvioDoc();
		Thread.sleep(1000);
		cadBeneficios.scroll(0.9, 0.1);
		cadBeneficios.pularEnvioDoc();

	}

	@Entao("altero os dados do dependente e o app apresenta a mensagem {string}")
	public void altero_os_dados_do_dependente_e_o_app_apresenta_a_mensagem(String mensagem,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		map.get("Nome");
		Thread.sleep(1000);

		cadBeneficios.botaoAlterar();
		cadBeneficios.alterarNomeDependente(map.get("Nome"));
		cadBeneficios.alterarDataNascimentoDependente(map.get("Data de Nascimento"));
		cadBeneficios.alterarCPFDependente(map.get("CPF"));
		cadBeneficios.selecionarDependente(map.get("grauParentesto"));

		cadBeneficios.scroll(0.9, 0.1);
		Thread.sleep(500);
		cadBeneficios.botaSalvarAlteracoes();
		 Thread.sleep(500);
		Assert.assertEquals(mensagem, cadBeneficios.obterMensagemAlertaTeste(mensagem));
		

	}

	
	@E("verifico na tela os dados alterados")
	public void verifico_na_tela_os_dados_alterados(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(1000);
	Assert.assertEquals(map.get("Nome"), cadBeneficios.verificarNomeDependenteAlterado());
	Assert.assertEquals(map.get("Data de Nascimento"), cadBeneficios.verificarDataDependenteAlterado());
	Assert.assertEquals(map.get("grauParentesto"), cadBeneficios.verificarGrauParentescoDependenteAlterado());
	

	
	
	}
	

}
