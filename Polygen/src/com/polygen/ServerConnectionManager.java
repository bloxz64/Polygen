package com.polygen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerConnectionManager {
	
	Thread connector;
	boolean connectorRunning = true;
	LinkedList<Client> clients;
	
	public ServerConnectionManager(){
		clients = new LinkedList<Client>();
	}
	
	private Runnable getConnector(){
		Runnable temp = new Runnable() {
			
			@Override
			public void run() {
				ServerSocket serverSock = null;
				try {
					serverSock = new ServerSocket(5000);
				} catch (IOException e) {
					e.printStackTrace();
				}
				while(connectorRunning){
					try {
						Socket sock = serverSock.accept();
						clients.add(new Client(sock));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		return temp;
	}
	
	
}
