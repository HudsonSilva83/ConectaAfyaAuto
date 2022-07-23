package br.com.conecta.afya.domain;

public class DadosEmpresa {

	String empresa;
	String endereco;
	String cep;
	String emissao;
	String cnpj;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmissao() {
		return emissao;
	}

	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public String lista_DadosEmpresa() {

		String listaDadosEmpresa = "DadosEmpresa{"

				+ "empresa=" + getEmpresa() + ",endereco=" + getEndereco() + ",cep="
				+ getCep() + ",emissao=" + getEmissao() + ",cnpj=" + getCnpj()
								
				+ '}';

		return listaDadosEmpresa.replace("DadosEmpresa{", "").replace("}", "");

	}


}
