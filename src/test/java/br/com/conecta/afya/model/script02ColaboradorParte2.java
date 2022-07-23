package br.com.conecta.afya.model;

import br.com.conecta.afya.utils.gerarData;

public class script02ColaboradorParte2 {
	
	
	String created_at = null; 
	int deleted = 0; 
	String enabled = "ENABLED_FLUIG"; 
	String last_update; 
	String name = "Nome Teste banco"; 
	String search = null; 
	String user_update = null; 
	String codigo_verificacao =  null; 
	int crypt_password = 1;
	String login = "28612091004"; 
	String password = "ykbwnY5+3JzqWOoBdvshUA=="; 
	String fk_tenant = null;
	
	
	
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
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
	public void setUser_update(String user_update) {
		this.user_update = user_update;
	}
	public String getCodigo_verificacao() {
		return codigo_verificacao;
	}
	public void setCodigo_verificacao(String codigo_verificacao) {
		this.codigo_verificacao = codigo_verificacao;
	}
	public int getCrypt_password() {
		return crypt_password;
	}
	public void setCrypt_password(int crypt_password) {
		this.crypt_password = crypt_password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFk_tenant() {
		return fk_tenant;
	}
	public void setFk_tenant(String fk_tenant) {
		this.fk_tenant = fk_tenant;
	}  



}
