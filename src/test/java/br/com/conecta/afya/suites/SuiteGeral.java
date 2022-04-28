package br.com.conecta.afya.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.conecta.afya.AdicionarDadosBancarios.Test.DAdicionarDadosBancariosTest;
import br.com.conecta.afya.CadastrarNovoColaborador.Test.ACadastrarNovoColaboradorTest;
import br.com.conecta.afya.EnviarDocumentosDeAdmissao.test.CEnviarDocumentosDeAdmissaoTest;
import br.com.conecta.afya.LoginApp.test.BLoginAppTest;

@RunWith(Suite.class)
@SuiteClasses({

		ACadastrarNovoColaboradorTest.class, 
		BLoginAppTest.class, 
		CEnviarDocumentosDeAdmissaoTest.class,
		DAdicionarDadosBancariosTest.class

})
public class SuiteGeral {

}
