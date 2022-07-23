package br.com.conecta.afya.domain;

import com.sun.xml.internal.ws.util.StringUtils;

public class DadosPessoais {

	String rgIdentidade;
	String rgDataNascimento;
	String rgEstadoCivil;
	String rgsexo;
	String rgNacionalidade;
	String rgEstadoNatal;
	String rgCidadeNatal;

	String cartTrabNumero;
	String cartTrabSerie;
	String cartTrabEmissao;
	String cartTraPis;
	String cartTrabRegisProf;

	String tituEleNumero;
	String tituEleEmissao;
	String tituEleUF;
	String tituEleZona;
	String tituEleSecao;

	public String getRgIdentidade() {
		return rgIdentidade;
	}

	public void setRgIdentidade(String rgIdentidade) {
		this.rgIdentidade = rgIdentidade;
	}

	public String getRgDataNascimento() {
		return rgDataNascimento;
	}

	public void setRgDataNascimento(String rgDataNascimento) {
		this.rgDataNascimento = rgDataNascimento;
	}

	public String getRgEstadoCivil() {
		return rgEstadoCivil;
	}

	public void setRgEstadoCivil(String rgEstadoCivil) {
		this.rgEstadoCivil = rgEstadoCivil;
	}

	public String getRgsexo() {
		return rgsexo;
	}

	public void setRgsexo(String rgsexo) {
		this.rgsexo = rgsexo;
	}

	public String getRgNacionalidade() {
		return rgNacionalidade;
	}

	public void setRgNacionalidade(String rgNacionalidade) {
		this.rgNacionalidade = rgNacionalidade;
	}

	public String getRgEstadoNatal() {
		return rgEstadoNatal;
	}

	public void setRgEstadoNatal(String rgEstadoNatal) {
		this.rgEstadoNatal = rgEstadoNatal;
	}

	public String getRgCidadeNatal() {
		return rgCidadeNatal;
	}

	public void setRgCidadeNatal(String rgCidadeNatal) {
		this.rgCidadeNatal = rgCidadeNatal;
	}

	public String getCartTrabnumero() {
		return cartTrabNumero;
	}

	public void setCartTrabnumero(String cartTrabnumero) {
		this.cartTrabNumero = cartTrabnumero;
	}

	public String getCartTrabserie() {
		return cartTrabSerie;
	}

	public void setCartTrabserie(String cartTrabserie) {
		this.cartTrabSerie = cartTrabserie;
	}

	public String getCartTrabemissao() {
		return cartTrabEmissao;
	}

	public void setCartTrabemissao(String cartTrabemissao) {
		this.cartTrabEmissao = cartTrabemissao;
	}

	public String getCartTraPis() {
		return cartTraPis;
	}

	public void setCartTraPis(String cartTraPis) {
		this.cartTraPis = cartTraPis;
	}

	public String getCartTrabRegisProf() {
		return cartTrabRegisProf;
	}

	public void setCartTrabRegisProf(String cartTrabRegisProf) {
		this.cartTrabRegisProf = cartTrabRegisProf;
	}

	public String getTituEleNumero() {
		return tituEleNumero;
	}

	public void setTituEleNumero(String tituEleNumero) {
		this.tituEleNumero = tituEleNumero;
	}

	public String getTituEleEmissao() {
		return tituEleEmissao;
	}

	public void setTituEleEmissao(String tituEleEmissao) {
		this.tituEleEmissao = tituEleEmissao;
	}

	public String getTituEleUF() {
		return tituEleUF;
	}

	public void setTituEleUF(String tituEleUF) {
		this.tituEleUF = tituEleUF;
	}

	public String getTituEleZona() {
		return tituEleZona;
	}

	public void setTituEleZona(String tituEleZona) {
		this.tituEleZona = tituEleZona;
	}

	public String getTituEleSecao() {
		return tituEleSecao;
	}

	public void setTituEleSecao(String tituEleSecao) {
		this.tituEleSecao = tituEleSecao;
	}

	public String getGrauInstituicaoEdu() {
		return grauInstituicaoEdu;
	}

	public void setGrauInstituicaoEdu(String grauInstituicaoEdu) {
		this.grauInstituicaoEdu = grauInstituicaoEdu;
	}

	String grauInstituicaoEdu;

	public String getIdentidade() {

		return rgIdentidade;

	}

	public String getDataNascimento() {

		return rgDataNascimento;

	}

	public void setdataNascimento(String dataNascimento) {

		this.rgDataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {

		return StringUtils.capitalize(rgEstadoCivil);
	}

	public void setEstadoCivil(String estadoCivil) {

		switch (estadoCivil) {

		case "SOLTEIRO":

			String charToAdd1 = "(a)";
			String minuscula = estadoCivil.toLowerCase();
			String a = minuscula + charToAdd1;
			this.rgEstadoCivil = StringUtils.capitalize(a);

			break;

		case "SOLTEIRA":

			System.out.println("DEU RUIM");
			this.rgEstadoCivil = "DEU RUIM";

			break;

		}

	}

	public String getSexo() {
		return rgsexo;
	}

	public void setSexo(String sexo) {
		this.rgsexo = sexo;
	}

	public String getNacionalidade() {
		return rgNacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		rgNacionalidade = nacionalidade;
	}

	public String getEstadoNatal() {
		return rgEstadoNatal;
	}

	public void setEstadoNatal(String estadoNatal) {
		rgEstadoNatal = estadoNatal;
	}

	public String getCidadeNatal() {
		return rgCidadeNatal;
	}

	public void setCidadeNatal(String cidadeNatal) {
		this.rgCidadeNatal = cidadeNatal;
	}

	public void setIdentidade(String identidade) {

		this.rgIdentidade = identidade;

	}

	// @Override
	public String lista_rg() {

		String listaRG = "DadosPessoais_RG{"

				+ "rgIdentidade=" + getIdentidade() + ",rgDataNascimento=" + getDataNascimento() + ",rgEstadoCivil="
				+ getEstadoCivil() + ",rgsexo=" + getSexo() + ",rgNacionalidade=" + getNacionalidade()
				+ ",rgEstadoNatal=" + getEstadoNatal() + ",rgCidadeNatal=" + getCidadeNatal() + '}';

		return listaRG.replace("DadosPessoais_RG{", "").replace("}", "");

	}

	public String lista_CarteiraTrabalho() {

		String listaCarteiraTrabalho = "DadosPessoais_CarteiraTrabalho{"

				+ "cartTrabNumero=" + getCartTrabnumero() + ",cartTrabSerie=" + getCartTrabserie() + ",cartTrabEmissao="
				+ getCartTrabemissao() + ",cartTraPis=" + getCartTraPis() + ",cartTrabRegisProf=" + getCartTrabRegisProf() + '}';

		return listaCarteiraTrabalho.replace("DadosPessoais_CarteiraTrabalho{", "").replace("}", "");

	}

	public String lista_TituloEleitor() {

		String listaTituloEleitor = "DadosTituloEleitor{"

				+ "tituEleNumero=" + getTituEleNumero() + ",tituEleEmissao=" + getTituEleEmissao() + ",tituEleUF="
				+ getTituEleUF() + ",tituEleZona=" + getTituEleZona() + ",tituEleSecao=" + getTituEleSecao() + '}';

		return listaTituloEleitor.replace("DadosTituloEleitor{", "").replace("}", "");

	}

	public String grauInstrucao() {

		return getGrauInstituicaoEdu();

	}
	


}
