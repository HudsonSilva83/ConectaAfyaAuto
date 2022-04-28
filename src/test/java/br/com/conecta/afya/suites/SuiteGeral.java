package br.com.conecta.afya.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.conecta.afya.AdicionarDadosBancarios.Test.AdicionarDadosBancariosTest;
import br.com.conecta.afya.CadastrarNovoColaborador.Test.CadastrarNovoColaboradorTest;
import br.com.conecta.afya.EnviarDocumentosDeAdmissao.test.EnviarDocumentosDeAdmissaoTest;
import br.com.conecta.afya.LoginApp.test.LoginAppTest;

@RunWith(Suite.class)
@SuiteClasses({

		//CadastrarNovoColaboradorTest.class, 
		LoginAppTest.class, 
		//EnviarDocumentosDeAdmissaoTest.class,
		//AdicionarDadosBancariosTest.class

})
public class SuiteGeral {

}
