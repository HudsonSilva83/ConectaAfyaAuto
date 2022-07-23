package br.com.conecta.afya.FCadastrarAgendamentoExame.Test;

import org.junit.runner.RunWith;

import br.com.conecta.afya.core.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/AgendarExame.feature", glue = "br.com.conecta.afya.FCadastrarAgendamentoExame.steps", monochrome = true, dryRun = false,
				 //tags = "~@ignore",
		//tags ="@AgendarExame",
		plugin = {"json:target/CadastrarAgendamentoExameApp.json","html:target/CadastrarAgendamentoExameApp.html"})

public class FAgendamentoExameTest extends BaseTest{

}






