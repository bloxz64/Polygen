package com.polygen;

import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * the basic skeleton that all the states are extended from (by the user)
 * @author Owen Anderson, Christopher Lapena
 *
 */

public abstract class BasicState {

	private ArrayList<GameObject> objects; //a list of the objects that will be drawn and updated
	
	/**
	 * empty contructor just for initing array 
	 */
	public BasicState(){
		objects = new ArrayList<GameObject>();
	}
	
	/**
	 * runs when the game starts and loads resources 
	 * @param game 
	 */
	public abstract void init(MainGame game);
	
	
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
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).render(g, game);
		}
		
		render(g, game);
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
	public void backEndUpdate(double delta, MainGame game){
		for(int i = 0; i < objects.size(); i++){
			objects.get(i).update(delta, game);
		}
		
		update(delta, game);
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
	
	/**
	 * calls a method of choice on all objects with a given set of tags
	 * @param methodName the name of the method that is being called
	 * @param tags the tags that the method will be called on
	 */
	public void doOnTag(String methodName, String[] tags){
		Method method;
		for(int i = 0; i < objects.size(); i++){
			for(int o = 0; o != tags.length; o++){
				if(o == tags.length){
					try {
						method = objects.get(i).getClass().getMethod("methodName");
						method.invoke(objects.get(i));
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				if(!objects.get(i).hasTag(tags[o])){
					break;
				}
			}
		}
	}
}
