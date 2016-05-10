package com.polygen;

import java.awt.Polygon;

public abstract class GameObject {
	private String[] tags;
	private Polygon poly;
	private double[] cords;
	private int angle;
	
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	public abstract void render();
	
	public abstract void update();
	
	public void setBounds(int[] xValues, int[] yValues){
		this.poly = new Polygon(xValues, yValues, xValues.length);
	}
	public Polygon getPoly(){
		return poly;
	}
	
	public void setAngle(int angle){
		this.angle = angle%360;
	}
	public void changeAngle(int deltaAngle){
		angle += deltaAngle;
		angle %= 360;
	}
	public int getAngle(){
		return angle;
	}
	
	public void setPos(double x, double y){
		cords = new double[]{x, y};
	}
	public void move(double deltaX, double deltaY){
		cords[0] += deltaX;
		cords[1] += deltaY;
	}
	public void moveInDir(int distance, int angle){
		cords[0] += distance * Math.cos(angle);
		cords[1] += distance * Math.sin(angle);
	}
	
	public boolean isTouching(GameObject against){
		//TEMPERORY CODE
		//TODO replace with edge intersection detection
		return poly.intersects(against.getPoly().getBounds2D());
	}
}
