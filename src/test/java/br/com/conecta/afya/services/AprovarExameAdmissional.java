package br.com.conecta.afya.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class AprovarExameAdmissional {
	
		
	public StatusLine aprovarExame() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut("https://conectadev.azurewebsites.net/agendamento/status-comprovante/534902");

		
		String json = "{\"statusComprovante\":\"COMPROVANTE_OK\"}";

		StringEntity entity = new StringEntity(json);
		httpPut.setEntity(entity);

		httpPut.setHeader("Authorization", "Bearer "
				+ "ei6pI6WkAfNfdvPSbu7jObywn+N2Oak1Q0aTESZS5rLtOmaeeHbcLkjFIt4p9oaakJ3J7ClusU5k3k+hZ5byCSZC/4spU2Zjna+QDgMcPnzVa1MZuA4Wvy73P1hO0z91e5rU+GiPRdM63n1ktIGDYzVoUva2bNSy3+BhDEYpGSq+O049gJEO236lLBFg7VFdV84+TaWY4OpInOaCpwTJCKtBwceqBP5uP/aEGdTVpcPZkQfECVaJfPMFZqkuV6oChdzVHwcd4ZRHzq3NGg7ccQ==");

		httpPut.setHeader("Accept", "application/json");
		httpPut.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPut);

		String responseAsString = EntityUtils.toString(response.getEntity());

		Gson gson = new Gson();
		JsonObject jsonParse = JsonParser.parseString(responseAsString).getAsJsonObject();

	
		System.out.println(response.getStatusLine());

		client.close();
		return response.getStatusLine();
	}
	
	
	

}
