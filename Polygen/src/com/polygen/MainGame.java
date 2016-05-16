package com.polygen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.image.BufferStrategy;
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
	private String title = "Basic Game";
	private Thread thread;
	private int screenWidth = 500;
	private int screenHeight = 500;
	private int currentState;
	private boolean resizeable;
	private boolean running;
	private ArrayList<BasicState> states;

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
		init();
		new GameWindow(title, screenWidth, screenHeight, this);
	}
	
	/**
	 * starts the main loop
	 */
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	/**
	 * stops the main loop
	 */
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * the main loop for the game
	 */
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60d;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0d;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update(delta);
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	/**
	 * renders the current state
	 */
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		states.get(currentState).render(g, this);
		
		g.dispose();
		bs.show();
	}
	
	/**
	 * updates the current state
	 */
	private void update(double delta) {
		states.get(currentState).update(delta, this);
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
