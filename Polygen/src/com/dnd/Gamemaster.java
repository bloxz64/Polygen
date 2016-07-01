package com.dnd;

import com.flappy.Main;
import com.polygen.MainGame;

public class Gamemaster extends MainGame{

	public static void main(String[] args) {
		Main game = new Main();
		game.setBasicWindowInfo(1280, 720, "D&D online)");
		game.startGame();

	}

	@Override
	public void addStates() {
			
			
	}
}
