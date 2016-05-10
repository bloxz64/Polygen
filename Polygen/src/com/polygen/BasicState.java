package com.polygen;

import java.awt.Graphics;

public abstract class BasicState {

	
	/**
	 * runs when the game starts and loads resources 
	 */
	public abstract void init();
	
	
	/**
	 * runs when the state starts to setup the state
	 */
	public abstract void startState();
	
	/**
	 * render the states stuff
	 * @param g the graphics object used to draw stuff
	 */
	public abstract void render(Graphics g);
	
	/**
	 * the update method used to the game
	 * @param delta the time between the last update and this one
	 */
	public abstract void update(int delta);
	
	/**
	 * runs when the state stops to close up anything that needs to be
	 */
	public abstract void stopState();
}
