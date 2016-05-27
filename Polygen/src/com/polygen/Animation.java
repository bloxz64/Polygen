package com.polygen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * A class to make the painful process of loading and playing animation easier for the user
 * @author Owen Anderson, Christopher Lapena
 *
 */

public class Animation {
	
	//Global varibles
	private ArrayList<Image> images = new ArrayList<Image>(); //the list that will store the frames of the animation
	private int frameNum = 0, speed = 5, x, y, timeToNextFrame = 0;
	private Rectangle bounds;
	private boolean playing = true;
	
	/**
	 * Creates a new animation at the given path
	 * @param path the folder with the png images in them titled from 0 to however many frames there are in the gif (use a program like ant renamer)
	 */
	public Animation(String path, int x, int y){
		int i = 0;
		this.x = x;
		this.y = y;
		while(true){ //loads each image in the folder until it runs of of images
			try {
				images.add(ImageIO.read(new File(path + "/" + i + ".png")));
				i++;
			} catch (IOException e) {
				break;
			}
		}
		//print how many images were loaded and an error message if none were loaded
		if(images.get(0) != null){
			bounds = new Rectangle(x, y, images.get(0).getWidth(null), images.get(0).getHeight(null));
			System.out.println(i + " images loaded");
		}else{
			System.out.println("ERROR NO IMAGES LOADED");
		}
	}
	
	/**
	 * draws the current frame of the animation
	 * @param g the graphics object
	 * @param x the x cord
	 * @param y the y cord
	 */
	public void draw(Graphics g){
		g.drawImage(images.get(frameNum), x, y, null);
	}
	
	/**
	 * updates the animation using the delta for consistent timing
	 * @param delta the time between frames (used for the timing)
	 */
	public void update(double delta){
		if(timeToNextFrame <= 0 || !playing){
			if(playing){
				frameNum++;
				wrapFrameNum();
				timeToNextFrame = 1000 / speed;
			}
		}else{
			timeToNextFrame -= delta;
		}
	}
	
	/**
	 * stops the animation from playing
	 */
	public void stopAnimation(){
		playing = false;
	}
	
	/**
	 * starts the animation back up
	 */
	public void startAnimation(){
		playing = true;
	}
	
	/**
	 * checks if the animation is currently playing
	 * @return boolean value of the state of the animation true for playing false for not
	 */
	public boolean isPlaying(){
		return playing;
	}
	
	/**
	 * goes to the next frame of the animation
	 */
	public void nextFrame(){
		frameNum++;
		wrapFrameNum();
	}
	
	/**
	 * goes the previous frame of the animation
	 */
	public void previousFrame(){
		frameNum--;
		wrapFrameNum();
	}
	
	/**
	 * sets that frame of the animation
	 * @param frame the frame that it will be set to
	 */
	public void setFrame(int frame){
		frameNum = frame;
		wrapFrameNum();
	}
	
	/**
	 * gets the frame that the animation is currently on, first frame is 0
	 * @return the frames index
	 */
	public int getFrame(){
		return frameNum;
	}
	
	/**
	 * a private method for wrapping the frames in the animation to prevent array overflows
	 */
	private void wrapFrameNum(){
		while(true){
			if(frameNum < 0){
				frameNum = images.size() - frameNum;
			}else if(frameNum >= images.size()){
				frameNum -= frameNum;
			}else{
				break;
			}
		}
	}

	/**
	 * gets the speed that the animation is playing at in FPS
	 * @return the speed of the animation
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * sets the speed of the animation in FPS
	 * @param speed the speed that the animation will play at
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
		timeToNextFrame = 1000 / speed;
	}

	/**
	 * the bounds of the animation's first frame
	 * @return a rectangle of the bounds
	 */
	public Rectangle getBounds() {
		return bounds;
	}
}
