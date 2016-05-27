  package com.polygen;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import com.TugOfWar.Game;

public abstract class GameObject {
	private String[] tags;
	private Polygon poly;
	private int angle;
	private Point center;
	
	public static boolean checkCollision(GameObject obj1, GameObject obj2){
		if (obj1.getPoly().getBounds().intersects(obj2.getPoly().getBounds())){
			for (int is = 0; is < obj1.getPoly().npoints; is++){
				for (int isnt = 0; isnt < obj2.getPoly().npoints; isnt++){
					int a = obj1.getPoly().ypoints[is] - obj1.getPoly().ypoints[is+1];
					int b = obj1.getPoly().xpoints[is+1] - obj1.getPoly().xpoints[is];
					int c = (a * obj1.getPoly().xpoints[is]) + (b * obj1.getPoly().ypoints[is]);
					int A = obj2.getPoly().ypoints[is] - obj2.getPoly().ypoints[is+1];
					int B = obj2.getPoly().xpoints[is+1] - obj2.getPoly().xpoints[is];
					int C = (A * obj2.getPoly().xpoints[is]) + (B * obj2.getPoly().ypoints[is]);
					
					int x = ((c * B) - (C * b))/((a * B) - (A * b));
					int y = ((a * C) - (A * c))/((a * B) - (A * b));
					
					if ((x > obj1.getPoly().xpoints[is] && x < obj1.getPoly().xpoints[is+1]) || (x < obj1.getPoly().xpoints[is] && x > obj1.getPoly().xpoints[is+1])){
						if ((y > obj1.getPoly().ypoints[is] && y < obj1.getPoly().ypoints[is+1]) || (y < obj1.getPoly().ypoints[is] && y > obj1.getPoly().ypoints[is+1])){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	public GameObject(){
		
	}
	
	public boolean hasTag(String tag){
		for (String i : tags){
			if (i.equals(tag)){
				return true;
			}
		}
		return false;
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
		this.angle = wrapAngle(angle);
		rotatePolygon();
	}
	
	public void changeAngle(int deltaAngle){
		angle += deltaAngle;
		angle = wrapAngle(angle);
		rotatePolygon();
	}
	
	private int wrapAngle(int angle) {
		angle %= 360;
		if(angle < 0){
			angle += 360;
		}
		return angle;
	}

	public int getAngle(){
		return angle;
	}
	
	private void rotatePolygon(){
		if(center == null){ //find center of polygon
			center = getCentroid();
		}
		Polygon newPoly = new Polygon();
		for(int i = 0; i < poly.npoints; i++){
			int newX = (int) ((poly.xpoints[i] * Math.cos(angle)) - (poly.ypoints[i] * Math.sin(angle)));
			int newY = (int) ((poly.xpoints[i] * Math.sin(angle)) + (poly.ypoints[i] * Math.cos(angle)));
			newPoly.addPoint(newX, newY);
		}
		poly = newPoly;
	}
	
	public void setPos(int x, int y){
		poly.translate(x - poly.xpoints[1], y - poly.ypoints[1]);
	}
	
	public double getX(){
		return poly.getBounds().getX();
	}
	
	public double getY(){
		return poly.getBounds().getY();
	}
	
	public double getWidth(){
		return poly.getBounds().getWidth();
	}
	
	public double getHeight(){
		return poly.getBounds().getWidth();
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
					int a = poly.ypoints[is] - poly.ypoints[is+1];
					int b = poly.xpoints[is+1] - poly.xpoints[is];
					int c = (a * poly.xpoints[is]) + (b * poly.ypoints[is]);
					int A = against.getPoly().ypoints[is] - against.getPoly().ypoints[is+1];
					int B = against.getPoly().xpoints[is+1] - against.getPoly().xpoints[is];
					int C = (A * against.getPoly().xpoints[is]) + (B * against.getPoly().ypoints[is]);
					
					int x = ((c * B) - (C * b))/((a * B) - (A * b));
					int y = ((a * C) - (A * c))/((a * B) - (A * b));
					
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
	
	public Point getCentroid(){
		Point centroid = new Point();
		
		for(int i = 0; i < poly.npoints; i++){
			centroid.translate(poly.xpoints[i], poly.ypoints[i]);
		}
		centroid.setLocation(centroid.x / poly.npoints, centroid.y / poly.npoints);
		return centroid;
	}

	public Point getCenter() {
		if(center == null){
			center = getCentroid();
		}
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	public String[] getTags(){
		return tags;
	}
}
