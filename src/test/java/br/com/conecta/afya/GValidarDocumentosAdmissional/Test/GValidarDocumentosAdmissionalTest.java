package br.com.conecta.afya.GValidarDocumentosAdmissional.Test;

import org.junit.runner.RunWith;

import br.com.conecta.afya.core.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/ValidarDocumentosAdmissional.feature", glue = "br.com.conecta.afya.GValidarDocumentosAdmissional.steps", monochrome = true, dryRun = false,
				 //tags = "~@ignore",
		tags ="@teste",
		plugin = {"json:target/ValidarDocumentosAdmissionalApp.json","html:target/ValidarDocumentosAdmissionalApp.html"})

public class GValidarDocumentosAdmissionalTest extends BaseTest{

}






