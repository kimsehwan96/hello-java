package clockmodule;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Key implements KeyListener{
    public KeyName event;
    public int code;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            event = KeyName.ESC;
        }
        else if (e.getKeyCode() == 37 ) { //방향키 왼쪽키
            event = KeyName.HOUR;
        }
        else if (e.getKeyCode() == 39 ) { // 방향키 오른쪽
            event = KeyName.MIN;
        }
        else if (e.getKeyCode() == 40 ) { // 방향키 아래쪽
            event = KeyName.RESET;
        }
        //else {
        //    code = e.getKeyCode();
        //   System.out.println(code);
        //}
    }
    public void keyReleased(KeyEvent e){ }
    public void keyTyped(KeyEvent e) { }
}
