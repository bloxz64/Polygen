package com.flappy;

import java.awt.Graphics;
import java.awt.Image;

import com.TugOfWar.Game;
import com.polygen.*;

public class Pipe extends GameObject{
	
	public Pipe(Image image, int x, int y){
		super(new String[] {"pipe", "touch"});
		setBounds(new int[] {0, 0, 25, 25}, new int[] {0, 100, 100, 0});
		setSprite(image);
		setPos(x, y);
	}
	
	@Override
	public void render(Graphics g, MainGame game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double delta, MainGame game) {
		move((int) (delta/50), 0);
		
	}

}
