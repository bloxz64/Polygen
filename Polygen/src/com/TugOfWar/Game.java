package com.TugOfWar;

import com.polygen.MainGame;

/**
 * A game that displays some of the functions of our game engine
 * @author Owen Anderson
 *
 */
public class Game extends MainGame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -520620810132536791L;

	public static void main(String[] args) {
		Game game = new Game();
		game.setBasicWindowInfo(1000, 500, "TUG OF WAR");
		game.startGame();
	}

	@Override
	public void addStates() { //add all the states in for the game
		addState(new Menu());
		addState(new PlayGame());
		addState(new Instructions());
	}

}
