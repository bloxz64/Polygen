package com.polygen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

public class ClientConnectionManager {

	Thread manager, connector;
	Socket sock;
	String adress;
	int port;
	PrintWriter out;
	BufferedReader in;
	private boolean running = true, connected;
	LinkedList<String> messages;
	
	public ClientConnectionManager(int port, String adress){
		this.port = port;
		this.adress = adress;		
		messages = new LinkedList<String>();
		
		connector = new Thread(getConnector(), "Connector");
		connector.start();
	}
	
	public Runnable getConnector(){
		Runnable temp = new Runnable() {
			
			@Override
			public void run() {
				try {
					sock = new Socket(adress, port);
					out = new PrintWriter(sock.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					connected = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
				startManagerThread();
			}
		};
		return temp;
	}
	
	private void startManagerThread() {
		manager = new Thread(getManager(), "ClientManager");
		manager.start();
	}
	
	public Runnable getManager(){
		Runnable temp = new Runnable(){
			@Override
			public void run() {
				while(running){
					try {
						String input = in.readLine();
						messages.add(input);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		};
		return temp;
	}
	
	public void sendMessageToSever(String message){
		out.println(message);
	}
	
	public String popMessage(){
		String first = messages.getFirst();
		messages.removeFirst();
		return first;
	}
	
	public LinkedList<String> getQueue(){
		LinkedList<String> temp = messages;
		messages = new LinkedList<String>();
		return temp;
	}
	
	public int getNumOfMessagesInQueue(){
		return messages.size();
	}
	
	public boolean getConnected(){
		return connected;
	}
	
}
