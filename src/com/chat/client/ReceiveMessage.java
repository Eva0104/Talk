package com.chat.client;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceiveMessage implements Runnable {
	private BufferedReader br;
	public ReceiveMessage(BufferedReader br){
		this.br = br;
	}
	@Override
	public void run() {
		while(true){
			try {
				System.out.println(br.readLine());
			} catch (IOException e) {
				System.exit(1);
				e.printStackTrace();
				
			}
		}
	}
}
