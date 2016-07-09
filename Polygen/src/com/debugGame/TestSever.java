package com.debugGame;

import com.polygen.ServerConnectionManager;

public class TestSever {
	
	public static void main(String[] args){
		ServerConnectionManager scm = new ServerConnectionManager(5000);
		System.out.println("waiting");
		while(scm.numOfClients() == 0){
			
		}
		System.out.println("Client Found");
		
		while(true){
			String msg = scm.popMessage(0);
			if(msg != null) System.out.println(msg);
		}
	}
	
}
