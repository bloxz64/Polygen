package com.polygen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Client {
	
	Socket socket;
	Thread manager;
	LinkedList<String> messages;
	PrintWriter out;
	BufferedReader in;
	boolean running = true;
	
	public Client(Socket sock){
		socket = sock;
		messages = new LinkedList<String>();
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		manager = new Thread(new ClientThread());
		manager.start();
	}

	private class ClientThread implements Runnable{

		@Override
		public void run() {
			while(running){
				try {
					String message = in.readLine();
					System.out.println(message);
					messages.add(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	public void sendMessage(String msg){
		out.println(msg);
	}
	
	public String popMessage(){
		String first = null;
		try{
			first = messages.getFirst();
			messages.removeFirst();
		}catch(NoSuchElementException e){}
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
	
	public void stop(){
		running = false;
	}
}


