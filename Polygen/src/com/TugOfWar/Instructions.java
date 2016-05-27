package com.TugOfWar;

import java.awt.Graphics;
import java.awt.Image;

import com.polygen.BasicState;
import com.polygen.ButtonObject;
import com.polygen.MainGame;

public class Instructions extends BasicState{

	private ButtonObject back;
	private Image img;
	
	@Override
	public void init(MainGame game) {
		back = new ButtonObject("src/com/TugOfWar/BackButton.png");
		back.setX(Game.getCenter(game.getScreenWidth(), (int) back.getWidth()));
		back.setY((int) (game.getScreenHeight() - (back.getHeight() + 20)));
		addObject(back);
		img = Game.loadImage("src/com/TugOfWar/Instructions.png");
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.drawImage(img, Game.getCenter(game.getScreenWidth(), img.getWidth(null)), 10, null);
	}

	@Override
	public void update(double delta, MainGame game) {
		if(((ButtonObject) getObject(0)).clicked()){
			game.switchState(0);
		}
	}

	@Override
	public void stopState() {
		
	}

}
