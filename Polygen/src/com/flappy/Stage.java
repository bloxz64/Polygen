package com.flappy;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.polygen.*;

public class Stage extends BasicState{

	private Image birdImage, background;
	private int x, y, gravity, score;
	private Font font;
	private Bird bird;
	
	@Override
	public void init(MainGame game) {
		birdImage = Main.loadImage(path);
		background = Main.loadImage(path);
		font = new Font(Font.SERIF, Font.PLAIN, 40);
		bird = new Bird(birdImage);
	}

	@Override
	public void startState() {
		x = -100;
		y = 250;
		gravity = 0;
		score = 0;
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.setFont(font);
		g.drawString(String.valueOf(score), Main.getCenter(game.getScreenWidth(), g.getFontMetrics().stringWidth(String.valueOf(score))), 10);
		g.drawImage(background, 0, 0, null);
	}

	@Override
	public void update(double delta, MainGame game) {
		y += (gravity*delta)/100d;
		bird.setY(y);
		// rotate image
		
		
	}

	@Override
	public void stopState() {
		// TODO Auto-generated method stub
		
	}

}
