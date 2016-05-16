  package com.polygen;

import java.awt.Polygon;

public abstract class GameObject {
	private String[] tags;
	private Polygon poly;
	private int angle;
	
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	public abstract void render();
	
	public abstract void update();
	
	public void setBounds(int[] xValues, int[] yValues){
		poly = new Polygon(xValues, yValues, xValues.length);
		poly.addPoint(xValues[0], yValues[0]);
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
	
	public void setPos(int x, int y){
		poly.translate(x - poly.xpoints[1], y - poly.ypoints[1]);
	}
	public void move(int deltaX, int deltaY){
		poly.translate(deltaX, deltaY);
	}
	public void moveInDir(double distance, int angle){
		poly.translate((int)(distance * Math.cos(angle)), (int)(distance * Math.sin(angle)));
	}
	
	private boolean outside(int inMin, int inMax, int outMin, int outMax){
		if (inMin > outMax || outMin > inMax)){
			return true;
		}
		else if (){
			against.getPoly().getBounds().getMaxX()
		}
		return false;
	}
	
	public boolean isTouching(GameObject against){
		for (int is = 0; is < poly.npoints; is++){
			for (int isnt = 0; isnt < against.getPoly().npoints; isnt++){
				if (poly.getBounds().getMinX() > against.getPoly().getBounds().getMaxX() || against.getPoly().getBounds().getMinX() > poly.getBounds().getMaxX() 
					|| poly.getBounds().getMinY() > against.getPoly().getBounds().getMaxY() || against.getPoly().getBounds().getMinY() > poly.getBounds().getMaxY()){
					
				}
			}
		}
	}
}
