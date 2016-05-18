package com.polygen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyListener extends KeyAdapter{
	private HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>(123);
	  

	public KeyListener(){
		
	}
	
	public boolean isKeyPressed(int key_constant){
		if(keys.get(key_constant) == null){
			keys.put(key_constant, false);
		}
		return keys.get(key_constant);
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		keys.put(e.getKeyCode(), true);
		
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		keys.put(e.getKeyCode(), false);
	}
}
