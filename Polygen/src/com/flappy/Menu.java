package com.flappy;

import java.awt.Font;
import java.awt.Graphics;

import com.polygen.*;

public class Menu extends BasicState{
	
	private ButtonObject playButton;
	private ButtonObject instructionsButton;
	private ButtonObject exitButton;
	private Font font;
	
	@Override
	public void init(MainGame game) {
		playButton = new ButtonObject("src/com/flappy/PlayButton.png");
		playButton.setPos(Main.getCenter(game.getScreenWidth(), (int) playButton.getWidth()), 100);
		
		instructionsButton = new ButtonObject("src/com/flappy/InstructionsButton.png");
		instructionsButton.setPos(Main.getCenter(game.getScreenWidth(), (int) instructionsButton.getWidth()), 100);
		
		exitButton = new ButtonObject("src/com/flappy/ExitButton.png");
		exitButton.setPos(Main.getCenter(game.getScreenWidth(), (int) exitButton.getWidth()), 100);
		
		font = new Font(Font.SERIF, Font.PLAIN, 40);
		
		addObject(playButton);
		addObject(instructionsButton);
		addObject(exitButton);
	}

	@Override
	public void startState() {}

	@Override
	public void render(Graphics g, MainGame game) {
		g.setFont(font);
		g.drawString("Floopy Bird", Main.getCenter(game.getScreenWidth(), g.getFontMetrics().stringWidth("Floopy Bird")), 50);
		// draw images maybe
	}

	@Override
	public void update(double delta, MainGame game) {
		if (((ButtonObject) getObject(0)).clicked()){
			game.switchState(1);
		}
		if (((ButtonObject) getObject(0)).clicked()){
			game.switchState(2);
		}
		if (((ButtonObject) getObject(0)).clicked()){
			game.stopGame();
		}
	}

	@Override
	public void stopState() {}

}
