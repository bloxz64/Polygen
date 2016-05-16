package com.exampleGames;

import java.awt.Color;
import java.awt.Graphics;

import com.polygen.BasicState;
import com.polygen.MainGame;

public class SecondState extends BasicState{

	private int x = 0;
	@Override
	public void init() {
		
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.setColor(Color.BLACK);
		g.fillRect(x, 100, 100, 200);
		g.setColor(Color.BLUE);
		g.fillRect(100, x, 200, 100);
		
	}

	@Override
	public void update(double delta, MainGame game) {
		x++;
	}

	@Override
	public void stopState() {
		
	}

}
