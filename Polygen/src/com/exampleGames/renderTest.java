package com.exampleGames;

import com.polygen.MainGame;

public class renderTest extends MainGame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246471372144188805L;

	public static void main(String[] args){
		renderTest game = new renderTest();
		game.startGame();
	}
	
	@Override
	public void addStates() {
		addState(new FirstState());
		addState(new SecondState());
	}

}
