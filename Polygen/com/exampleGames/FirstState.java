package com.exampleGames;

import java.awt.Graphics;

import com.polygen.Animation;
import com.polygen.BasicState;
import com.polygen.MainGame;

public class FirstState extends BasicState{

	
	int test = 0;
	@Override
	public void init(MainGame game) {
		
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		
	}

	@Override
	public void update(double delta, MainGame game) {
		test++;
		if(test > 60){
			game.switchState(1);
		}else{
			//System.out.println(test);
		}
	}

	@Override
	public void stopState() {
		
	}

}
