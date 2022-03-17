package br.com.conecta.afya.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;	

import br.com.conecta.afya.test.CadastroPessoaTest;
import br.com.conecta.afya.test.EnviarDocumentosTest;

@RunWith(Suite.class)
@SuiteClasses({

		CadastroPessoaTest.class, 
		EnviarDocumentosTest.class

})
public class SuiteGeral {

	
}
