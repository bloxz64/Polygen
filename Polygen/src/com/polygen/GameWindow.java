package com.polygen;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends Canvas{

	private static final long serialVersionUID = -6316988449972470286L;

	public GameWindow(String title, int width, int height, MainGame game){
		JFrame j = new JFrame(title);
		Dimension d = new Dimension(width, height);
		
		//setting size of window
		j.setPreferredSize(d);
		j.setMaximumSize(d);
		j.setMinimumSize(d);
		
		j.setResizable(game.isResizeable());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLocation(null);
		j.add(game);
		j.setVisible(true);
		game.start();
		
	}
}
