package br.com.conecta.afya.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.conecta.afya.ACadastrarNovoColaborador.Test.ACadastrarNovoColaboradorTest;
import br.com.conecta.afya.BLoginApp.test.BLoginAppTest;
import br.com.conecta.afya.CEnviarDocumentosDeAdmissao.test.CEnviarDocumentosDeAdmissao;
import br.com.conecta.afya.DAdicionarDadosBancarios.Test.DAdicionarDadosBancarios;

@RunWith(Suite.class)
@SuiteClasses({

		ACadastrarNovoColaboradorTest.class, 
		//BLoginAppTest.class, 
		//CEnviarDocumentosDeAdmissaoTest.class,
		//DAdicionarDadosBancariosTest.class

})
public class SuiteGeral {

}
