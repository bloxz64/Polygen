package com.polygen;

public abstract class GameObject {
	private String[] tags;
	private Polygon poly;
	
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
	
	public boolean isTouching(GameObject against){
		//TEMPERORY CODE
		//TODO replace with edge intersection detection
		return poly.intersects(against.getPoly().getBounds2D());
	}
}
