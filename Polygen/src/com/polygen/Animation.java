package com.polygen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Animation {
	private ArrayList<Image> images = new ArrayList<Image>();
	private int frameNum = 0, slowness = 500, ticksToNextFrame;
	private Rectangle bounds;
	private boolean playing = true;
	
	/**
	 * Creates a new animation at the given path
	 * @param path the folder with the png images in them titled from 0 to however many frames there are in the gif
	 */
	public Animation(String path){
		int i = 0;
		while(true){
			try {
				images.add(ImageIO.read(new File(path + "/" + i + ".png")));
				i++;
			} catch (IOException e) {
				break;
			}
		}
		System.out.println(i + " images loaded");
	}
	
	/**
	 * draws the animation and moves the frame forward
	 * @param g the graphics object
	 * @param x the x cord
	 * @param y the y cord
	 */
	public void draw(Graphics g, int x, int y){
		g.drawImage(images.get(frameNum), x, y, null);
		System.out.println(ticksToNextFrame == 0 || !playing);
		if(ticksToNextFrame == 0 || !playing){
			if(playing){
				frameNum++;
				System.out.println("nyet");
				wrapFrameNum();
				ticksToNextFrame = slowness;
			}
		}else{
			ticksToNextFrame--;
		}
	}
	
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

	public int getSlowness() {
		return slowness;
	}

	public void setSlowness(int slowness) {
		this.slowness = slowness;
		ticksToNextFrame = slowness;
	}
}
