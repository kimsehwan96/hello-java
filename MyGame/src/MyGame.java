import javax.swing.*;

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

        while(true) {
            Thread.sleep(100);
            if(key.event ==1) {
                f.arr[count] = new Shape((int)(Math.random()*450), (int)(Math.random()*450), 50, 50);
                count++;
                f.repaint();
                key.event = 0;
            }
        }
    }
}