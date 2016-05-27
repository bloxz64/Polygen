package com.TugOfWar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.polygen.BasicState;
import com.polygen.MainGame;

public class PlayGame extends BasicState{

	private Image tug, yay;
	private int x = 0, timer = 3000;
	private boolean capsPressed, enterPressed, gameOver;
	private String victoryText;
	private Font victoryFont;
	
	@Override
	public void init(MainGame game) {
		tug = Game.loadImage("src/com/TugOfWar/TugOfWar.png");
		yay = Game.loadImage("src/com/TugOfWar/YAY.png");
		victoryFont = new Font(Font.SERIF, Font.BOLD, 50);
	}

	@Override
	public void startState() {
		
	}

	@Override
	public void render(Graphics g, MainGame game) {
		if(gameOver){
			g.drawString(victoryText, Game.getCenter(game.getWidth(), g.getFontMetrics().stringWidth(victoryText)), 50);
			g.drawImage(yay, Game.getCenter(game.getScreenWidth(), yay.getWidth(null)), 100, null);
		}else{
			g.setFont(victoryFont);
			g.drawImage(tug, x, Game.getCenter(game.getScreenHeight(), tug.getHeight(null)), null);
			g.setColor(Color.RED);
			g.drawLine(250, 0, 250, game.getScreenHeight());
			g.setColor(Color.BLUE);
			g.drawLine(750, 0, 750, game.getScreenHeight());
			if(timer > 0){
				g.setColor(Color.BLACK);
				g.drawString(String.valueOf((int) (timer / 1000)), Game.getCenter(game.getScreenWidth(), g.getFontMetrics().stringWidth(String.valueOf((int) (timer / 1000)))), 100);
			}
		}
		
	}

	@Override
	public void update(double delta, MainGame game) {
		if(!gameOver){
			if(timer > 0){
				timer -= delta;
				return;
			}
			checkWin();
			if(game.getKeyPressed(KeyEvent.VK_CAPS_LOCK) && !capsPressed){
				x -= 5;
				capsPressed = true;
			}else if(!game.getKeyPressed(KeyEvent.VK_CAPS_LOCK)){
				capsPressed = false;
			}
			
			if(game.getKeyPressed(KeyEvent.VK_ENTER) && !enterPressed){
				x += 5;
				enterPressed = true;
			}else if(!game.getKeyPressed(KeyEvent.VK_ENTER)){
				enterPressed = false;
			}
		}
	}

	private void checkWin() {
		if(x < -250){
			player1Win();
			return;
		}
		
		if(x > 250){
			player2Win();
		}
		
	}

	private void player1Win() {
		victoryText = "Player One WINS!";
		gameOver = true;
	}

	private void player2Win() {
		victoryText = "Player Two WINS!";
		gameOver = true;
	}

	@Override
	public void stopState() {
		
	}

}
