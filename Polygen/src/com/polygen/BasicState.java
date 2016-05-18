package com.polygen;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class BasicState {

	private ArrayList<GameObject> objects;
	
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
	 * @param game the game object
	 */
	public abstract void render(Graphics g, MainGame game);
	
	/**
	 * is the back end for the render method and draws the objects from the list as well
	 * as the player defined rendering
	 * @param g The graphics drawing thingy
	 * @param game the game object
	 */
	public void backEndRender(Graphics g, MainGame game){
		render(g, game);
		
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).render(g, game);
		}
	}
	
	/**
	 * the update method used to the game
	 * @param delta the time between the last update and this one
	 * @param game the game object
	 */
	public abstract void update(double delta, MainGame game);
	
	/**
	 * the back end update same as back end render
	 * @param delta the time between updates
	 * @param game the game object
	 */
	public void backEndRender(double delta, MainGame game){
		update(delta, game);
		
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).update(delta, game);
		}
	}
	
	/**
	 * runs when the state stops to close up anything that needs to be
	 */
	public abstract void stopState();
	
	/**
	 * adds an object to the object list
	 * @param obj the object to add
	 */
	public void addObject(GameObject obj){
		objects.add(obj);
	}
	
	/**
	 * gets an object at the given index
	 * @param index the index to get object at
	 * @return the object
	 */
	public GameObject getObject(int index){
		return objects.get(index);
	}
	
	/**
	 * returns the list of all objects
	 * @return the object list
	 */
	public ArrayList<GameObject> getObjectList(){
		return objects;
	}
}
