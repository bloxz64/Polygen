package com.polygen;

public abstract class GameObject {
	private String[] tags;
	private Polygon bounds;
	
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	public abstract void render();
	
	public abstract void update();
	
	public void setBounds(int[][] bounds){
		this.bounds = Polygon();
		
	}
	
	public boolean isTouching(GameObject against){
		
		
	}
}
