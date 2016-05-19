package com.exampleGames;

import java.awt.Color;
import java.awt.Graphics;

import com.polygen.Animation;
import com.polygen.BasicState;
import com.polygen.MainGame;

public class SecondState extends BasicState{

	private int x = 0;
	Animation a;
	@Override
	public void init() {
		a = new Animation("src/com/res/HitlerRave");
		a.setSlowness(1000);
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		a.draw(g, 100, 100);
		
	}

	@Override
	public void update(double delta, MainGame game) {
		x++;
	}

	@Override
	public void stopState() {
		
	}

}
