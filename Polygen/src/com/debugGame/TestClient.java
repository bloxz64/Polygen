package com.debugGame;

import java.util.Scanner;

import com.polygen.ClientConnectionManager;

public class TestClient {
	public static void main(String[] args){
		ClientConnectionManager man = new ClientConnectionManager(5000, "localhost");
		while(!man.getConnected()){
			
		}
		System.out.println("Connected!");
		man.sendMessageToSever("booty clap");
	}
}
