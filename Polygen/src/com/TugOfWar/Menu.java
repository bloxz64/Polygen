package com.TugOfWar;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.text.AttributedCharacterIterator;

import com.polygen.BasicState;
import com.polygen.ButtonObject;
import com.polygen.MainGame;

public class Menu extends BasicState{

	//images for menu
	private ButtonObject playButton;
	private ButtonObject instructionsButton;
	private ButtonObject exitButton;
	private Image thumbsUp;
	private Image shrug;
	
	private Font fontTitle;
	
	@Override
	public void init(MainGame game) {
		playButton = new ButtonObject("src/com/TugOfWar/PlayButton.png");
		playButton.setX(Game.getCenter(game.getScreenWidth(), (int) playButton.getWidth()));
		playButton.setY(100);
		instructionsButton = new ButtonObject("src/com/TugOfWar/InstructionsButton.png");
		instructionsButton.setX(Game.getCenter(game.getScreenWidth(), (int) instructionsButton.getWidth()));
		instructionsButton.setY(200);
		exitButton = new ButtonObject("src/com/TugOfWar/ExitButton.png");
		exitButton.setX(Game.getCenter(game.getScreenWidth(), (int) exitButton.getWidth()));
		exitButton.setY(300);
		thumbsUp = Game.loadImage("src/com/TugOfWar/ThumbsUP.png");
		shrug = Game.loadImage("src/com/TugOfWar/Shrug.png");
		fontTitle = new Font(Font.SERIF, Font.PLAIN, 40);
		addObject(playButton);
		addObject(instructionsButton);
		addObject(exitButton);
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.setFont(fontTitle);
		g.drawString("TUG OF WAR", Game.getCenter(game.getScreenWidth(), g.getFontMetrics().stringWidth("TUG OF WAR")), 50);
		g.drawImage(shrug, 650, 100, null);
		g.drawImage(thumbsUp, 100, 100, null);
	}

	@Override
	public void update(double delta, MainGame game) {
		if(((ButtonObject) getObject(0)).clicked()){
			game.switchState(1);
		}
		if(((ButtonObject) getObject(1)).clicked()){
			game.switchState(2);
		}
		if(((ButtonObject) getObject(2)).clicked()){
			game.stopGame();
		}
	}

	@Override
	public void stopState() {
		
	}

}
