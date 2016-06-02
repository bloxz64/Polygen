package com.flappy;

import java.awt.Graphics;
import java.awt.Image;

import com.polygen.GameObject;
import com.polygen.MainGame;

public class Bird extends GameObject{

	private Image image;
	private int y, gravity;
	
	public Bird(Image image){
		this.image = image;
		y = 250;
		gravity = 0;
	}
	
	@Override
	public void render(Graphics g, MainGame game) {
		g.drawImage(image, 75, y, null);
		
	}
	
	public void setY(int y){
		this.y = y;		
	}

	@Override
	public void update(double delta, MainGame game) {
		y += (gravity*delta)/100d;
	}
		
}
