package myroom;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Key implements KeyListener {
    public int event=0;
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 65) {
            System.out.println("A키가 눌렸습니다.");
            this.event = 1;
        }
        else if (e.getKeyChar() == 'c') {
            System.out.println("C 키가 눌렸습니다");
            this.event = 2;
        }

        else if (e.getKeyChar() == 't') {
            System.out.println("T 키가 눌렸다");
            this.event = 3;
        }
        else if (e.getKeyChar() == 's') {
            System.out.println("S 키가 눌렸다");
            this.event = 4;
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}