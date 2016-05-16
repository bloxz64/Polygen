package com.exampleGames;

import java.awt.Graphics;

import com.polygen.BasicState;
import com.polygen.MainGame;

public class FirstState extends BasicState{

	
	int test = 0;
	@Override
	public void init() {
		
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		g.fillRect(100, 100, 100, 100);
	}

	@Override
	public void update(double delta, MainGame game) {
		test++;
		if(test > 100){
			game.switchState(1);
		}else{
			System.out.println(test);
		}
	}

	@Override
	public void stopState() {
		
	}

}
