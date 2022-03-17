package br.com.conecta.afya.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;
import javafx.collections.ModifiableObservableListBase;

public class EnviarDocumentacaoPage extends BasePage {

	public void descerTela() throws InterruptedException {

		Thread.sleep(1000);
		scroll(0.6, 0.1);

	}

	public boolean validarTela(String texto) {
		return existeElementoPorAtributo(MobileBy.AccessibilityId("Seu processo de admissão"), "content-desc", texto);

	}

	public void botaoEnviarDocumentos() throws InterruptedException {
		descerTela();
		Thread.sleep(1000);
		clicar(MobileBy.AccessibilityId("ENVIAR DOCUMENTOS"));
	}

	public String validarTelaDocumentosNecessarios() {

		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Você só pode concluir o processo se estiver com os documentos abaixo, com exceção do que não se aplica"));

	}

	public void botaoContinuar() throws InterruptedException {
		descerTela();
		descerTela();
		clicar(MobileBy.AccessibilityId("CONTINUAR"));
		descerTela();

	}

	public void botaoEnviar() throws InterruptedException {

		Thread.sleep(5000);
		scroll(0.9, 0.1);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ENVIAR")));

		clicar(MobileBy.AccessibilityId("ENVIAR"));
	}

	public void botaoAnexarArquivo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Anexar arquivo")));

