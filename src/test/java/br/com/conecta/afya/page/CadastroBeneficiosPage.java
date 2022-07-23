package br.com.conecta.afya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class CadastroBeneficiosPage extends BasePage {

	public void scrollar(double inicio, double fim) {

		scroll(inicio, fim);

	}

	public String verificarInicioBeneficioTela() {

		return obterTextoAtributo(MobileBy.AccessibilityId("COMEÇAR"));

	}

	public void clicarBotaoComecar() {
		clicar(MobileBy.AccessibilityId("COMEÇAR"));

	}

	public String verificaroBeneficioDisponiveisTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Estes são os seus benefícios. Nos próximos passos, iremos customizar cada um deles."));

	}

	public String verificaroValeTransporteTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Vale transporte"));

	}

	public void selecionarOpcaoValeTransporte(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void botaoAvancarValeTransporte() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[3]"));

	}

	public String verificarOpcaoOnibusTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Ônibus"));

	}

	public String verificarOpcaoMetroTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Metrô"));

	}

	public String verificarOpcaoTremTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Trem"));

	}

	public String verificarOpcaoAdicionarOnibus() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[15]"));

	}

	public String verificarOpcaoAdicionarMetro() {
		return obterTextoAtributo((By.xpath("(//android.view.View)[19]")));

	}

	public String verificarOpcaoAdicionarTrem() {
		return obterTextoAtributo((By.xpath("(//android.view.View)[23]")));

	}

	public void selecionarQuantidadeOnibusIda(String quantidadeIda) {

		switch (quantidadeIda) {
		case "1":

			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		case "2":

			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		case "3":

			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		case "4":

			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		}

	}

	public void selecionarQuantidadeMetro(String quantidadeIda) {

		clicar(By.xpath("(//android.view.View)[19]"));

	}

	public void botaoAvancarValeOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[3]"));

	}

	public String verificarTelaInformacoesOnibus() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Informe a linha ou nome da empresa de transporte."));

	}

	public void preencgerCampoLinhaEmpresa(String linha) {
		clicar(By.xpath("//*[@text='Nome da linha ou empresa']"));
		escrever(By.xpath("//*[@text='Nome da linha ou empresa']"), linha);

	}

	public void preencgerCampoPrecoPassagem(String tarifaPassagem) {
		clicar(By.xpath("//*[@text='Informe o preço da passagem']"));
		escrever(By.xpath("//*[@text='Informe o preço da passagem']"), tarifaPassagem);

	}

	public void botaoAvancarPrimeiroOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarSegundoOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarTerceiroOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarQuartoOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarVale() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void preencgerCampoMetro(String linha) {
		clicar(By.xpath("//*[@text='Nome da linha ou empresa']"));
		escrever(By.xpath("//*[@text='Nome da linha ou empresa']"), linha);

	}

	public void preencgerCampoTrem(String linha) {
		clicar(By.xpath("//*[@text='Nome da linha ou empresa']"));
		escrever(By.xpath("//*[@text='Nome da linha ou empresa']"), linha);

	}

	public void preencgerCampoPrecoPassagemMetro(String tarifaPassagem) {
		clicar(By.xpath("//*[@text='Informe o preço da passagem']"));
		escrever(By.xpath("//*[@text='Informe o preço da passagem']"), tarifaPassagem);

	}

	public void preencgerCampoPrecoPassagemTrem(String tarifaPassagem) {
		clicar(By.xpath("//*[@text='Informe o preço da passagem']"));
		escrever(By.xpath("//*[@text='Informe o preço da passagem']"), tarifaPassagem);

	}

	public String verificarTrajetoIdaVoltaTela() {
		return obterTextoAtributo(
				MobileBy.AccessibilityId("Informe se o trajeto é o mesmo de ida e volta do trabalho"));

	}

	public void selecionarIdaVolta(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

		// implementar caso for não

	}

	public void botaoAvancarIdaVolta() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[3]"));

	}

	public String verificarConfirmarPedidoTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Confirme seu pedido do vale transporte"));
	}

	public String valorTrajetoIdaTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[14]"));

	}

	public String valorTrajetoVoltaTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[17]"));
	}

	public String valorTotalDiarioTela() {

		return obterTextoAtributo(By.xpath("(//android.view.View)[19]"));

	}

	public String valorDescontoTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[21]"));
	}

	public void clicarAbrirInfoDesconto() {
		clicar(By.xpath("(//android.widget.ImageView)[1]"));

	}

	// __________________________________________

	public String valorTrajetoIdaTelaOnibusMetro() {

		String valorIdaBus = obterTextoAtributo(By.xpath("(//android.view.View)[12]"));
		return valorIdaBus.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaOnibusTrem() {

		String valorIdaBus = obterTextoAtributo(By.xpath("(//android.view.View)[12]"));
		return valorIdaBus.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaOnibusMetroETrem() {

		String valorIdaBus = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		return valorIdaBus.replace("R$ ", "");

	}

	public String valorTrajetoVoltaOnibusMetroTela() {

		String valorVoltaBus = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valorVoltaBus.replace("R$ ", "");
	}

	public String valorTrajetoVoltaOnibusTremTela() {

		String valorVoltaBus = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valorVoltaBus.replace("R$ ", "");
	}

	public String valorTrajetoVoltaOnibusMetroTelaETrem() {

		String valorVoltaBus = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valorVoltaBus.replace("R$ ", "");
	}

	public String valorTotalDiarioTelaOnibusEMetro() {

		String valorTotalDiario = obterTextoAtributo(By.xpath("(//android.view.View)[21]"));

		return valorTotalDiario.replace("R$ ", "");

	}

	public String valorTotalDiarioTelaOnibusTrem() {

		String valorTotalDiario = obterTextoAtributo(By.xpath("(//android.view.View)[21]"));

		return valorTotalDiario.replace("R$ ", "");

	}

	public String valorTrajetoVoltaTremOnibusTela() {

		String valorTotalDiario = obterTextoAtributo(By.xpath("(//android.view.View)[19]"));

		return valorTotalDiario.replace("R$ ", "");

	}

	public String valorTotalDiarioTelaMetroETrem() {

		String valorTotalDiario = obterTextoAtributo(By.xpath("(//android.view.View)[23]"));

		return valorTotalDiario.replace("R$ ", "");

	}

	public String valorDescontoTelaOnibusEMetro() {

		String valorDesconto = obterTextoAtributo(By.xpath("(//android.view.View)[23]"));
		return valorDesconto.replace("R$ ", "");
	}

	public String valorDescontoTelaOnibusETrem() {

		String valorDesconto = obterTextoAtributo(By.xpath("(//android.view.View)[23]"));
		return valorDesconto.replace("R$ ", "");
	}

	public String valorDescontoTelaMetroETrem() {

		String valorDesconto = obterTextoAtributo(By.xpath("(//android.view.View)[25]"));
		return valorDesconto.replace("R$ ", "");
	}

	public String valorTrajetoIdaTelaMetro() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaTremOnibus() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaTremMetro() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[16]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoVoltaTelaMetroTrem() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[19]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaMetroTrem() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaMetroETrem() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[12]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoIdaTelaTrem() {

		String valorMetro = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
		return valorMetro.replace("R$ ", "");

	}

	public String valorTrajetoVoltaTelaMetro() {

		String valorVoltaMetro = obterTextoAtributo(By.xpath("(//android.view.View)[19]"));
		return valorVoltaMetro.replace("R$ ", "");
	}

	public String valorTrajetoVoltaTelaTremOnibus() {

		String valorVoltaMetro = obterTextoAtributo(By.xpath("(//android.view.View)[19]"));
		return valorVoltaMetro.replace("R$ ", "");
	}

	public String valorTrajetoVoltaTelaTremMetro() {

		String valorVoltaMetro = obterTextoAtributo(By.xpath("(//android.view.View)[21]"));
		return valorVoltaMetro.replace("R$ ", "");
	}

	public String valorTrajetoVoltaTelaMetroETrem() {

		String valorVoltaMetro = obterTextoAtributo(By.xpath("(//android.view.View)[19]"));
		return valorVoltaMetro.replace("R$ ", "");
	}

	public String valorTrajetoVoltaTelaTrem() {

		String valorVoltaMetro = obterTextoAtributo(By.xpath("(//android.view.View)[21]"));
		return valorVoltaMetro.replace("R$ ", "");
	}

	public String valorTotalDiarioTelaOnibusMetroETrem() {

		String valorTotalDiario = obterTextoAtributo(By.xpath("(//android.view.View)[23]"));

		return valorTotalDiario.replace("R$ ", "");

	}

	public String valorDescontoTelaOnibusMetroETrem() {

		String valorDesconto = obterTextoAtributo(By.xpath("(//android.view.View)[25]"));
		return valorDesconto.replace("R$ ", "");
	}

	public void clicarFecharInfoDesconto() {

		// clicar(By.xpath("(//android.widget.Button)[1]"));

		tapNormal(53, 53);

	}

	public String verificarTextoInfoDesconto() {
		return obterTextoAtributo(By.xpath("(//android.widget.Button)[1]"));

	}

	public void botaoAvancarTelaConfirmacao() {

		clicar(By.xpath("(//android.widget.LinearLayout//android.view.View//android.widget.Button)[2]"));

	}

	public String verificarAceiteTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Termo de aceite do vale transporte"));
	}

	public void aceitarTermoVale() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void aceitarTermoBeleficioTicket() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void botaoFinalizar() {

		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public String verificaConclusaoValeTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Vale transporte concluído!"));
	}

	public String verificaPlanoOdontologico() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Plano odontológico"));
	}

	public String verificarTelaOpcaoSalva() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Sua escolha foi salva!"));
	}

	public String verificarTelaPlanoOndologico() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Plano odontológico"));
	}

	public void botaoAvancar() {
		clicar(MobileBy.AccessibilityId("AVANÇAR"));

	}

	public void botaoQueroPlanoOndotologico() {
		clicar(MobileBy.AccessibilityId("ESCOLHER UM PLANO"));

	}

	public void botaoNaoQueroPlanoOndotologico() {
		clicar(MobileBy.AccessibilityId("Não quero plano odontológico"));

	}

	public void botaoEscolherPlano() {
		clicar(MobileBy.AccessibilityId("ESCOLHER UM PLANO"));

	}

	public void lado(double inicio, double fim) {
		swipe(inicio, fim);

	}

	public void lado() {
		swipe(0.4, 0.1);

	}

	public void lado2() {
		swipe(0.5, 0.1);

	}

	public String verificaPlanoOdontologicoEssencialPlus() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Essencial Plus"));
	}

	public String verificaPlanoOdontologicoEssencialTop() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Essencial Top"));
	}

	public String verificaPlanoOdontologicoPremium() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Premium Top"));
	}

	public void paraLadoEsquerdo() {
		swipe(0.1, 0.9);
		swipe(0.1, 0.2);

	}

	public void paraLadoDireito() {
		swipe(0.4, 0.1);
		// swipe(0.1, 0.2);

	}

	public void paraLadoDireitoFinal() {
		swipe(0.4, 0.1);
		swipe(0.9, 0.1);

	}

	public void cliarEssencialPlus() {
		// TODO Auto-generated method stub

	}

	public void clicarNoPlano(String opcao) {

		switch (opcao) {

		case "Essencial Plus":

			scroll(0.7, 0.1);
			// paraLadoEsquerdo();
			tapNormal(113, 714);

			break;

		case "Essencial Top":

			scroll(0.7, 0.1);
			paraLadoDireito();
			tapNormal(596, 705);

			break;

		case "Premium Top":

			scroll(0.7, 0.1);
			paraLadoDireitoFinal();
			tapNormal(490, 704);

			break;

		}

	}

	public void botaoContinuar() {

		clicar(MobileBy.AccessibilityId("CONTINUAR"));
	}

	public String verificarTelaIncluirDependentes() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Dependentes"));
	}

	public String verificarTelaCertidaoNascimento() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Certidão de nascimento"));
	}

	public String verificarTelaComprovanteMatricula() {
		return obterTextoAtributo(
				MobileBy.AccessibilityId("Comprovante de matrícula em Instituição de Ensino Superior"));
	}

	public String verificarTelaCarteitinhaVacinacao() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Carteirinha de vacinação"));
	}

	public void botaoIncluirDependentes() {
		// clicar(MobileBy.AccessibilityId("Adicionar filho e/oudependente"));
		tapNormal(90, 647);

	}

	public void selecionarDependente(String opcao) {

		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void botaoSetaPraBaixo() {

		clicar(By.xpath("(//android.widget.Button)[2]"));
	}

	public void selecionarIdade(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void preencherNome(String nome) {
		escrever(By.xpath("//*[@text='Digite aqui']"), nome);

	}

	public void preencherDataNascimento(String data) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), data);

	}

	public void preencherCPF(String CPF) {
		clicar(By.xpath("//android.widget.EditText"));
		escrever(By.xpath("//android.widget.EditText"), CPF);

	}

	public void selecionarDependenteCheck() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void botaoSetaAvancarSaude() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoSetaAvancar() {
		clicar(By.xpath("(//android.widget.Button)[5]"));

	}

	public void anexarArquivo() {
		clicar(MobileBy.AccessibilityId("Anexar arquivo"));

	}

	public void selecionarArquivo() throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='arquivoJPG.jpg']")));
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void botaoFinalizarDependente() {
		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void botaoEnviarArquivo() {
		clicar(MobileBy.AccessibilityId("ENVIAR ARQUIVO"));

	}

	public void checkSelecionarDependente() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public String telaPlanoConfirmacao(String plano) {
		return obterTextoAtributo(MobileBy.AccessibilityId(plano));

	}

	public String telaTermoOndotologico() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Termos de escolha do plano odontológico"));
	}

	public void botaoFinalizarTermo() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void checkSelecionarTermo() {
		clicarCheck(By.xpath("//android.widget.CheckBox"));

	}

	public String telaPlanoOndotologicoConcluido() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Plano odontológico concluído!"));
	}

	public String telaPlanoTickets() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Ticket restaurante e alimentação"));
	}

	public void botaoAvancarDependente() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoAvancarDependenteSaude() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoAvancarConfirmacao() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoCustomizarBeneficios() {
		clicar(MobileBy.AccessibilityId("CUSTOMIZAR BENEFÍCIO"));

	}

	public String TicketAlimentacao() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Valor integral como Ticket Alimentação"));

	}

	public String TicketRestaurante() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Valor integral como Ticket Restaurante"));

	}

	public void selecaoBeneficioTicket(String opcaoTicket) {

		switch (opcaoTicket) {

		case "Alimentação":

			clicar(MobileBy.AccessibilityId("Valor integral como Ticket Alimentação"));
			// clicar(By.xpath("(//android.widget.Button)[2]"));

			break;

		case "Restaurante":

			clicar(MobileBy.AccessibilityId("Valor integral como Ticket Restaurante"));
			// clicar(By.xpath("(//android.widget.Button)[2]"));

			break;

		}

	}

	public String telaConfirmacaoTicket() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Confirme sua escolha"));

	}

	public String opcaoConfirmacaoTicket(String opcaoTicket) {

		String valor = "nada";

		switch (opcaoTicket) {

		case "Ticket Alimentação":

			valor = obterTextoAtributo(MobileBy.AccessibilityId("Ticket Alimentação"));

			break;

		case "Ticket Restaurante":

			valor = obterTextoAtributo(MobileBy.AccessibilityId("Ticket Restaurante"));

			break;

		}

		return valor;

	}

	public String termoEscolhaTicket() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Termos de escolha do benefício"));
	}

	public String verificarTelasTicketSalvo() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Sua escolha foi salva!"));

	}

	public void botaoAvancarBeneficioTicket() {

		clicar(By.xpath("(//android.widget.Button)[3]"));
	}

	public void botaoAvancarTelaSalva() {
		clicar(MobileBy.AccessibilityId("AVANÇAR"));

	}

	public String telaGympass() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Gympass"));
	}

	public String obterTextoGympassCarrossel01() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[1]"));

	}

	public String obterTextoGympassCarrossel02() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[2]"));

	}

	public String obterTextoGympassCarrossel03() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[3]"));

	}

	public String obterTextoGympassCarrossel04() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[2]"));

	}

	public String obterTextoGympassCarrossel05() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[2]"));
	}

	public String obterTextoGympassPasso1() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[3]"));
	}

	public String obterTextoGympassPasso2() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[4]"));
	}

	public String obterTextoGympassPasso3() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[5]"));
	}

	public String obterTextoGympassPasso4() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[6]"));
	}

	public String obterTextoGympassPasso5() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[7]"));
	}

	public String obterTextoGympassPasso6() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[8]"));
	}

	public String textoSalvo() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[7]"));
	}

	public String obterTextoDeenvioEmail() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[8]"));
	}

	public String tituloDoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[2]"));
	}

	public String texto01DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[3]"));
	}

	public String texto02DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[4]"));
	}

	public String texto03DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[5]"));
	}

	public String texto04DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[6]"));
	}

	public String texto05DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[7]"));
	}

	public void clicarBotaoAdicionarDependentes() {
		clicar(MobileBy.AccessibilityId("ADICIONAR DEPENDENTES"));

	}

	public String textoSaudeDoCarrossel01() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[1]"));
	}

	public String textoSaudeDoCarrossel02() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[2]"));
	}

	public String textoSaudeDoCarrossel03() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[3]"));
	}

	public String textoSaudeDoCarrossel04() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[2]"));
	}

	public String tituloPlanoSelecionadoSaude1() {
		return obterTextoAtributo(
				MobileBy.AccessibilityId("Haverá um desconto integral na folha de pagamento mensal."));
	}

	public String tituloPlanoSelecionadoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[8]"));
	}

	public String textoPlanoSelecionadoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[9]"));
	}

	public String textoTipoPlanoSelecionadoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[10]"));
	}

	public String nomeCadastradoNoPlano() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[12]"));
	}

	public String valorDescontoMensalPlanoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[13]"));
	}

	public String verificarEtapasConcluidas() {
		String etapasConcluidas = obterTextoAtributo(By.xpath("(//android.view.View/android.widget.ImageView)[2]"));
		return etapasConcluidas.replaceAll("\\n", " ");

	}

	public String verificarTextoTermoSaude() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Termos de escolha do benefício"));

	}

	public void clicarTermoSaude() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void clicarBotaoAceitar() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public String verificarTelaConcluidoPlanoSaude() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Plano de saúde concluído!"));
	}

	public String descricaoTextoFlash01() {

		return obterTextoAtributo(By.xpath("(//android.view.View)[10]"));

	}

	public String descricaoTextoFlash02() {

		return obterTextoAtributo(By.xpath("(//android.view.View)[12]"));
	}

	public String descricaoTextoFlash03() {

		String carrosel01 = obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[1]"));

		return carrosel01.replaceAll("\\n", " ");
	}

	public String descricaoTextoFlash04() {

		String carrosel02 = obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[1]"));

		return carrosel02.replaceAll("\\n", " ");
	}

	public String descricaoTextoFlash05() {

		String texto = obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[5]"));
		return texto.replaceAll("\\n", " ");
	}

	public String descricaoTextoFlash06() {

		String texto = obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[7]"));
		return texto.replaceAll("\\n", " ");
	}

	public String descricaoTextoFlash07() {

		String texto = obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[9]"));
		return texto.replaceAll("\\n", " ");
	}

	public String textoConclusaoCadastroBeneficios() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[7]"));
	}

	public void botaoComoUtilizarCartao() {
		clicar(MobileBy.AccessibilityId("Como utilizar o cartão?"));

	}

	public String verificarTelaAnexarOutrosComprovante() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Outros"));
	}

	public void botaoAnexarArquivo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Anexar arquivo")));

		clicar(MobileBy.AccessibilityId("Anexar arquivo"));

	}

	public String verificarNomePlanoTela() {

		return obterTextoAtributo(By.xpath("(//android.view.View)[13]"));

	}

	public String verificarNomeCadastradoPlanoTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[18]"));
	}

	public String verificarValorCadastradoPlanoTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[19]"));
	}

	public String verificarValorDescontoPlanoTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[21]"));
	}

	public void selecionarQuantidaTrem(String quantidadeMetro) {
		clicar(By.xpath("(//android.view.View)[23]"));

	}

	public void botaoAvancarValeTeste() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoAvancarVale01() {
		clicar(By.xpath("//android.widget.Button"));

	}

	public void botaoAlterarValeIda0() {

		clicar(By.xpath("(//android.widget.ImageView)[2]"));

	}
	
	public void botaoAlterar() {

		clicar(By.xpath("(//android.widget.ImageView)[1]"));
		
	}
	
	public void botaoAlterarValeVolta() {

		clicar(By.xpath("(//android.widget.ImageView)[4]"));

	}


	public void botaoAlterarValeIda01() {

		clicar(By.xpath("(//android.widget.ImageView)[2]"));

	}

	public void botaoAlterarValeIda02() {

		clicar(By.xpath("(//android.widget.ImageView)[4]"));

	}

	public void botaoAlterarValeIda03() {

		clicar(By.xpath("(//android.widget.ImageView)[5]"));

	}

	public void botaoAlterarValeIda03_03_04onibus() {

		clicar(By.xpath("(//android.widget.ImageView)[3]"));

	}

	public void botaoAlterarValeIda03_04onibus() {

		clicar(By.xpath("(//android.widget.ImageView)[5]"));

	}

	public void preencherCampolinhaEmpresa(String nome) {

		clicar(By.xpath("(//android.widget.EditText)"));
		limpar(By.xpath("(//android.widget.EditText)"));
		escrever(By.xpath("(//android.widget.EditText)"), nome);

	}

	public void preencherCampoValorlinhaEmpresa(String valor) {
		clicar(By.xpath("(//android.widget.EditText)[2]"));
		limpar(By.xpath("(//android.widget.EditText)[2]"));
		escrever(By.xpath("(//android.widget.EditText)[2]"), valor);

	}

	public void botaoSalvar() {
		clicar(MobileBy.AccessibilityId("SALVAR"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[12]"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa_02_02() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[16]"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa_02_03() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[15]"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa_02_04() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[15]"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa_03_04() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[14]"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa_04() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[18]"));

	}

	public String verificarAlteracaoNomeLinha01EmpresacomTresOnibus() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[11]"));

	}

	public String verificarAlteracaoNomeLinha02EmpresacomTresOnibus() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[15]"));

	}

	public String verificarAlteracaoValorLinhaEmpresa() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinhaEmpresa_02_02() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[18]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinhaEmpresa_02_03() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinhaEmpresa_02_04() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinhaEmpresa_03_04() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[16]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinhaEmpresa_04() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[20]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinha01EmpresaComTresOnibus() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[13]"));

		return valor.replace("R$ ", "");
	}

	public String verificarAlteracaoValorLinha02EmpresaComTresOnibus() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valor.replace("R$ ", "");
	}

	public void botaoVoltar() {
		clicar(By.xpath("//android.widget.Button"));

	}

	public void botaSalvarAlteracoes() {
		clicar(MobileBy.AccessibilityId("SALVAR ALTERAÇÕES"));

	}

	public String veriricarAlteracaoNomeLinhaEmpresa_03_03() {

		return obterTextoAtributo(By.xpath("(//android.view.View)[18]"));

	}

	public String verificarAlteracaoValorLinhaEmpresa_03_03() {

		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[20]"));

		return valor.replace("R$ ", "");

	}

	public String verificarValorTrajetoIdaTotal() {
		
		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));

		return valor.replace("R$ ", "");

		
	}
	
	
	
	public String verificarValorTrajetoVoltaTotal() {
		
		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));

		return valor.replace("R$ ", "");

		
	}

	public String verificarValorTrajetoDiarioTotal() {
		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[19]"));

		return valor.replace("R$ ", "");

	}
	
	
	public String verificarValorTrajetoDesconto() {
		String valor = obterTextoAtributo(By.xpath("(//android.view.View)[21]"));

		return valor.replace("R$ ", "");

	}

	public void pularEnvioDoc() {
		clicar(MobileBy.AccessibilityId("Enviar esse documento depois"));
		
	}

	public void alterarNomeDependente(String nome) {
		
		clicar(By.xpath("(//android.widget.EditText)[1]"));
		limpar(By.xpath("(//android.widget.EditText)[1]"));
		escrever(By.xpath("(//android.widget.EditText)[1]"), nome);
		
	}
	
	public void alterarDataNascimentoDependente(String data) {
		
		clicar(By.xpath("(//android.widget.EditText)[2]"));
		limpar(By.xpath("(//android.widget.EditText)[2]"));
		escrever(By.xpath("(//android.widget.EditText)[2]"), data);
		
	}
	
	public void alterarCPFDependente(String cpf) {
		
		clicar(By.xpath("(//android.widget.EditText)[3]"));
		limpar(By.xpath("(//android.widget.EditText)[3]"));
		escrever(By.xpath("(//android.widget.EditText)[3]"), cpf);
		
	}

	public String obterMensagemAlertaTeste(String mensagem) {
		
		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarNomeDependenteAlterado() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[13]"));
	
			
	}


	
	public String verificarDataDependenteAlterado() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
	}
	
	


	public String verificarGrauParentescoDependenteAlterado() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[17]"));
	}




}
