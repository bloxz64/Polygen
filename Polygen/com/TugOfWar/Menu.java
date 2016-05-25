package com.TugOfWar;

import java.awt.Graphics;
import java.awt.Image;

import com.polygen.BasicState;
import com.polygen.MainGame;

public class Menu extends BasicState{

	Image playButton;
	Image instructionsButton;
	Image exitButton;
	
	@Override
	public void init() {
		playButton = loadImage("TugOfWar/PlayButton.png");
		instructionsButton = loadImage("TugOfWar/InstructionsButton.png");
		exitButton = loadImage("TugOfWar/ExitButton.png");
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.drawImage(playButton, Game.getCenter(game.getScreenWidth(), playButton.getWidth(null)), 100, null);
		g.drawImage(instructionsButton, Game.getCenter(game.getScreenWidth(), instructionsButton.getWidth(null)), 200, null);
		g.drawImage(exitButton, Game.getCenter(game.getScreenWidth(), exitButton.getWidth(null)), 300, null);
	}

	@Override
	public void update(double delta, MainGame game) {
		
	}

	@Override
	public void stopState() {
		
	}

}
