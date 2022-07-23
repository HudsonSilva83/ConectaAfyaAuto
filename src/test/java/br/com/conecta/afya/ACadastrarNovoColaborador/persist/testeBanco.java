package br.com.conecta.afya.ACadastrarNovoColaborador.persist;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.ClientProtocolException;
import org.w3c.dom.CDATASection;

import br.com.conecta.afya.page.EnviarDocumentacaoPage;
import br.com.conecta.afya.services.AprovarExameAdmissional;

public class testeBanco {

	public static void main(String[] args) throws SQLException, ClientProtocolException, IOException {

		//ColaboradorDAO cola = new ColaboradorDAO();
		//cola.cadastrarColaborador();

		//EnviarDocumentosDAO doc = new EnviarDocumentosDAO();

		//doc.cadastroDocumento();
		//doc.deletarDocumento();

		//DadosBancariosDAO banco = new DadosBancariosDAO();
		//banco.cadastrarDadosBancarios();
		 //banco.deletarDadosBancarios();

		//CadastroBeneficiosDAO bene = new CadastroBeneficiosDAO();
		//bene.cadastrarBeneficios();
		//bene.deletarBeneficios();
		
		
				
		
		ExcluirGeralDAO bancoGral = new ExcluirGeralDAO();
		
		bancoGral.excluirGeral();
		

		
//		ExameAdmissionalDAO exame = new ExameAdmissionalDAO();
//		
//		exame.agendarExemaAdmissional();
//		exame.confirmarEnviarExemaAdmissional();
//		exame.aprovarExemaAdmissional();
		
		
		
		

	}
}
