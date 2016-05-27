package com.TugOfWar;

import com.polygen.MainGame;

public class Game extends MainGame{

	public static void main(String[] args) {
		Game game = new Game();
		game.setBasicWindowInfo(1000, 500, "TUG OF WAR");
		game.startGame();
	}

	@Override
	public void addStates() {
		addState(new Menu());
		addState(new PlayGame());
		addState(new Instructions());
	}

}
