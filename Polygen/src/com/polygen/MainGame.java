package com.polygen;

import java.awt.Canvas;
import java.awt.Window;
import java.util.ArrayList;

/**
 * This is the main game that will be extended for the game
 * Date Created: 5/9/2016
 * @author Owen Anderson
 *
 */
public abstract class MainGame extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2431754512502369258L;
	//init the global variables
	private String title;
	private Thread thread;
	private int screenWidth;
	private int screenHeight;
	private int currentState;
	private boolean resizeable;
	private boolean running;
	private ArrayList<BasicState> states;
	
	/**
	 * Base constructor that takes no arguments
	 */
	public MainGame(){
		init();
	}

	/**
	 * Constructor that includes setting base values for screen width, height and title of the window
	 * @param width the width that the screen will be
	 * @param height the height that the screen will be
	 * @param title the title of the game
	 */
	public MainGame(int width, int height, String title){
		init();
		this.title = title;
		this.screenWidth = width;
		this.screenHeight = height;
	}
	
	/**
	 * Method to add the states based on what the creator of the subclass has and only runs on start of game
	 */
	public abstract void addStates();

	/**
	 * does init for all constructors
	 */
	private void init() {
		states = new ArrayList<BasicState>();
		currentState = 0;
		addStates();
	}
	
	public void startGame(){
		new Window(title, screenWidth, screenHeight, this);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * method to add a state to the list of states
	 * @param state the state
	 */
	public void addState(BasicState state){
		states.add(state);
	}
	
	/**
	 * Switches the state to a given state
	 * @param stateIndex the state that will be changed to
	 * @return if the change was done successfully
	 */
	public boolean switchState(int stateIndex){
		try{
			states.get(stateIndex);
		}catch(ArrayIndexOutOfBoundsException e){ //runs if the state is not in the list
			System.out.println("State did not exsist in the list");
			return false;
		}
		states.get(currentState).stopState();
		currentState = stateIndex;
		states.get(currentState).startState();
		
		return true;
	}
	
	//Getters and setters
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public boolean isResizeable() {
		return resizeable;
	}

	public void setResizeable(boolean resizeable) {
		this.resizeable = resizeable;
	}
	
}
