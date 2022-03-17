package br.com.conecta.afya.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.EnviarDocumentacaoPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
//import br.com.conecta.afya.services.ExcluirDocumentos;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EnviarDocumentosTest extends BaseTest {

	private AndroidDriver<MobileElement> driver;
	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	EnviarDocumentacaoPage enviarDocPage = new EnviarDocumentacaoPage();

	@Test
	public void enviarDocumentos() throws InterruptedException, IOException {

//		 ExcluirDocumentos excluirDoc = new ExcluirDocumentos();
//		 excluirDoc.excluirDocumentos();
		

		home.clicarJaTenhoUmaConta();
		login.preencherCpf("28612091004");
		//login.preencherCpf("77707180070");
		
		
		login.preencherSenha("@TesteAutomacaoAfya22");
		 //login.preencherSenha("GNJDHO1Q");

		Assert.assertTrue(enviarDocPage.validarTela("Seu processo de admissão"));
		enviarDocPage.botaoEnviarDocumentos();
		Assert.assertEquals(
				"Você só pode concluir o processo se estiver com os documentos abaixo, com exceção do que não se aplica",
				enviarDocPage.validarTelaDocumentosNecessarios());
		enviarDocPage.botaoContinuar();

		enviarDocPage.botaoEnviar();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoeSocial();
		enviarDocPage.botaoEnviarArquivo();
		Thread.sleep(7000);
		enviarDocPage.botaoEnviar();


		enviarDocPage.preencherRG("11395038");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherOrgaoEmissor("SSP");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoRG("25/12/2000");

		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeUF("MG");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeNacionalidade("Brasileira");
		enviarDocPage.botaoSetaBaixo();

		enviarDocPage.preencherIdentidadeEstadoNatal("Minas Gerais");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeCidadeNatal("Belo Horizonte");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaDataNascimento("09/03/1983");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaNomeMae("Nome Mae");
		enviarDocPage.botaoCheckFinalizar();

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoIdentidadeFrente();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoIdentidadeVerso();
		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviarArquivo();

		// carteira de trabalho
		Thread.sleep(6000);
		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviar();
		enviarDocPage.preencherNumeroCarteiraTrabalho("7777777");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroSerieCarteiraTrabalho("01");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherUFCarteiraTrabalho("MG");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoCTPS("25/12/2000");
		enviarDocPage.botaoCheckFinalizar();

		Thread.sleep(3000);
		enviarDocPage.descerTela();

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoCTPSFrente();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoCTPSDados();
		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviarArquivo();
		Thread.sleep(6000);
		enviarDocPage.botaoEnviar();
		
		
		//trabalhando aqui
		enviarDocPage.preencherCep("31680320");
		enviarDocPage.enderecoVisivel();
		enviarDocPage.botaoSetaBaixo();
		
		
		//Thread.sleep(4000);
		
		enviarDocPage.preencherNumeroEndereco("400");
		enviarDocPage.preencherComplemento("Ap 101 Bloco F");
		enviarDocPage.botaoCheckFinalizar();
		enviarDocPage.anexarComprovanteResidencia();
		enviarDocPage.anexarFoto();
		enviarDocPage.selecionarEstadoCivil("Casado(a)");
		enviarDocPage.anexarCertidaoCasamento();
		enviarDocPage.botaoPreencherPis("11111111111");
		enviarDocPage.preeencherTituloEleitor("111111111111");
		enviarDocPage.preeencherDataEmissaoTituloEleitor("12/03/1993");
		enviarDocPage.preeencherUFTituloEleitor("MG");
		enviarDocPage.preeencherZonaVotacao("01");
		enviarDocPage.preeencherSecaoVotacao("02");
		enviarDocPage.enviarTitulo();
		enviarDocPage.comprovanteVotacao();
		
		
		//certificadoReservista
		
		
		enviarDocPage.anexarCertificadoReservista();
		Thread.sleep(3000);
		enviarDocPage.informarDiplomaEscolaridade();
		enviarDocPage.selecionarGrauInstrucao("Ensino fundamental incompleto");
		enviarDocPage.anexarDiplomaEscolaridade();
		enviarDocPage.informarDependentes("NÃO TENHO DEPENDENTES");
		enviarDocPage.adicionarConta();
		enviarDocPage.informarDadosConta("Itaú","001","12345678-9");
		Thread.sleep(3000);
		enviarDocPage.anexarComprovanteConta();
		enviarDocPage.verificarEtapa();

		
		enviarDocPage.concluirEnvio();
		Thread.sleep(1000);
		enviarDocPage.aceitarTermo();
		enviarDocPage.concluirEnvio();
		
		
		Assert.assertEquals("Documentos enviados", enviarDocPage.verificaMensagemDocumentosEnviados());
		enviarDocPage.botaoIrHomePage();
		
		//System.out.println(home.verificarCadastroSucesso());
		
		//Assert.assertTrue(home.verificarCadastroSucesso().contains("Cadastro Conta criada com sucesso :)"));
		//Assert.assertTrue(home.verificarEnvioDocumentoSucesso().contains("Envio de documentos Realizado com sucesso :)"));
		
		//Thread.sleep(10000);

	}

}
