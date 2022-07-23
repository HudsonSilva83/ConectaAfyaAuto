package br.com.conecta.afya.FCadastrarAgendamentoExame.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;

import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ExameAdmissionalDAO;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.CadastroBeneficiosPage;
import br.com.conecta.afya.page.CadastroExameAdmissionalPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import br.com.conecta.afya.services.AgendamentoCadastrar;
import br.com.conecta.afya.services.AprovarExameAdmissional;
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

public class AgendamentoExameAppStep {

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	CadastroExameAdmissionalPage CadastroExame = new CadastroExameAdmissionalPage();
	
	static ExameAdmissionalDAO exame = new ExameAdmissionalDAO();
	
	

	private String feature = "Agendar Exame";
	private String cenario = "";

	@Before
	public void setCenario(Scenario cen) throws ClientProtocolException, IOException, SQLException {
		// feature = cen.getId().split(";")[0];
		cenario = cen.getName();
		exame.deletarExemaAdmissional();
		exame.agendarExemaAdmissional();

//		AgendamentoCadastrar servicoAgendar = new AgendamentoCadastrar();
//		servicoAgendar.agendamentoCadastrar();

		// System.out.println(servicoAgendar.agendamentoCadastrar());

	}

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "AgendarExame");

	}

	@After
	public static void finalizaCenario() throws SQLException {
		//exame.deletarExemaAdmissional();
		DriverFactory.KillDriver();

	}

	@Dado("que eu esteja logado e que ja tenha enviado os documentos para admissao, adicionado os Dados Bancarios e cadastrado os Beneficios")
	public void que_eu_esteja_logado_e_que_ja_tenha_enviado_os_documentos_para_admissao_adicionado_os_dados_bancarios_e_cadastrado_os_beneficios(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException, SQLException {

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
		
		Thread.sleep(6000);
		
		
		CadastroExame.botaoDeslogar();
		Thread.sleep(2000);
		home.clicarJaTenhoUmaConta();
		Thread.sleep(3000);
		login.preencherCpf("28612091004");
		login.botaoAvancar();
		Thread.sleep(1000);
		login.preencherSenha("@TesteAutomacaoAfya22");
		login.botaoAvancarSenha();
//		Thread.sleep(3000);
//		CadastroExame.scroll(0.7, 0.1);
//		CadastroExame.scroll(0.5, 0.1);
//		Thread.sleep(1000);
		
	

	}

	@Entao("o app apresenta a tela para confirmar o agendamento do exame")
	public void o_app_apresenta_a_tela_para_confirmar_o_agendamento_do_exame()
			throws ClientProtocolException, IOException, InterruptedException, SQLException {

		Thread.sleep(6000);
		CadastroExame.scroll(0.8, 0.1);
		CadastroExame.scroll(0.4, 0.1);
		Thread.sleep(2000);
		
		
		Assert.assertEquals(CadastroExame.verificarDataExame(),CadastroExame.verificarDataTelaApp01());
		

	}

	@Quando("aciono o comando para confirmar o agendamento")
	public void aciono_o_comando_para_confirmar_o_agendamento() throws InterruptedException {

		CadastroExame.scroll(0.5, 0.1);
		Thread.sleep(500);
		CadastroExame.botaoVerComDetalhes();

	}

	@Entao("o app apresenta a tela para confirmar o agendamento")
	public void o_app_apresenta_a_tela_para_confirmar_o_agendamento(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		map.get("Nome da Clinica");
		map.get("Endereco");
		map.get("Instrucoes");

		
		CadastroExame.scroll(0.9, 0.1);
		CadastroExame.scroll(0.4, 0.1);

		Thread.sleep(3000);
		

		Assert.assertTrue(CadastroExame.verificarDadosTelaExame().contains(map.get("Nome da Clinica")));
		Assert.assertTrue(CadastroExame.verificarDadosTelaExame().contains(map.get("Endereco")));
		Assert.assertTrue(CadastroExame.verificarDadosTelaExame().contains(map.get("Instrucoes")));
		//System.out.println(CadastroExame.verificarHoraTelaExameApp());
		//System.out.println(CadastroExame.horaLocal());
		//Assert.assertEquals(CadastroExame.horaLocal(), CadastroExame.verificarHoraTelaExameApp());
		//Assert.assertTrue(CadastroExame.horaLocal().contains(CadastroExame.verificarHoraTelaExameApp()));

	}

	@Quando("aciono o comando para aceitar a disponibilidade nesta data")
	public void aciono_o_comando_para_aceitar_a_disponibilidade_nesta_data() throws InterruptedException {

		Thread.sleep(1000);
		CadastroExame.botaoAceitarAgendamentoExame();

	}

	@Entao("o app apresenta o exame agendado com o texto {string}")
	public void o_app_apresenta_o_exame_agendado_com_o_texto(String texto) throws InterruptedException {

		Thread.sleep(3000);
		Assert.assertEquals(texto, CadastroExame.TelaAgendamentoRealizado());

	}

	@E("aciono o comando para ir para a home para confirmar o agendamento")
	public void aciono_o_comando_para_ir_para_a_home_para_confirmar_o_agendamento() throws InterruptedException {

		Thread.sleep(500);
		CadastroExame.clicarBotaoHome();

	}

	@E("confirme o agendamento com os dados abaixo")
	public void confirme_o_agendamento_com_os_dados_abaixo(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(5000);
		CadastroExame.scroll(0.7, 0.1);
		CadastroExame.scroll(0.4, 0.1);
		Thread.sleep(1000);
		Assert.assertEquals(CadastroExame.verificarDataExame(), CadastroExame.verificarDataTelaApp02());
		CadastroExame.botaoConfirmarExame();
		Thread.sleep(1000);
		CadastroExame.scroll(0.7, 0.1);

		Assert.assertEquals(CadastroExame.verificarDataExame(), CadastroExame.verificarDataTelaApp03());
		Assert.assertEquals(map.get("Nome da Clinica"), CadastroExame.verificarNomeClinicaTelaApp());
		Assert.assertEquals(map.get("Endereco"), CadastroExame.verificarEnderecoTelaApp());
		System.out.println(CadastroExame.verificarEnderecoTelaApp());
		CadastroExame.botaoJaRealizeiExame();

	}

	@Quando("anexo o exame e confirmo")
	public void anexo_o_exame_e_confirmo() throws InterruptedException {

		Thread.sleep(1000);
		CadastroExame.scroll(0.7, 0.1);
		Thread.sleep(500);
		CadastroExame.botaoAnexarExame();
		CadastroExame.selecionarArquivo();
		CadastroExame.scroll(0.7, 0.1);
		CadastroExame.botaoConfirmar();

	}

	@Entao("o app apresenta a tela do exame enviado {string}")
	public void o_app_apresenta_a_tela_do_exame_enviado(String string) {
		System.out.println(CadastroExame.verificarTextoExameEnviado());
	}

	@Entao("aciono o comando para retomar a tela home do app")
	public void aciono_o_comando_para_retomar_a_tela_home_do_app() throws InterruptedException {
		CadastroExame.botaoIrParaHome();
		Thread.sleep(3000);
		CadastroExame.scroll(0.8, 0.1);
		CadastroExame.scroll(0.6, 0.1);
		
	}
	
	@E("apresenta a informacao que o exame esta sendo analisado {string}")
	public void apresenta_a_informacao_que_o_exame_esta_sendo_analisado(String texto)
			throws InterruptedException, IOException, SQLException {
		
		Thread.sleep(1000);
		Assert.assertEquals(texto, CadastroExame.telaHomeExameAnalisando());
		
	
		
		
		
		//rodar a atualização ou rodar o endpoint
		
//		exame.aprovandoExemaAdmissional();
		
//		AprovarExameAdmissional exame = new AprovarExameAdmissional();
		//exame.aprovarExame();
		
		exame.aprovarExemaAdmissional();
		
		CadastroExame.botaoDeslogar();
		Thread.sleep(2000);
		home.clicarJaTenhoUmaConta();
		Thread.sleep(3000);
		login.preencherCpf("28612091004");
		login.botaoAvancar();
		Thread.sleep(1000);
		login.preencherSenha("@TesteAutomacaoAfya22");
		login.botaoAvancarSenha();
		Thread.sleep(3000);
		CadastroExame.scroll(0.7, 0.1);
		CadastroExame.scroll(0.5, 0.1);
		Thread.sleep(1000);
	
		
	}
	
	@Entao("apos a analise e aprovacao o app apresenta a tela com a informacao {string}")
	public void apos_a_analise_e_aprovacao_o_app_apresenta_a_tela_com_a_informacao(String texto) {
	   
		Assert.assertEquals(texto, CadastroExame.telaHomeExameAprovado());

	
		
	}



}
