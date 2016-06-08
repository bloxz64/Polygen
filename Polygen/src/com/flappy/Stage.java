package com.flappy;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import com.polygen.*;

public class Stage extends BasicState{

	private Image birdImage, backgroundImage, pipeImage;
	private int x, y, gravity, score, height;
	private Font font;
	private Bird bird;
	
	@Override
	public void init(MainGame game) {
		birdImage = Main.loadImage("src/com/flappy/Bird.png");
		backgroundImage = Main.loadImage("src/com/flappy/Background.png");
		pipeImage = Main.loadImage("src/com/flappy/Pipe.png");
		font = new Font(Font.SERIF, Font.PLAIN, 40);
		bird = new Bird(birdImage);
	}

	@Override
	public void startState() {
		x = -100;
		score = 0;
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.setFont(font);
		g.drawString(String.valueOf(score), Main.getCenter(game.getScreenWidth(), g.getFontMetrics().stringWidth(String.valueOf(score))), 10);
		g.drawImage(backgroundImage, 0, 0, null);
	}

	@Override
	public void update(double delta, MainGame game) {		
		x += delta/50;
		if (x > 75){
			x -= 75;
			score++;
			height = (int) (Math.random() * 400);
			addObject(new Pipe(backgroundImage, 400, height));
			addObject(new Pipe(backgroundImage, 400, height + 600));
			
		}
	}

	@Override
	public void stopState() {
		// TODO Auto-generated method stub
		
	}

}
