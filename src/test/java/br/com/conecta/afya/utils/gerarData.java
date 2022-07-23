package br.com.conecta.afya.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class gerarData {

	public String gerarDataForm01() {

		Date dataDoUsuario = new Date();

		// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia
		// nela

		Calendar c = Calendar.getInstance();
		c.setTime(dataDoUsuario);
		c.add(Calendar.DATE, +1);

		// Obtemos a data alterada
		dataDoUsuario = c.getTime();

		// formatando a data "2022-07-15 00:00:00";
		// SimpleDateFormat format = new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dataFormatada = format.format(dataDoUsuario = c.getTime());

		return dataFormatada;

	}

	public String gerarDataForm02() {

		Date dataDoUsuario = new Date();

		// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia
		// nela

		Calendar c = Calendar.getInstance();
		c.setTime(dataDoUsuario);
		// c.add(Calendar.DATE, +1);

		// Obtemos a data alterada
		dataDoUsuario = c.getTime();

		// formatando a data "2022-07-15 00:00:00";
		// SimpleDateFormat format = new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dataFormatada = format.format(dataDoUsuario = c.getTime());

		return dataFormatada;

		// System.out.println(dataExame);

	}

	public String gerarDataForm03() {

		Date dataDoUsuario = new Date();

		// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia
		// nela

		Calendar c = Calendar.getInstance();
		c.setTime(dataDoUsuario);
		// c.add(Calendar.DATE, +1);

		// Obtemos a data alterada
		dataDoUsuario = c.getTime();

		// formatando a data 2022-07-18T12:18:00.704-03:00
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'-03:00'");
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");

		String dataFormatada = format.format(dataDoUsuario = c.getTime());

		return dataFormatada;

		// System.out.println(dataExame);

	}
	
	
	public String horaLocal() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.MINUTE, -1);
		

		String hora = df.format(cal.getTime());
		return hora.substring(11, 16).trim();

}
}