package com.polygen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * The class that handles the keyboard controls for the main class
 * @author Owen Anderson, Christopher Lapena
 *
 */

public class KeyListener extends KeyAdapter{
	private HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>(0); //hash map that stores the keys states
	  

	/**
	 * empty constructor
	 */
	public KeyListener(){}
	
	/**
	 * method can is run by the MainGame class to get access to the keys list
	 * @param key_constant the key code that you want to find use KeyEvent.VK_<key name>
	 * @return a boolean true or false depending if the key is pressed or not
	 */
	public boolean isKeyPressed(int key_constant){
		if(keys.get(key_constant) == null){ //if the key is not found in the hashmap put a placeholder in and set it to false
			keys.put(key_constant, false);
		}
		return keys.get(key_constant);
	}
	
	@Override
	public void keyPressed(KeyEvent e){ //the event runs if a key is pressed once per key pressed
		keys.put(e.getKeyCode(), true); //adds the key's code to the hash maps and sets it to true
		
	}
	
	@Override
	public void keyReleased(KeyEvent e){ //same as key pressed but this runs for when a key is released
		keys.put(e.getKeyCode(), false); //sets the hashmap index that the key is stored in to false
	}
}
