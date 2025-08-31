package view;

import controller.ThreadPing;

public class Main {

	public static void main(String[] args) {
		ThreadPing t1 = new ThreadPing("UOL");
		ThreadPing t2 = new ThreadPing("Terra");
		ThreadPing t3 = new ThreadPing("Google");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
