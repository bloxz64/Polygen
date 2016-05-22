package com.exampleGames;

import java.awt.Graphics;
import com.polygen.Animation;
import com.polygen.BasicState;
import com.polygen.MainGame;

public class SecondState extends BasicState{

	private int total = 0;
	Animation a;
	@Override
	public void init() {
		a = new Animation("src/com/res/HitlerRave", 100, 100);
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		a.draw(g);
		
	}

	@Override
	public void update(double delta, MainGame game) {
		total += delta;
		a.update(delta);
		if(total > 1000){
		}
	}

	@Override
	public void stopState() {
		
	}

}
