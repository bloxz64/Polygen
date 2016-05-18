package com.polygen;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class BasicState {

	ArrayList<GameObject> objects;
	
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
	public abstract void render(Graphics g, MainGame game);
	
	public void backEndRender(Graphics g, MainGame game){
		render(g, game);
		
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).render();
		}
	}
	
	public void 
	
	/**
	 * the update method used to the game
	 * @param delta the time between the last update and this one
	 */
	public abstract void update(double delta, MainGame game);
	
	/**
	 * runs when the state stops to close up anything that needs to be
	 */
	public abstract void stopState();
}
