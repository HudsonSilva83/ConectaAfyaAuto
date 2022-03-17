package br.com.conecta.afya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class HomePage extends BasePage {

	public void clicarCampoCodigoAcesso() {

		clicar(MobileBy.AccessibilityId("Digite o c�digo de acesso"));

	}

	public void preencherCodigoAcesso(String codigoAcesso) {
		clicarCampoCodigoAcesso();
		escrever(By.xpath("//*[@text='C�digo']"), codigoAcesso);

	}

	public void avancarButton() {

		clicar(By.xpath("(//android.view.View//android.widget.Button)[2]"));

	}

	public void clicarJaTenhoUmaConta() {

		clicar(MobileBy.AccessibilityId("J� tenho uma conta"));
		avancarButton();
	}

	public String verificarCadastroSucesso() {
		
//		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
//				 15);
//				 wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(("Cadastro Conta criada com sucesso :) Envio de documentos Realizado com sucesso :) Escolha de benef�cios Aqui voc� vai poder escolher e editar os seus benef�cios Exame Admissional Fique tranquilo, nossa equipe vai agendar seu exame admissional. Documento Admissional Aqui voc� vai poder ver, editar e assinar sua ficha de cadastro"))));
		
		
		return obterTextoAtributo(MobileBy.AccessibilityId("Seu processo de admiss�o"));
	}

	public String verificarEnvioDocumentoSucesso() {
		return obterTextoAtributo(MobileBy.AccessibilityId(""));
		
		
		
	}

}
