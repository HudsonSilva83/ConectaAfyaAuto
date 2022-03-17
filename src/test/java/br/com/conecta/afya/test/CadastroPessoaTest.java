package br.com.conecta.afya.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.model.Credenciais;
import br.com.conecta.afya.page.CadastroPage;
import br.com.conecta.afya.page.CadastroSenhaPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.InformacoesPessoaisPage;
import br.com.conecta.afya.page.LoginPage;
import br.com.conecta.afya.services.ExcluirDocumentos;
import br.com.conecta.afya.services.ExcluirUsuario;
import br.com.conecta.afya.services.GerarCodigoAcesso;
import br.com.conecta.afya.services.ObterCPFSenha;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CadastroPessoaTest extends BaseTest {

	private AndroidDriver<MobileElement> driver;
	HomePage home = new HomePage();
	CadastroPage cadastro = new CadastroPage();
	CadastroSenhaPage cadastroSenha = new CadastroSenhaPage();
	InformacoesPessoaisPage informacoesPessoais = new InformacoesPessoaisPage();
	GerarCodigoAcesso codigoAcesso = new GerarCodigoAcesso();

	LoginPage login = new LoginPage();

	// @Before
	// public void inicializarAppium() throws Exception {
	// driver = DriverFactory.getDriver();
	//
	// }

	@Test

	public void cadastroPessoaComSucesso() throws Exception {

		 ExcluirUsuario exusu = new ExcluirUsuario();
		 exusu.excluirUsuario();
		//
		// ExcluirDocumentos exdoc = new ExcluirDocumentos();
		// exdoc.excluirDocumentos();

		// servi�o aonde traz somente o codigo
		 String codigo = GerarCodigoAcesso.gerarCodigoAcesso();
		 System.out.println(codigo);

		Credenciais credenciais = ObterCPFSenha.postCredenciais();
		//
//		String CPF = credenciais.getLogin();
//		String codigo = credenciais.getPassword();
		//
		Thread.sleep(1000);
		home.preencherCodigoAcesso(codigo);
		home.avancarButton();
		Thread.sleep(2000);

		Assert.assertTrue(cadastro.verificarTextoPreCadastro("Bem vindo!"));
		Assert.assertTrue(cadastro
				.verificarTextoPreCadastro("Ficamos muito felizes por voc� ter escolhido fazer parte do nosso time!"));
		Assert.assertTrue(cadastro.verificarTextoPreCadastro(
				"Nesta primeira etapa � necess�rio que voc� siga os passos abaixo para completar seu cadastro."));
		// Thread.sleep(2000);

		cadastro.alterarNome("Automacao Conecta Afya");

		cadastro.alterarEmail("conecta.afya@gmail.com");

		cadastro.alterarTelefone("(99) 99999-9999");

		Assert.assertTrue(cadastro.verificarCampoPreenchido("Automacao Conecta Afya"));
		Assert.assertTrue(cadastro.verificarCampoPreenchido("conecta.afya@gmail.com"));
		Assert.assertTrue(cadastro.verificarCampoPreenchido("(99) 99999-9999"));
		Assert.assertTrue(cadastro.verificarCampoPreenchido("ANALISTA DE DADOS PL"));
		Assert.assertTrue(cadastro.verificarCampoPreenchido("AFYA"));
		cadastro.aceitarTermosCondicoes();
		cadastro.botaoConfirmar();
		Thread.sleep(1000);
		cadastro.assinar();
		Thread.sleep(1000);
		cadastro.botaoAvancarAssinatura();

		cadastroSenha.preencherCampoSenha("@TesteAutomacaoAfya22");

		cadastroSenha.botaoAvancarSenha();

		Assert.assertTrue(
				cadastro.verificarTextoPreCadastro("A primeira etapa do seu cadastro foi conclu�da com sucesso"));
		Assert.assertTrue(cadastro.verificarTextoPreCadastro(
				"Agora, precisaremos de informa��es pessoais suas para completar seu cadastro"));

		cadastroSenha.botaoContinuar();

		Assert.assertTrue(informacoesPessoais.verificarTextoTelaInformacoesPessoais("Informa��es pessoais"));

		informacoesPessoais.preencherCampoNomeSocial("Automa��o Social Afya");
		informacoesPessoais.preencherCampoApelido("Automa��o Apelido Afya");
		informacoesPessoais.possueCertificadoReservista("Sim");
		informacoesPessoais.selecionarIdentidadeGenero("N�o-bin�rio");
		informacoesPessoais.selecionarRaca("Outra op��o");
		informacoesPessoais.selecionarDeficiencia("Prefiro n�o informar");
		informacoesPessoais.botaoAvancarTela();
		informacoesPessoais.telaCadastroComSucesso();
		Assert.assertEquals("true", informacoesPessoais.telaCadastradoSucesso());

	}

}
