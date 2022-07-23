package br.com.conecta.afya.page;

import org.openqa.selenium.By;

import br.com.conecta.afya.core.BasePage;
import io.appium.java_client.MobileBy;

public class ValidarDocumentosAdmissionaisPage extends BasePage {

	public void scrollar(double inicio, double fim) {

		scroll(inicio, fim);

	}

	public void botaoComecar() {
		clicar(MobileBy.AccessibilityId("COMEÇAR"));

	}

	public String dadosRG() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[10]"));

	}

	public String dadosRGValorIdentidade() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String iden2 = iden.replaceAll("\\n", " ");// .substring(15, 24);
		return iden2;// .trim();

	}

	public String dadosRGNascimento() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String nasc2 = nasc.replaceAll("\\n", " ").substring(36, 47);
		return nasc2.trim();

	}

	public String dadosRGEstadoCivil() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String nasc2 = nasc.replaceAll("\\n", " ").substring(61, 73);
		return nasc2.trim();

	}

	public String dadosRGSexo() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String nasc2 = nasc.replaceAll("\\n", " ").substring(79, 90);
		return nasc2.trim();

	}

	public String dadosRGNacionalidade() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String nasc2 = nasc.replaceAll("\\n", " ").substring(106, 116);
		return nasc2.trim();

	}

	public String dadosRGEstadonatal() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String nasc2 = nasc.replaceAll("\\n", " ").substring(131, 143);
		return nasc2.trim();

	}

	public String dadosRGCidadenatal() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String nasc2 = nasc.replaceAll("\\n", " ").substring(158, 172);
		return nasc2.trim();

	}

	public String dadosCarteiraTrabalhoNumero() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(29, 36);
		return iden2.trim();

	}

	public String dadosCarteiraTrabalhoSerie() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(44, 46);
		return iden2.trim();

	}

	public String dadosCarteiraTrabalhoEmissao() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(56, 66);
		return iden2.trim();

	}

	public String dadosCarteiraTrabalhoPISPASEP() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(78, 89);
		return iden2.trim();

	}

	public String dadosCarteiraTrabalhoRegistro() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(112, 114);
		return iden2;// .trim();

	}

	public String dadosTituloEleitorNumero() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(26, 38);
		return iden2.trim();

	}

	public String dadosTituloEleitorEmissao() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(48, 58);
		return iden2.trim();

	}

	public String dadosTituloEleitorUF() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(63, 65);
		return iden2.trim();

	}

	public String dadosTituloEleitorZona() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = iden.replaceAll("\\n", " ").substring(72, 74);
		return iden2.trim();

	}

	public String dadosTituloEleitorSecao() {

		String nasc = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String iden2 = nasc.replaceAll("\\n", " ");// .substring(82, 84);
		return iden2;// .trim();

	}

	public String dadosPessoaisGrauInstituicao() {

		String iden = obterTextoAtributo(By.xpath("(//android.widget.ImageView)[1]"));
		// vou ter que criar uma condição para cada grau
		String iden2 = iden.replaceAll("\\n", " ");// .substring(28,57);

		return iden2;// .trim();

	}

	public String dadosEnderecoRua() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String iden2 = iden.replaceAll("\\n", " ");// .substring(14, 29);

		return iden2;// .trim();

	}

	public String dadosEnderecoComplemento() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String iden2 = iden.replaceAll("\\n", " ");// .substring(43, 47);
		return iden2;// .trim();

	}

	public String dadosEnderecoNumero() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String iden2 = iden.replaceAll("\\n", " ");// .substring(56, 59);
		return iden2;// .trim();

	}

	public String dadosEnderecoBairro() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String iden2 = iden.replaceAll("\\n", " ");// .substring(68, 77);
		return iden2;// .trim();

	}

	public String dadosEnderecoCidade() {

		String iden = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String iden2 = iden.replaceAll("\\n", " ");// .substring(86, 100);
		return iden2;// .trim();

	}

	public void ladoDireito(double inicio, double fim) {

		swipe(inicio, fim);

	}

	public String dadosCargoCargo() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[10]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoArea() {

		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();

	}

	public String dadosCargoAdmissao() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[12]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoFormaPag() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[13]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoSalario() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoSalHora() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[15]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoJornada() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[16]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoOpcao() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[17]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosCargoHorario() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[18]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosEmpresaEmpresa() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[11]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosEmpresaEndereço() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[12]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosEmpresaCEP() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[13]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosEmpresaEmissão() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[14]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

	public String dadosEmpresaCNPJ() {
		String cargo = obterTextoAtributo(By.xpath("(//android.view.View)[15]"));
		String cargo2 = cargo.replaceAll("\\n", " ");// .substring(112, 114);
		return cargo2;// .trim();
	}

}
