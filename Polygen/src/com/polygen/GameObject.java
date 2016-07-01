  package com.polygen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;

/**
 * a method for the skeleton for all the other objects that can be added to the state
 * @author Owen Anderson, Christopher Lapena
 *
 */

public abstract class GameObject {
	
	private String[] tags;
	private Polygon poly;
	private int angle, spriteAngle;
	private Point center;
	private Image sprite;
	
	/**
	 * a method that lets you check collision without calling it on an object
	 * @param obj1 first object
	 * @param obj2 second object
	 * @return true if they are colliding false if not
	 */
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
	
	/**
	 * creates the object with a set list of tags
	 * @param tags the tags to be added
	 */
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	/**
	 * empty constructor that creates an empty list of tags
	 */
	public GameObject(){
		this.tags = new String[0];
	}
	
	/**
	 * checks if the object has a given tag in it
	 * @param tag the tag that will be checked for
	 * @return true if tag was found false if not
	 */
	public boolean hasTag(String tag){
		for (String i : tags){
			if (i.equals(tag)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * the render method that the children of this class can change
	 * @param g the graphics object used for drawing
	 * @param game the game object 
	 */
	public abstract void render(Graphics g, MainGame game);
	
	/**
	 * the update method that the children of this class can change
	 * @param delta the time since last frame
	 * @param game the game object
	 */
	public abstract void update(double delta, MainGame game);
	
	public void backEndUpdate(double delta, MainGame game){
		updateSpriteRotation();
		update(delta, game);
	}
	
	/**
	 * sets the bounds of the object as a set of points
	 * @param xValues the x values for all the points
	 * @param yValues the y values for all the points
	 */
	public void setBounds(int[] xValues, int[] yValues){
		poly = new Polygon(xValues, yValues, xValues.length);
		poly.addPoint(xValues[0], yValues[0]);
	}
	
	/**
	 * gets the polygon that represents the bounds of the object
	 * @return the polygon
	 */
	public Polygon getPoly(){
		return poly;
	}
	
	/**
	 * sets the angle that the polygon is rotated at
	 * @param angle the angle of said polygon
	 */
	public void setAngle(int angle){
		this.angle = wrapAngle(angle);
		rotatePolygon();
	}
	
	/**
	 * changes the angle by a given amount
	 * @param deltaAngle the change in angle
	 */
	public void changeAngle(int deltaAngle){
		angle += deltaAngle;
		angle = wrapAngle(angle);
		rotatePolygon();
	}
	
	/**
	 * wraps the angle to make sure that it remains above or equal to 0 and less than 360
	 * @param angle the angle that will be wrapped
	 * @return the angle post wrap
	 */
	private int wrapAngle(int angle) {
		angle %= 360;
		if(angle < 0){
			angle += 360;
		}
		return angle;
	}

	/**
	 * gets the angle that the object's bounding box is rotated by
	 * @return angle as an int
	 */
	public int getAngle(){
		return angle;
	}
	
	/**
	 * rotates the polygon to the new angle 
	 */
	private void rotatePolygon(){
		if(center == null){ //find center of polygon
			center = getCentroid();
		}
		Polygon newPoly = new Polygon();
		for(int i = 0; i < poly.npoints; i++){ //rotates each point using MATHS
			int newX = (int) ((poly.xpoints[i] * Math.cos(angle)) - (poly.ypoints[i] * Math.sin(angle)));
			int newY = (int) ((poly.xpoints[i] * Math.sin(angle)) + (poly.ypoints[i] * Math.cos(angle)));
			newPoly.addPoint(newX, newY);
		}
		poly = newPoly;
	}
	
	/**
	 * lets you set the position of the polygon
	 * @param x the x cord to set to
	 * @param y the y cord to set to
	 */
	public void setPos(int x, int y){
		poly.translate(x - poly.xpoints[1], y - poly.ypoints[1]);
	}
	
	/**
	 * gets the top left corner of the bounding box's x cord
	 * @return 
	 */
	public double getX(){
		return poly.getBounds().getX();
	}
	
	/**
	 * gets the top left corner of the bounding box's y cord
	 * @return
	 * 
	 */
	public double getY(){
		return poly.getBounds().getY();
	}
	
	/**
	 * gets the width of the bounding box
	 * @return
	 */
	public double getWidth(){
		return poly.getBounds().getWidth();
	}
	
	/**
	 * gets the height of the bounding box
	 * @return
	 */
	public double getHeight(){
		return poly.getBounds().getWidth();
	}
	
	/**
	 * moves the entire polygon bounding box 
	 * @param deltaX the amount to shift it on the x axis
	 * @param deltaY the amount to shit it on the y axis
	 */
	public void move(int deltaX, int deltaY){
		poly.translate(deltaX, deltaY);
	}
	
	/**
	 * moves the entire bounding box along a given angle for a certain distance
	 * @param distance the distance to be moved
	 * @param angle the angle that it will be moved at
	 */
	public void moveInDir(double distance, int angle){
		poly.translate((int)(distance * Math.cos(angle)), (int)(distance * Math.sin(angle)));
	}
	
	/**
	 * checks if the object is touching another given object
	 * @param against the object that will be checked for collision
	 * @return true if it's touching false if not
	 */
	public boolean isTouching(GameObject against){
		return GameObject.checkCollision(this, against);
	}
	
	/**
	 * gets the centroid center of the polygon
	 * @return the centroid as a Point object
	 */
	public Point getCentroid(){
		Point centroid = new Point();
		
		for(int i = 0; i < poly.npoints; i++){
			centroid.translate(poly.xpoints[i], poly.ypoints[i]);
		}
		centroid.setLocation(centroid.x / poly.npoints, centroid.y / poly.npoints);
		return centroid;
	}

	/**
	 * gives the center of the object as the user set it and if none has been set that just the centroid
	 * @return the center as a point object
	 */
	public Point getCenter() {
		if(center == null){
			center = getCentroid();
		}
		return center;
	}
	
	/**
	 * sets the center of the object (user mainly for rotation)
	 * @param center the center as a point object
	 */
	public void setCenter(Point center) {
		this.center = center;
	}
	
	/**
	 * gets the list of tags that the object has
	 * @return the list of tags
	 */
	public String[] getTags(){
		return tags;
	}
// add documentation
	public void setTags(String[] tags){
		this.tags = tags;
	}
	
	/*
	 * please tell me this works
	 */
	public void addTag(String tag){
		String temp[] = new String[tags.length + 1];
		temp[temp.length - 1] = tag;
		tags = temp;
	}
	
	/**
	 * sets the objects sprite
	 * @param sprite the sprite that will be set
	 */
	public void setSprite(Image sprite){
		this.sprite = sprite;
	}
	
	/**
	 * gets the sprite from this object
	 * @return the sprite as an image object
	 */
	public Image getSprite() {
		return this.sprite;
	}
	
	public void setSpriteAngle(int newAngle){
		spriteAngle = newAngle;
	}
	
	public void changeSpriteAngle(int deltaAngle) {
		spriteAngle += deltaAngle;
	}
	
	public int getSpriteAngle() {
		return spriteAngle;
	}
	
	private void updateSpriteRotation() {
		
	}
}
