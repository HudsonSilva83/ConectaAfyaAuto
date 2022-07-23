package br.com.conecta.afya.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import br.com.conecta.afya.ACadastrarNovoColaborador.Test.ACadastrarNovoColaboradorTest;
import br.com.conecta.afya.BLoginApp.test.BLoginAppTest;
import br.com.conecta.afya.CEnviarDocumentosDeAdmissao.test.CEnviarDocumentosDeAdmissaoTest;
import br.com.conecta.afya.DAdicionarDadosBancarios.Test.DAdicionarDadosBancariosTest;
import br.com.conecta.afya.ECadastrarBeneficios.Test.ECadastrarBeneficiosTest;
import br.com.conecta.afya.FCadastrarAgendamentoExame.Test.*;
import br.com.conecta.afya.GValidarDocumentosAdmissional.Test.GValidarDocumentosAdmissionalTest;

@RunWith(Suite.class)
@SuiteClasses({

	

		//ACadastrarNovoColaboradorTest.class, 
		//BLoginAppTest.class, 
		//CEnviarDocumentosDeAdmissaoTest.class,
		//DAdicionarDadosBancariosTest.class,
		//ECadastrarBeneficiosTest.class,
		//FAgendamentoExameTest.class
	      GValidarDocumentosAdmissionalTest.class

})
public class SuiteGeral {

}
