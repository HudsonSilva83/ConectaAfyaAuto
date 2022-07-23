package br.com.conecta.afya.domain;

public class DadosCargo {
	
	String cargo;
	String area;
	String admissao;
	String formaPagamento;
	String salario;
	String salarioHora;
	String jornada;
	String opcaoFGTS;
	String horario;
	
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAdmissao() {
		return admissao;
	}
	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getSalarioHora() {
		return salarioHora;
	}
	public void setSalarioHora(String salarioHora) {
		this.salarioHora = salarioHora;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getOpcaoFGTS() {
		return opcaoFGTS;
	}
	public void setOpcaoFGTS(String opcaoFGTS) {
		this.opcaoFGTS = opcaoFGTS;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
	public String lista_DadosCargo() {

		String listaDadosCargo = "DadosCargo{"

				+ "cargo=" + getCargo() + ",area=" + getArea() + ",admissao="
				+ getAdmissao() + ",formaPagamento=" + getFormaPagamento() + ",salario=" + getSalario()
				+ ",salarioHora=" + getHorario() + ",jornada=" + getJornada()
				+ ",opcaoFGTS=" + getOpcaoFGTS()
				+ ",horario=" + getHorario()
				
				+ '}';

		return listaDadosCargo.replace("DadosCargo{", "").replace("}", "");

	}
	
	




	
	

}
