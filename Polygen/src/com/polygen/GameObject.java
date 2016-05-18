  package com.polygen;

import java.awt.Graphics;
import java.awt.Polygon;

public abstract class GameObject {
	private String[] tags;
	private Polygon poly;
	private int angle;
	private int a, b, c, A, B, C, x, y;
	
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	public abstract void render(Graphics g, MainGame game);
	
	public abstract void update(double delta, MainGame game);
	
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
	
	public boolean isTouching(GameObject against){
		if (poly.getBounds().intersects(against.getPoly().getBounds())){
			for (int is = 0; is < poly.npoints; is++){
				for (int isnt = 0; isnt < against.getPoly().npoints; isnt++){
					a = poly.ypoints[is] - poly.ypoints[is+1];
					b = poly.xpoints[is+1] - poly.xpoints[is];
					c = (a * poly.xpoints[is]) + (b * poly.ypoints[is]);
					A = against.getPoly().ypoints[is] - against.getPoly().ypoints[is+1];
					B = against.getPoly().xpoints[is+1] - against.getPoly().xpoints[is];
					C = (A * against.getPoly().xpoints[is]) + (B * against.getPoly().ypoints[is]);
					
					x = ((c * B) - (C * b))/((a * B) - (A * b));
					y = ((a * C) - (A * c))/((a * B) - (A * b));
					
					if ((x > poly.xpoints[is] && x < poly.xpoints[is+1]) || (x < poly.xpoints[is] && x > poly.xpoints[is+1])){
						if ((y > poly.ypoints[is] && y < poly.ypoints[is+1]) || (y < poly.ypoints[is] && y > poly.ypoints[is+1])){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
