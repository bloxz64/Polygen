package com.polygen;

public abstract class GameObject {
	private String[] tags;
	
	public GameObject(String[] tags){
		this.tags = tags;
	}
	
	public abstract void render();
	
	public abstract void update();
}
