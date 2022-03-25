package br.com.conecta.afya.Cadastrar.EnviarDocumentos.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = "src/test/resources/features/CadastrarEnviarDocumentos.feature", 
	glue = "br.com.conecta.afya.Cadastrar.EnviarDocumentos.steps", 
	monochrome = true, 
	dryRun = false, 
	plugin = {"json:target/CadastrarEnviarDocumentos.json" })




public class CadastrarEnviarDocumentosTest {

}
