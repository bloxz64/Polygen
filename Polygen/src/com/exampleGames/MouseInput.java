package shimmy568.gmail.com.FirstGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1){
			Game.game.setM1(true);
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == 1){
			Game.game.setM1(false);
		}
	}

}
