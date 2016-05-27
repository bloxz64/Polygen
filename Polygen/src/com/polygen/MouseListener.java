package com.polygen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * the class the detects the mouse button presses works nearly identical to KeyListener
 * @author Owen Anderson, Christopher Lapena
 *
 */
public class MouseListener extends MouseAdapter{
	private HashMap<Integer, Boolean> buttons = new HashMap<Integer, Boolean>(0); //the list that the key states will be stored in

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		buttons.put(e.getButton(), true);
	}

	public void mouseReleased(MouseEvent e) {
		buttons.put(e.getButton(), false);
	}
	
	public boolean isPressed(int button_constant){
		if(buttons.get(button_constant) == null){
			buttons.put(button_constant, false);
		}
		return buttons.get(button_constant);
	}
}
