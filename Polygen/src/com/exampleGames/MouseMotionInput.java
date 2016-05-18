package shimmy568.gmail.com.FirstGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotionInput extends MouseMotionAdapter{

	public void mouseMoved(MouseEvent e) {
		Game.game.setMouseX(e.getX());
		Game.game.setMouseY(e.getY());
	}
	
	public void mouseDragged(MouseEvent e){
		Game.game.setMouseX(e.getX());
		Game.game.setMouseY(e.getY());
	}

}
