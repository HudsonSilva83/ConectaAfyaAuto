package br.com.conecta.afya.services;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.cucumber.java.it.Data;

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;

//import br.com.conecta.afya.model.Credenciais;
//import br.com.conecta.afya.utils.GerarIdPlataforma;

public class AgendamentoCadastrar {

	public StatusLine agendamentoCadastrar() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://conectadev.azurewebsites.net/agendamento/cadastrar");

		// GerarIdPlataforma id = new GerarIdPlataforma();

		int IdPlataforma = 534902;
			
		Date dataDoUsuario = new Date();

		// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia nela
		
		Calendar c = Calendar.getInstance();
		c.setTime(dataDoUsuario);
		c.add(Calendar.DATE, +1);
		
		// Obtemos a data alterada
		dataDoUsuario = c.getTime();

		//formatando a data		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
		String dataExame = format.format(dataDoUsuario = c.getTime());
		
		//System.out.println(dataExame);
		
			                

		String json = "{\"clinica\":{\"endereco\":\"Rua da Automacao 400\",\"name\":\"ClinicaUm\",\"telefone\":\"31999999999\"},\"dataExame\":\""
				+ dataExame + "\",\"idPlataforma\":\"" + IdPlataforma + "\"}";

		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);

		httpPost.setHeader("Authorization", "Bearer "
				+ "ei6pI6WkAfNfdvPSbu7jObywn+N2Oak1Q0aTESZS5rLtOmaeeHbcLkjFIt4p9oaakJ3J7ClusU5k3k+hZ5byCSZC/4spU2Zjna+QDgMcPnzVa1MZuA4Wvy73P1hO0z91e5rU+GiPRdM63n1ktIGDYzVoUva2bNSy3+BhDEYpGSq+O049gJEO236lLBFg7VFdV84+TaWY4OpInOaCpwTJCKtBwceqBP5uP/aEGdTVpcPZkQfECVaJfPMFZqkuV6oChdzVHwcd4ZRHzq3NGg7ccQ==");

		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);

		String responseAsString = EntityUtils.toString(response.getEntity());

		Gson gson = new Gson();
		JsonObject jsonParse = JsonParser.parseString(responseAsString).getAsJsonObject();

		// System.out.println(responseAsString);
		// System.out.println(response.getStatusLine());
		// System.out.println(responseAsString.trim());
		System.out.println(response.getStatusLine());

		client.close();
		return response.getStatusLine();
	}

}
