package com.exampleGames;

public class renderTest {

	public static void main(String[] args) {
		Polygen.setupWindow(500, 500);
		
		update(){
			onAll(move(1,0), "player");
		}
		
		checkStatuses(){
			onAll(isTouching);
		}
		
		while (true){
			draw();
			update()
			checkStatuses();
			amendUpdate();
			
		}

	}

}
