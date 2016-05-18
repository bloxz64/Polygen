package com.polygen;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Animation {
	ArrayList<Image> images = new ArrayList<Image>();
	int frameNum = 0, speed = 0;
	boolean playing = true;
	
	/**
	 * 
	 * @param path
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
		if(playing){
			frameNum++;
			wrapFrameNum();
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
			}else if(frameNum > 0){
				frameNum -= frameNum;
			}else{
				break;
			}
		}
	}
}
