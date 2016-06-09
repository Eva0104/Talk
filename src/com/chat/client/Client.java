package com.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw;
		while(true){
			Socket s = new Socket(UsersData.HORT,UsersData.PORT);
			System.out.println("请输入用户名：");
			String name = sc.next();

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(),true);
			pw.println(name);
			
			String str = br.readLine();
			if(str.equals("success")){
				
				ReceiveMessage rm = new ReceiveMessage(br);
				new Thread(rm).start();
				break;
			}
		}
		while(true){
			pw.println(sc.nextLine());
		}
	}
}
