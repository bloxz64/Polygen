package com.polygen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Listener extends KeyAdapter{
	private boolean[] keys = {};
	
	public Listener(){
		
	}
	
	public boolean isKeyPressed(int key_constant){
		if (keys[key_constant]){
			return true;
		}
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		keys[e.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		keys[e.getKeyCode()] = false;
	}
}
