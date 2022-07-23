package br.com.conecta.afya.model;

import br.com.conecta.afya.utils.gerarData;

public class script08ColaboradorParte8 {
	
	String created_at;
	int deleted = 0;
	String enabled = "ENABLED_CADASTRO";
	String last_update;
	String name = "Hudson Banco de dados java";
	String search = null;
	String user_update;// = "2022-07-18T12:18:00.704-03:00";  2022-07-19T13:25:05.126-03:00
	String apelido = "Banco";
	String cargo = "ANALISTA DE DADOS PL";
	int coligada = 1;
	String confirma_gympass = null;
	int confirma_kit_admissional = 1;
	int confirma_plano_odontologico = 1;
	int confirma_plano_saude = 1;
	int confirma_vale_alimentacao = 1;
	int confirma_vale_transporte = 1;
	String cor = "BRANCA";
	String cpf = "28612091004";
	String dat_alteracao;
	String dat_insercao;;
	String email = "conecta.afya@gmail.com";
	int filial = 1;
	String genero = "NAOBINARIO";
	String id_plataforma = "534902";
	String assinatura = "https://saafyastorageeua.blob.core.windows.net/conectadev/colaboradores%2F28612091004%2Fimagem-assinatura-celular1.png";
	String login = "28612091004";
	String nome_social = "Automacao Social Afya teste";
	String senha = "j+eimakvq4In5K5ye/4jW6i+keDT1x8qJg7PDiSvZac=";
	String status_correcao = null;
	String telefone = "(31) 99999-9999";
	String tipo_admissao = null;
	String token = null;
	String unidade = "AFYA";
	String fk_tenant = null;
	int confirma_seguro_de_vida = 1;
	String data_admissao = null;
	int confirma_cetificado_reservista = 1;
	String salario = "5000.00";
	String t_colaboradorcol = null;
	String chamado_beneficios = null;
	String img_contrato_individual = null;
	
	
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String dataFormatada) {
		this.created_at = dataFormatada;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(gerarData data) {
		this.last_update = data.gerarDataForm02();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getUser_update() {
		return user_update;
	}
	public void setUser_update(gerarData data) {
		this.user_update = data.gerarDataForm03();
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getColigada() {
		return coligada;
	}
	public void setColigada(int coligada) {
		this.coligada = coligada;
	}
	public String getConfirma_gympass() {
		return confirma_gympass;
	}
	public void setConfirma_gympass(String confirma_gympass) {
		this.confirma_gympass = confirma_gympass;
	}
	public int getConfirma_kit_admissional() {
		return confirma_kit_admissional;
	}
	public void setConfirma_kit_admissional(int confirma_kit_admissional) {
		this.confirma_kit_admissional = confirma_kit_admissional;
	}
	public int getConfirma_plano_odontologico() {
		return confirma_plano_odontologico;
	}
	public void setConfirma_plano_odontologico(int confirma_plano_odontologico) {
		this.confirma_plano_odontologico = confirma_plano_odontologico;
	}
	public int getConfirma_plano_saude() {
		return confirma_plano_saude;
	}
	public void setConfirma_plano_saude(int confirma_plano_saude) {
		this.confirma_plano_saude = confirma_plano_saude;
	}
	public int getConfirma_vale_alimentacao() {
		return confirma_vale_alimentacao;
	}
	public void setConfirma_vale_alimentacao(int confirma_vale_alimentacao) {
		this.confirma_vale_alimentacao = confirma_vale_alimentacao;
	}
	public int getConfirma_vale_transporte() {
		return confirma_vale_transporte;
	}
	public void setConfirma_vale_transporte(int confirma_vale_transporte) {
		this.confirma_vale_transporte = confirma_vale_transporte;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDat_alteracao() {
		return dat_alteracao;
	}
	public void setDat_alteracao(gerarData data) {
		this.dat_alteracao = data.gerarDataForm02();
	}
	public String getDat_insercao() {
		return dat_insercao;
	}
	public void setDat_insercao(gerarData data) {
		this.dat_insercao = data.gerarDataForm02();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFilial() {
		return filial;
	}
	public void setFilial(int filial) {
		this.filial = filial;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getId_plataforma() {
		return id_plataforma;
	}
	public void setId_plataforma(String id_plataforma) {
		this.id_plataforma = id_plataforma;
	}
	public String getAssinatura() {
		return assinatura;
	}
	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome_social() {
		return nome_social;
	}
	public void setNome_social(String nome_social) {
		this.nome_social = nome_social;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getStatus_correcao() {
		return status_correcao;
	}
	public void setStatus_correcao(String status_correcao) {
		this.status_correcao = status_correcao;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo_admissao() {
		return tipo_admissao;
	}
	public void setTipo_admissao(String tipo_admissao) {
		this.tipo_admissao = tipo_admissao;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getFk_tenant() {
		return fk_tenant;
	}
	public void setFk_tenant(String fk_tenant) {
		this.fk_tenant = fk_tenant;
	}
	public int getConfirma_seguro_de_vida() {
		return confirma_seguro_de_vida;
	}
	public void setConfirma_seguro_de_vida(int confirma_seguro_de_vida) {
		this.confirma_seguro_de_vida = confirma_seguro_de_vida;
	}
	public String getData_admissao() {
		return data_admissao;
	}
	public void setData_admissao(String data_admissao) {
		this.data_admissao = data_admissao;
	}
	public int getConfirma_cetificado_reservista() {
		return confirma_cetificado_reservista;
	}
	public void setConfirma_cetificado_reservista(int confirma_cetificado_reservista) {
		this.confirma_cetificado_reservista = confirma_cetificado_reservista;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getT_colaboradorcol() {
		return t_colaboradorcol;
	}
	public void setT_colaboradorcol(String t_colaboradorcol) {
		this.t_colaboradorcol = t_colaboradorcol;
	}
	public String getChamado_beneficios() {
		return chamado_beneficios;
	}
	public void setChamado_beneficios(String chamado_beneficios) {
		this.chamado_beneficios = chamado_beneficios;
	}
	public String getImg_contrato_individual() {
		return img_contrato_individual;
	}
	public void setImg_contrato_individual(String img_contrato_individual) {
		this.img_contrato_individual = img_contrato_individual;
	}
	

}
