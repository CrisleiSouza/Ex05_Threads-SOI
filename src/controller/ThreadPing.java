package controller;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ThreadPing extends Thread{
	
	private String servidor;
	
	public ThreadPing(String servidor) {
		this.servidor = servidor;
	}
	
	@Override
	public void run() {
		getPing();
	}
	
	private String os() {
		return System.getProperty("os.name");
	}
	
	private void getPing() {
		if (os().contains("Linux")) {
			StringBuffer criarComando = new StringBuffer();
			criarComando.append("ping -4 -c 10 ");
			criarComando.append("www.");
			criarComando.append(servidor);
			criarComando.append(".com.br");
			String[] comando = (criarComando.toString()).split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(comando);
				InputStreamReader leitor = new InputStreamReader((p.getInputStream()));
				BufferedReader ler = new BufferedReader(leitor);
				String linha = ler.readLine();
				String[] tempo, tempoMedio;
				
				while (linha != null) {
					if (linha.contains("time=")) {
						tempo = linha.split("time=");
						System.out.println(servidor + " -> " + tempo[1].trim());
					}
					if (linha.contains("avg")) {
						tempoMedio = linha.split("/");
						System.out.println("Tempo médio do servidor " + servidor + ": " + tempoMedio[4] + " ms.");
					}
					linha = ler.readLine();
				}
				
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		else {
			System.out.println("Sistema operacional inválido, tente em Linux.");
		}
	}
	
}
