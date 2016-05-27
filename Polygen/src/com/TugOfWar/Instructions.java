package com.TugOfWar;

import java.awt.Graphics;
import java.awt.Image;

import com.polygen.BasicState;
import com.polygen.ButtonObject;
import com.polygen.MainGame;

/**
 * the instructions screen for the game
 * @author Owen Anderson
 *
 */
public class Instructions extends BasicState{

	//creates global varibles
	private ButtonObject back;
	private Image img;
	
	@Override
	public void init(MainGame game) {
		//sets up back button
		back = new ButtonObject("src/com/TugOfWar/BackButton.png");
		back.setPos(Game.getCenter(game.getScreenWidth(), (int) back.getWidth()), (int) (game.getScreenHeight() - (back.getHeight() + 20)));
		
		//load image for the text
		img = Game.loadImage("src/com/TugOfWar/Instructions.png");
		
		//add back button to state object list
		addObject(back);
	}

	@Override
	public void startState() {}

	@Override
	public void render(Graphics g, MainGame game) {
		//renders text for instructions
		g.drawImage(img, Game.getCenter(game.getScreenWidth(), img.getWidth(null)), 10, null);
	}

	@Override
	public void update(double delta, MainGame game) {
		//goes back to menu if back button is clicked
		if(((ButtonObject) getObject(0)).clicked()){
			game.switchState(0);
		}
	}

	@Override
	public void stopState() {}

}
