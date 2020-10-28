package clockmodule;

import javax.swing.*;

public class Clock {
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout( null );

        Key key = new Key();

        f.setVisible( true );
        f.addKeyListener(key);

        TimeController tc = new TimeController();

        while ( true ) {
            tc.loop(key);
            if (key.event == KeyName.ESC) {
                System.out.println("종료");
                System.exit(0);
            }
        }
    }
}
