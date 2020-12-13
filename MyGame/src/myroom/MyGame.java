package myroom;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyGame {
    public static void main(String[] args) throws InterruptedException {
        DrawFrame f = new DrawFrame();//클래스 타입변환
        Key key = new Key();
        f.setLayout( null );
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible( true );
        f.addKeyListener(key);

        int count = 0;
        ActionListener listener = new TimerFPS(f);
        Timer t = new Timer(100, listener);//0.1sec
        t.restart();

        while(true) {
            Thread.sleep(100);
            if(key.event ==1) {
                f.arr[count] = new Rectangle( 
                    (int)(Math.random()*450), 
                    (int)(Math.random()*450), 
                    (int)(Math.random()*30)+20, 
                    (int)(Math.random()*30)+20);
                count++;
                f.repaint();
                key.event = 0;
            }
            if (key.event ==2){
                f.arr[count] = new Cycle(
                    (int)(Math.random()*450), 
                    (int)(Math.random()*450), 
                    (int)(Math.random()*30)+20, 
                    (int)(Math.random()*30)+20);
                count++;
                f.repaint();
                key.event = 0;
            }
            if (key.event == 3 ){
                f.arr[count] = new Triangle(
                    (int)(Math.random()*450), 
                    (int)(Math.random()*450), 
                    (int)(Math.random()*30)+20, 
                    (int)(Math.random()*30)+20);
                count++;
                f.repaint();
                key.event = 0;
            }
            if (key.event == 4 ){
                f.arr[count] = new Star(
                    (int)(Math.random()*450), 
                    (int)(Math.random()*450), 
                    (int)(Math.random()*30)+20, 
                    (int)(Math.random()*30)+20);
                count++;
                f.repaint();
                key.event = 0;
            }
        }
    }
}
