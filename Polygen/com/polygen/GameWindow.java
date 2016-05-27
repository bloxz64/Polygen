package com.polygen;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends Canvas{

	private static final long serialVersionUID = -6316988449972470286L;
	
	private JFrame j;

	public GameWindow(String title, int width, int height, MainGame game){
		j = new JFrame(title);
		Dimension d = new Dimension(width, height);
		
		//setting size of window
		j.setPreferredSize(d);
		j.setMaximumSize(d);
		j.setMinimumSize(d);
		
		j.setResizable(game.isResizeable());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLocationRelativeTo(null);
		j.add(game);
		j.setVisible(true);
		game.start();
		
	}
	
	public JFrame getFrame(){
		return j;
	}
}
