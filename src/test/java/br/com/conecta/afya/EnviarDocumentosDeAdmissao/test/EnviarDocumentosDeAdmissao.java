package br.com.conecta.afya.EnviarDocumentosDeAdmissao.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = "src/test/resources/features/EnviarDocumentosDeAdmissao.feature", 
	glue = "br.com.conecta.afya.EnviarDocumentosDeAdmissao.steps", 
	monochrome = true, 
	dryRun = false, 
	plugin = {"json:target/EnviarDocumentosDeAdmissao.json"})





public class EnviarDocumentosDeAdmissao {

}