package com.polygen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class MouseListener extends MouseAdapter{
	private HashMap<Integer, Boolean> buttons = new HashMap<Integer, Boolean>(0);

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
