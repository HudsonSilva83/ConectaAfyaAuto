package br.com.conecta.afyaConnection;

import br.com.conecta.afya.ACadastrarNovoColaborador.persist.ColaboradorDAO;
import br.com.conecta.afya.model.scriptColaboradorObterIdColaborador;

public class TesteBanco2 {

	public static void main(String[] args) throws Exception {
		

	
		
	ColaboradorDAO teste = new ColaboradorDAO();
	
	System.out.println(teste.pesquisaIdColaborador("28612091004"));
	
//	scriptColaboradorObterIdColaborador id = new scriptColaboradorObterIdColaborador();
//	id.setId_colaborador(teste.pesquisaIdColaborador("28612091004"));
//	System.out.println(id.getId_colaborador());
//	

	
	
	teste.cadastrarColaborador();
	
		

	}

}
