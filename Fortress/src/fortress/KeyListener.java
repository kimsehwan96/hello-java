package fortress;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyListener extends KeyAdapter{
    @Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W :
            Fortress.game.true_Up();
				break;
			case KeyEvent.VK_S :
            Fortress.game.true_Down();
				break;
			case KeyEvent.VK_A :
            Fortress.game.true_Left();
				break;
			case KeyEvent.VK_D :
            Fortress.game.true_Right();
				break;
			case KeyEvent.VK_SPACE :
            Fortress.game.true_Shooting();
				break;
		}
    }
    
    @Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W :
            Fortress.game.false_Up();
				break;
			case KeyEvent.VK_S :
            Fortress.game.false_Down();
				break;
			case KeyEvent.VK_A :
            Fortress.game.false_Left();
				break;
			case KeyEvent.VK_D :
            Fortress.game.false_Right();
				break;
			case KeyEvent.VK_SPACE :
            Fortress.game.false_Shooting();
				break;
		}
	}
}
