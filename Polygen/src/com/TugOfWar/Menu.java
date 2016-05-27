package com.TugOfWar;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.polygen.BasicState;
import com.polygen.ButtonObject;
import com.polygen.MainGame;

/**
 * the menu for the game that leads to the game and the instructions screen
 * @author Owen Anderson
 *
 */
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
		
		//load and set up buttons
		playButton = new ButtonObject("src/com/TugOfWar/PlayButton.png");
		playButton.setPos(Game.getCenter(game.getScreenWidth(), (int) playButton.getWidth()), 100);
		
		instructionsButton = new ButtonObject("src/com/TugOfWar/InstructionsButton.png");
		instructionsButton.setPos(Game.getCenter(game.getScreenWidth(), (int) instructionsButton.getWidth()), 200);
		
		exitButton = new ButtonObject("src/com/TugOfWar/ExitButton.png");
		exitButton.setPos(Game.getCenter(game.getScreenWidth(), (int) exitButton.getWidth()), 300);
		
		//load the images and fonts
		thumbsUp = Game.loadImage("src/com/TugOfWar/ThumbsUP.png");
		shrug = Game.loadImage("src/com/TugOfWar/Shrug.png");
		fontTitle = new Font(Font.SERIF, Font.PLAIN, 40);
		
		//add the buttons to the state's object list
		addObject(playButton);
		addObject(instructionsButton);
		addObject(exitButton);
	}

	@Override
	public void startState() {}

	@Override
	public void render(Graphics g, MainGame game) {
		//render stuff
		g.setFont(fontTitle);
		g.drawString("TUG OF WAR", Game.getCenter(game.getScreenWidth(), g.getFontMetrics().stringWidth("TUG OF WAR")), 50);
		g.drawImage(shrug, 650, 100, null);
		g.drawImage(thumbsUp, 100, 100, null);
	}

	@Override
	public void update(double delta, MainGame game) {
		//checks if the buttons have been clicked if so do the right action
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
	public void stopState() {}

}
