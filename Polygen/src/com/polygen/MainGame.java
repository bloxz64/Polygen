package com.polygen;

import java.util.ArrayList;

/**
 * This is the main game that will be extended for the game
 * Date Created: 5/9/2016
 * @author Owen Anderson
 *
 */
public abstract class MainGame {

	//init the global variables
	private String title;
	private int screenWidth;
	private int screenHeight;
	private int currentState;
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
	
	/**
	 * method to add a state to the list of states
	 * @param state the state
	 */
	public void addState(BasicState state){
		states.add(state);
	}
	
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
	
}
