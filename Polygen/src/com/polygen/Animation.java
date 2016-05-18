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
	
	public void draw(Graphics g, int x, int y){
		g.drawImage(images.get(frameNum), x, y, null);
		if(playing){
			
		}
	}
}
