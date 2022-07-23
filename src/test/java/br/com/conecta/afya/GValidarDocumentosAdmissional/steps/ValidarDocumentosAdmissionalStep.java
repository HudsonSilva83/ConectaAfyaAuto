package br.com.conecta.afya.GValidarDocumentosAdmissional.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;

import br.com.conecta.afya.ACadastrarNovoColaborador.persist.CadastroBeneficiosDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ColaboradorDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.DadosBancariosDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.EnviarDocumentosDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ExameAdmissionalDAO;
import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ExcluirGeralDAO;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import br.com.conecta.afya.page.ValidarDocumentosAdmissionaisPage;
import br.com.conecta.afya.services.AgendamentoCadastrar;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ValidarDocumentosAdmissionalStep {

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	ValidarDocumentosAdmissionaisPage DocumentosAdmissionais = new ValidarDocumentosAdmissionaisPage();

	private String feature = "validar documento admissional";
	private String cenario = "";
	
	static ExcluirGeralDAO excluir = new ExcluirGeralDAO();
	static ColaboradorDAO cola = new ColaboradorDAO();
	static EnviarDocumentosDAO doc = new EnviarDocumentosDAO();
	static DadosBancariosDAO banco = new DadosBancariosDAO();
	static CadastroBeneficiosDAO bene = new CadastroBeneficiosDAO();
	static ExameAdmissionalDAO exame = new ExameAdmissionalDAO();
	
	

	@Before
	public void setCenario(Scenario cen) throws ClientProtocolException, IOException, SQLException {
		// feature = cen.getId().split(";")[0];
		cenario = cen.getName();
		
		excluir.excluirGeral();
		cola.cadastrarColaborador();
		doc.cadastroDocumento();
		banco.cadastrarDadosBancarios();
		bene.cadastrarBeneficios();
		exame.agendarExemaAdmissional();
		exame.confirmarEnviarExemaAdmissional();
		exame.aprovarExemaAdmissional();
		
		

//		 AgendamentoCadastrar servicoAgendar = new AgendamentoCadastrar();
//		 servicoAgendar.agendamentoCadastrar();

		// System.out.println(servicoAgendar.agendamentoCadastrar());

	}

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "ValidarDocumentosAdmissional");

	}

	@After
	public static void finalizaCenario() {
		excluir.excluirGeral();
		 DriverFactory.KillDriver();

	}

	@Dado("que eu esteja logado e que ja tenha enviado os documentos para admissao, adicionado os Dados Bancarios e cadastrado os Beneficios e com exame aprovado")
	public void que_eu_esteja_logado_e_que_ja_tenha_enviado_os_documentos_para_admissao_adicionado_os_dados_bancarios_e_cadastrado_os_beneficios_e_com_exame_aprovado(
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

	@Entao("o app apresenta a tela para iniciar a validacao dos documentos Admissional")
	public void o_app_apresenta_a_tela_para_iniciar_a_validacao_dos_documentos_admissional()
			throws InterruptedException {

		Thread.sleep(6000);
		DocumentosAdmissionais.scrollar(0.8, 0.1);
		
		DocumentosAdmissionais.scrollar(0.7, 0.1);

	}

	@Quando("aciono o comando para comecar a verificar")
	public void aciono_o_comando_para_comecar_a_verificar() throws InterruptedException {

		DocumentosAdmissionais.botaoComecar();
		Thread.sleep(4000);

		DocumentosAdmissionais.scrollar(0.4, 0.1);

	}

	@Entao("o app apresenta a tela para confirmar os dados do RG")
	public void o_app_apresenta_a_tela_para_confirmar_os_dados_do_rg(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(2000);

		Assert.assertTrue(DocumentosAdmissionais.dadosRGValorIdentidade().contains(map.get("Identidade")));
		Assert.assertTrue(DocumentosAdmissionais.dadosRGNascimento().contains(map.get("Nascimento")));
		Assert.assertTrue(DocumentosAdmissionais.dadosRGEstadoCivil().contains(map.get("Estado Civil")));
		Assert.assertTrue(DocumentosAdmissionais.dadosRGSexo().contains(map.get("Sexo")));
		Assert.assertTrue(DocumentosAdmissionais.dadosRGNacionalidade().contains(map.get("Nacionalidade")));
		Assert.assertTrue(DocumentosAdmissionais.dadosRGEstadonatal().contains(map.get("Estado Natal")));
		Assert.assertTrue(DocumentosAdmissionais.dadosRGCidadenatal().contains(map.get("Cidade Natal")));

	}

	@Entao("verifico também a tela para confirmar os dados da Carteira de Trabalho")
	public void verifico_também_a_tela_para_confirmar_os_dados_da_carteira_de_trabalho(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		DocumentosAdmissionais.ladoDireito(0.9, 0.1);

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(2000);

		Assert.assertTrue(DocumentosAdmissionais.dadosCarteiraTrabalhoNumero().contains(map.get("Numero")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCarteiraTrabalhoSerie().contains(map.get("Serie")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCarteiraTrabalhoEmissao().contains(map.get("Emissão")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCarteiraTrabalhoPISPASEP().contains(map.get("PIS/PASESP")));
		Assert.assertTrue(
				DocumentosAdmissionais.dadosCarteiraTrabalhoRegistro().contains(map.get("Registro Profissional")));

	}

	@Entao("verifico também a tela para confirmar os dados do titulo de eleitor")
	public void verifico_também_a_tela_para_confirmar_os_dados_do_titulo_de_eleitor(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		DocumentosAdmissionais.ladoDireito(0.9, 0.1);
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(1000);

		Assert.assertTrue(DocumentosAdmissionais.dadosTituloEleitorNumero().contains(map.get("Numero")));
		Assert.assertTrue(DocumentosAdmissionais.dadosTituloEleitorEmissao().contains(map.get("Emissão")));
		Assert.assertTrue(DocumentosAdmissionais.dadosTituloEleitorUF().contains(map.get("UF")));
		Assert.assertTrue(DocumentosAdmissionais.dadosTituloEleitorZona().contains(map.get("Zona")));
		Assert.assertTrue(DocumentosAdmissionais.dadosTituloEleitorSecao().contains(map.get("Secao")));


	}

	@Entao("verifico também a tela para confirmar os dados do Grau de instrução")
	public void verifico_também_a_tela_para_confirmar_os_dados_do_grau_de_instrução(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		DocumentosAdmissionais.ladoDireito(0.9, 0.1);

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(1000);

		Assert.assertTrue(DocumentosAdmissionais.dadosPessoaisGrauInstituicao().contains(map.get("Educação")));

	}

	@Entao("verifico também a tela para confirmar os dados do Endereco")
	public void verifico_também_a_tela_para_confirmar_os_dados_do_endereco(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		DocumentosAdmissionais.ladoDireito(0.9, 0.1);
		Thread.sleep(3000);

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
	//System.out.println(DocumentosAdmissionais.dadosEnderecoRua());	

		Assert.assertTrue(DocumentosAdmissionais.dadosEnderecoRua().contains(map.get("Rua")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEnderecoComplemento().contains(map.get("Complemento")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEnderecoNumero().contains(map.get("Numero")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEnderecoBairro().contains(map.get("Bairro")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEnderecoCidade().contains(map.get("Cidade")));

	}
	
	
	@Entao("o app apresenta a tela para confirmar os dados do Cargo")
	public void o_app_apresenta_a_tela_para_confirmar_os_dados_do_cargo(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		
		Thread.sleep(1000);
		DocumentosAdmissionais.scrollar(0.8, 0.1);
		// Thread.sleep(500);
		DocumentosAdmissionais.scrollar(0.3, 0.1);
		Thread.sleep(500);
		
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		//System.out.println(DocumentosAdmissionais.dadosEnderecoRua());	

		//Assert.assertTrue(DocumentosAdmissionais.dadosCargoCargo().contains(map.get("Cargo")));

		System.out.println(DocumentosAdmissionais.dadosCargoCargo());
		
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoCargo().contains(map.get("Cargo")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoArea().contains(map.get("Area")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoAdmissao().contains(map.get("Admissiao")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoFormaPag().contains(map.get("Forma de pagamento")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoSalario().contains(map.get("Salario")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoSalHora().contains(map.get("Salario hora")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoJornada().contains(map.get("Jornada")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoOpcao().contains(map.get("Opcao F")));
		Assert.assertTrue(DocumentosAdmissionais.dadosCargoHorario().contains(map.get("Horario")));
	
	  
	}
	
	

	@Entao("o app apresenta a tela para confirmar os dados da empresa")
	public void o_app_apresenta_a_tela_para_confirmar_os_dados_da_empresa(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		

		Thread.sleep(1000);
		DocumentosAdmissionais.scrollar(0.8, 0.1);
		// Thread.sleep(500);
		DocumentosAdmissionais.scrollar(0.8, 0.1);
		Thread.sleep(500);
		
		DocumentosAdmissionais.scrollar(0.4, 0.1);
		Thread.sleep(500);
		
		
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		
		Assert.assertTrue(DocumentosAdmissionais.dadosEmpresaEmpresa().contains(map.get("Empresa")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEmpresaEndereço().contains(map.get("Endereço")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEmpresaCEP().contains(map.get("CEP")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEmpresaEmissão().contains(map.get("Emissão")));
		Assert.assertTrue(DocumentosAdmissionais.dadosEmpresaCNPJ().contains(map.get("CNPJ")));
		
		
	    
	}




}
