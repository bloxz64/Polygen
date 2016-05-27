package com.polygen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
/**
 * the class the updates the position of the mouse in the game
 * @author Owen Anderson, Christopher Lapena
 *
 */
public class MousePosListener extends MouseMotionAdapter{
	private int x, y = 0;

	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public void mouseDragged(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}
	
	protected int getMouseX(){
		return x;
	}
	
	protected int getMouseY(){
		return y;
	}
	
	protected int[] getMousePos(){
		return new int[] {x, y};
	}
}