		clicar(MobileBy.AccessibilityId("Anexar arquivo"));

	}

	public void pegarArquivoeSocial() throws InterruptedException {

		Thread.sleep(2000);
		// scroll(0.8, 0.1);

		// clicar(By.xpath("//android.widget.ImageButton[@content-desc='Show
		// roots']"));

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='arquivoJPG.jpg']")));

		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		// clicar(By.xpath("//*[@text='eSocial.pdf']"));
		descerTela();

	}

	public void botaoEnviarArquivo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ENVIAR ARQUIVO")));

		clicar(MobileBy.AccessibilityId("ENVIAR ARQUIVO"));

	}

	public void botaoIdentidade() {
		clicar(MobileBy.AccessibilityId("ENVIAR"));

	}

	public void preencherRG(String RG) {
		escrever(By.xpath("//*[@text='Digite aqui']"), RG);

	}

	public void preencherOrgaoEmissor(String RG) {
		escrever(By.xpath("//*[@text='Digite aqui']"), RG);

	}

	public void botaoSetaBaixo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void preencherDataEmissaoRG(String dataEmissaoRG) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataEmissaoRG);

	}

	public void preencherIdentidadeUF(String identidadeUF) {
		escrever(By.xpath("//*[@text='Digite aqui']"), identidadeUF);

	}

	public void preencherIdentidadeNacionalidade(String nacionalidade) {
		escrever(By.xpath("//*[@text='Digite aqui']"), nacionalidade);

	}

	public void preencherIdentidadeEstadoNatal(String estadoNatal) {
		escrever(By.xpath("//*[@text='Digite aqui']"), estadoNatal);

	}

	public void preencherIdentidadeCidadeNatal(String cidadeNatal) {
		escrever(By.xpath("//*[@text='Digite aqui']"), cidadeNatal);

	}

	public void preencherIdentidaDataNascimento(String dataNascimento) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataNascimento);

	}

	public void preencherIdentidaNomeMae(String nomeMae) {
		escrever(By.xpath("//*[@text='Digite aqui']"), nomeMae);

	}

	public void botaoCheckFinalizar() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void botaoAnexarIdentidade() {
		clicar(By.xpath("(//android.widget.ImageView)[7]"));

	}

	public void pegarArquivoIdentidadeFrente() throws InterruptedException {

		Thread.sleep(1000);
		// scroll(0.9, 0.1);
		// Thread.sleep(1000);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void pegarArquivoIdentidadeVerso() throws InterruptedException {
		// scroll(0.9, 0.1);
		Thread.sleep(1000);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void preencherNumeroCarteiraTrabalho(String numCarteiraTrabalho) {
		escrever(By.xpath("//*[@text='Digite aqui']"), numCarteiraTrabalho);

	}

	public void preencherNumeroSerieCarteiraTrabalho(String serieCarteiraTrabalho) {
		escrever(By.xpath("//*[@text='Digite aqui']"), serieCarteiraTrabalho);

	}

	public void preencherUFCarteiraTrabalho(String ufCarteiraTrabalho) {
		escrever(By.xpath("//*[@text='Digite aqui']"), ufCarteiraTrabalho);

	}

	public void preencherDataEmissaoCTPS(String dataEmissaoCTPS) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataEmissaoCTPS);

	}

	public void pegarArquivoCTPSFrente() {
		// scroll(0.8, 0.5);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void pegarArquivoCTPSDados() {
		// scroll(0.8, 0.5);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void clicarAlterar() {

		clicar(By.xpath("(//android.widget.ImageView)[7]"));

	}

	public void preencherCep(String CEP) {
		escrever(By.xpath("//*[@text='Digite aqui']"), CEP);

	}

	public void enderecoVisivel() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("BELO HORIZONTE,")));

	}

	public void preencherComplemento(String complemento) {

		clicar(By.xpath("//*[@text='Apto, bloco, sala etc.']"));
		escrever(By.xpath("//*[@text='Apto, bloco, sala etc.']"), complemento);

	}

	public void preencherNumeroEndereco(String numeroEndereco) {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Digite aqui']")));

		clicar(By.xpath("//*[@text='Digite aqui']"));
		escrever(By.xpath("//*[@text='Digite aqui']"), numeroEndereco);

	}

	public void anexarComprovanteResidencia() {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void anexarFoto() {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void botaoSelecionar() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("SELECIONAR")));
		clicar(MobileBy.AccessibilityId("SELECIONAR"));

	}

	public void selecionarEstadoCivil(String estadoCivil) throws InterruptedException {

		Thread.sleep(8000);
		botaoSelecionar();
		clicar(MobileBy.AccessibilityId(estadoCivil));
		// Thread.sleep(1000);
		botaoAvancarTela();

	}

	public void anexarCertidaoCasamento() {
		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void botaoPreencherPis(String pis) throws InterruptedException {

		clicar(MobileBy.AccessibilityId("PREENCHER PIS"));
		escrever(By.xpath("//*[@text='Digite aqui o número']"), pis);
		Thread.sleep(4000);
		botaoCheckFinalizar();

	}

	public void preeencherTituloEleitor(String numeroTitulo) throws InterruptedException {

		scroll(0.8, 0.1);
		botaoEnviar();
		escrever(By.xpath("//*[@text='Digite aqui']"), numeroTitulo);
		Thread.sleep(2000);
		botaoCheckFinalizar();

	}

	public void preeencherDataEmissaoTituloEleitor(String dataTitulo) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataTitulo);
		botaoSetaBaixo();

	}

	public void preeencherUFTituloEleitor(String tituloUF) {
		escrever(By.xpath("//*[@text='Digite aqui']"), tituloUF);
		botaoSetaBaixo();

	}

	public void preeencherZonaVotacao(String zonaVotacao) {

		escrever(By.xpath("//*[@text='Digite aqui']"), zonaVotacao);
		botaoSetaBaixo();

	}

	public void preeencherSecaoVotacao(String secao) {
		escrever(By.xpath("//*[@text='Digite aqui']"), secao);
		botaoSetaBaixo();
		botaoCheckFinalizar();

	}

	public void enviarTitulo() {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void comprovanteVotacao() throws InterruptedException {
		Thread.sleep(9000);
		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void botaoAvancarTela() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void anexarCertificadoReservista() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Certificado de reservista")));

		Thread.sleep(6000);

		botaoAnexarArquivo();
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();
	}

	public void informarDiplomaEscolaridade() throws InterruptedException {

		Thread.sleep(2000);
		clicar(MobileBy.AccessibilityId("ENVIAR"));

	}

	public void selecionarGrauInstrucao(String grauInstrucao) {
		clicar(MobileBy.AccessibilityId(grauInstrucao));
		botaoAvancarTela();

	}

	public void anexarDiplomaEscolaridade() throws InterruptedException {

		botaoAnexarArquivo();
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void anexarComprovanteConta() {

		botaoAnexarArquivo();
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();
	}

	public void informarDependentes(String dependentes) throws InterruptedException {
		Thread.sleep(6000);
		scroll(0.8, 0.1);
		clicar(MobileBy.AccessibilityId(dependentes));

	}

	public void adicionarConta() {
		clicar(MobileBy.AccessibilityId("ADICIONAR CONTA"));

	}

	public void informarDadosConta(String banco, String agencia, String contaNumero) {

		escrever(By.xpath("//*[@text='Digite aqui seu banco']"), banco);
		botaoSetaBaixo();

		escrever(By.xpath("//*[@text='Digite aqui sua agência']"), agencia);
		botaoSetaBaixo();

		escrever(By.xpath("//*[@text='Qual é a sua conta?']"), contaNumero);
		botaoCheckFinalizar();

	}

	public void verificarEtapa() throws InterruptedException {
		// verificar a tela final
		Thread.sleep(2000);
		// aqui posso tenta colocar o explicito
		scroll(0.6, 0.2);
		scroll(0.9, 0.1);
		Thread.sleep(5000);
		scroll(0.9, 0.1);
		scroll(0.9, 0.1);
		scroll(0.9, 0.1);
		scroll(0.9, 0.1);

	}

	public void aceitarTermo() {

		// clicarTap(132, 1271);
		// clicarCheck(MobileBy.AccessibilityId("Li e aceito os termos de envio
		// das informações presentes"));

		// WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
		// 15);
		// wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("CONCLUIR
		// ENVIO")));
		//
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void concluirEnvio() {

		clicar(MobileBy.AccessibilityId("CONCLUIR ENVIO"));
	}

	public String mensagm() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Li e aceito os termos de envio das informações presentes"));

	}

	public void botaoIrHomePage() {
		clicar(MobileBy.AccessibilityId("IR PARA HOME"));

	}

	public String verificaMensagemDocumentosEnviados() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Documentos enviados"));

	}

}
