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
	 * @param path the folder with the png images in them titled from 0 to however many frames there are in the gif
	 */
	public Animation(String path, int x, int y){
		int i = 0;
		this.x = x;
		this.y = y;
		while(true){
			try {
				images.add(ImageIO.read(new File(path + "/" + i + ".png")));
				i++;
			} catch (IOException e) {
				break;
			}
		}
		if(images.get(0) != null){
			bounds = new Rectangle(x, y, images.get(0).getWidth(null), images.get(0).getHeight(null));
			System.out.println(i + " images loaded");
		}else{
			System.out.println("ERROR NO IMAGES LOADED");
		}
	}
	
	/**
	 * draws the animation and moves the frame forward
	 * @param g the graphics object
	 * @param x the x cord
	 * @param y the y cord
	 */
	public void draw(Graphics g){
		g.drawImage(images.get(frameNum), x, y, null);
	}
	
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
	
	public void startAnimation(){
		playing = true;
	}
	
	public boolean isPlaying(){
		return playing;
	}
	
	public void nextFrame(){
		frameNum++;
		wrapFrameNum();
	}
	
	public void previousFrame(){
		frameNum--;
		wrapFrameNum();
	}
	
	public void setFrame(int frame){
		frameNum = frame;
		wrapFrameNum();
	}
	
	public int getFrame(){
		return frameNum;
	}
	
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int slowness) {
		this.speed = slowness;
		timeToNextFrame = 1000 / speed;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
