import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Key implements KeyListener{
    public int event=0;
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 65) {
            System.out.println("A키가 눌렸습니다.");
            this.event = 1;
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }

}
