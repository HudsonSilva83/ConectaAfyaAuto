package br.com.conecta.afya.page;

import java.util.ArrayList;

import org.openqa.selenium.By;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class CadastroPage extends BasePage {

	public void clicarForaCaixa() {

		clicarTap(177, 398);

	}

	public void clicarJaTenhoUmaConta() {

		clicar(MobileBy.AccessibilityId("Já tenho uma conta"));
	}



	public void botaoAvancarCPF() {

		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarSenha() {

		clicar(By.xpath("(//android.widget.FrameLayout//android.widget.Button)[2]"));

	}

	public void Atualizar() {

		clicar(MobileBy.AccessibilityId("Atualizar"));

	}

	public void preencherSenha(String senha) {

		escrever(By.xpath("//*[@text='Senha']"), senha);

	}

	public void tap() {

		clicarTap(500, 944);

	}

	public String obterTextoCadastro() {

		return atributoClass(MobileBy.AccessibilityId("Seu processo de admissão"), "content-desc");

	}

	public boolean verificarTextoPreCadastro(String texto) {

		
		
		
		return existeElementoPorAtributo(MobileBy.AccessibilityId(texto), "content-desc", texto);

	}

	public void alterarNome(String nome) throws InterruptedException {
		
		descerTela(); 
		clicar(By.xpath("(//android.widget.ImageView)[1]"));
		limpar(By.xpath("//*[@text='Nome Teste']"));
		//limpar(By.xpath("//*[@text='HudsonSilva']"));
			
		escrever(By.xpath("//*[@text='Digite aqui']"), nome);
		botaoConfirmar();

	}

	public void botaoConfirmar() {
		//descerTela(); 
		clicar(MobileBy.AccessibilityId("CONFIRMAR"));

	}
	


	public void alterarEmail(String email) throws InterruptedException {

		clicar(By.xpath("(//android.widget.ImageView)[2]"));
		//limpar(By.xpath("//*[@text='hu.psilva@gmail.com']"));
		escrever(By.xpath("//*[@text='Digite aqui']"), email);
		Thread.sleep(1000);
		botaoConfirmar();

	}
	
	public void alterarTelefone(String telefone) throws InterruptedException {
		
		
		clicar(By.xpath("(//android.widget.ImageView)[4]"));
		//limpar(By.xpath("//*[@text='(03) 19941-4365']"));
		escrever(By.xpath("//*[@text='Digite aqui']"), telefone);
		botaoConfirmar();
		scroll(0.6, 0.1);

	}

	public void descerTela() {

		scroll(0.9, 0.2);

	}

	public void aceitarTermosCondicoes() {
		clicar(By.xpath("//android.widget.CheckBox"));
		
		
	}

	public boolean verificarCampoPreenchido(String texto) {

		return existeElementoPorAtributo(MobileBy.AccessibilityId(texto), "content-desc", texto);

	}

	public void assinar() {
	clicar(By.xpath("(//android.widget.ScrollView)[1]"));
		
	}
	
	
	public void botaoAvancarAssinatura() {
		
		descerTela();
		clicar(By.xpath("(//android.widget.Button)[3]"));
		
	}
	
	

}
