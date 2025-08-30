package view;

import controller.ThreadPing;

public class Main {

	public static void main(String[] args) {
		ThreadPing t1 = new ThreadPing("www.uol.com.br");
		ThreadPing t2 = new ThreadPing("www.terra.com.br");
		ThreadPing t3 = new ThreadPing("www.google.com.br");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
