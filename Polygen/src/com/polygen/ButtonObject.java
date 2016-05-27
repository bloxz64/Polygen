package com.polygen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.TugOfWar.Game;

/**
 * an object for creating basic buttons that can be clicked and change when they are being hovered over by the user (or not)
 * @author Owen Anderson, Christopher Lapena
 *
 */

public class ButtonObject extends GameObject{

	private boolean hovered, clicked;
	private Image inactiveImage, activeImage;
	private int x, y, width, height;
	
	/**
	 * the constructor that lets you set both tags and the base image
	 * @param tags the tags that the button will be made with
	 * @param path the path to the inactive image
	 */
	public ButtonObject(String[] tags, String path) {
		super(tags);
		inactiveImage = Game.loadImage(path);
		refreshBounds();
	}
	
	/**
	 * the constructor that just sets button as the tag and lets you set the base image
	 * @param path the path to the inactive button image
	 */
	public ButtonObject(String path){
		super(new String[]{"button"});
		inactiveImage = Game.loadImage(path);
		refreshBounds();
	}

	@Override //render the button in this method
	public void render(Graphics g, MainGame game) {
		if(hovered && activeImage != null){ 		//checks if the image has a hovered form and if not the just 
			g.drawImage(activeImage, x, y, null);	//Always draws the inactive one. if it does then if checks if
		}else{										//it's currently being hovered
			g.drawImage(inactiveImage, x, y, null);
		}
	}

	@Override
	public void update(double delta, MainGame game) { //updating stuff for the button
		if(getBounds().contains(game.getMouseX(), game.getMouseY())){ 	//checks if the mouse is over the button if it is check
			hovered = true;												//if the mouse is clicked. 
			if(game.getMouseKeyState(1)){
				clicked = true;
			}else{
				clicked = false;
			}
		}else{
			hovered = false;
			clicked = false;
		}
	}
	
	/**
	 * sets the image that will show when the user mouses over the button
	 * @param img the image
	 */
	public void setActiveImage(Image img){
		activeImage = img;
		refreshBounds();
	}
	
	/**
	 * sets the image that will show when the user mouses over the button
	 * @param path the path to the image that will be loaded
	 */
	public void setActiveImage(String path){
		activeImage = Game.loadImage(path);
		refreshBounds();
	}
	
	/**
	 * sets the image that will be shown when the user is not mousing over the button
	 * @param img the image
	 */
	public void setInactiveImage(Image img){
		inactiveImage = img;
		refreshBounds();
	}
	
	/**
	 * sets the image that will be shown when the user is not mousing over the button
	 * @param img the path to the image
	 */
	public void setInactiveImage(String path){
		inactiveImage = Game.loadImage(path);
		refreshBounds();
	}
	
	/**
	 * sets the x cord of the button
	 * @param x the x cord
	 */
	public void setX(int x){
		this.x = x;
		refreshBounds();
	}
	
	/**
	 * sets the y cord of the button
	 * @param y teh y cord
	 */
	public void setY(int y){
		this.y = y;
		refreshBounds();
	}
	
	/**
	 * returns weather the mouse is currently over the button
	 * @return true if it is false if not
	 */
	public boolean getHovered(){
		return hovered;
	}
	
	/**
	 * returns the bounds of the button
	 * @return the bounds of the button as a Rectangle
	 */
	public Rectangle getBounds(){
		return getPoly().getBounds();
	}
	
	/**
	 * refreshes the bounds of the button whenever the image is changed or the position is changed
	 */
	private void refreshBounds(){
		width = inactiveImage.getWidth(null);
		height = inactiveImage.getHeight(null);
		int[] xPoints = new int[]{x, x + width, x + width, x};
		int[] yPoints = new int[]{y, y, y + height, y + height};
		setBounds(xPoints, yPoints);
	}
	
	/**
	 * gets if the button is clicked or not
	 * @return true if it is false if not
	 */
	public boolean clicked(){
		return clicked;
	}
}
