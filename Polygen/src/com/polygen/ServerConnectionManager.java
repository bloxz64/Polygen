package com.polygen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerConnectionManager {
	
	Thread connector;
	private int port;
	boolean connectorRunning = true;
	LinkedList<Client> clients;
	
	public ServerConnectionManager(int port){
		clients = new LinkedList<Client>();
		this.port = port;
		connector = new Thread(getConnector());
		connector.start();
	}
	
	private Runnable getConnector(){
		Runnable temp = new Runnable() {
			
			@Override
			public void run() {
				ServerSocket serverSock = null;
				try {
					serverSock = new ServerSocket(port);
				} catch (IOException e) {
					e.printStackTrace();
				}
				while(connectorRunning){
					try {
						Socket sock = serverSock.accept();
						System.out.println("heyo");
						clients.add(new Client(sock));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		return temp;
	}
	
	public String popMessage(int clientIndex){
		return clients.get(clientIndex).popMessage();
	}
	
	public int numOfClients(){
		return clients.size();
	}
	
	public void sendMessageTo(int clientIndex, String msg){
		clients.get(clientIndex).sendMessage(msg);
	}
	
	public void brodcaseMessage(String message){
		for(int i = 0; i < clients.size(); i++){
			clients.get(i).sendMessage(message);
		}
	}
	
	
}
