package myroom;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
public class DrawFrame extends JFrame {
    Shape[] arr = new Shape[100];
    public void paint(Graphics g) {
        g.setColor(Color.red);
        for (Shape o: arr) {
            if ( o != null ) {
                if (o.whoIs() == 1) {
                    g.fillRect(o.x,o.y,o.sizeX,o.sizeY); //draw square
                }
                else if (o.whoIs() == 2) {
                    g.fillOval(o.x, o.y, o.sizeX, o.sizeY);
                }

                else if (o.whoIs() == 3) {
                    Triangle t = (Triangle)o;
                    for(int i = 0; i<t.lineVolume; i++) {
                        g.drawLine(
                        t.dataSet[0+(i*4)],
                        t.dataSet[1+(i*4)],
                        t.dataSet[2+(i*4)],
                        t.dataSet[3+(i*4)]);
                    }
                }
                else if (o.whoIs() == 4) {
                    Star s = (Star)o;
                    for(int i = 0; i<s.lineVolume; i++) {
                        g.drawLine(
                        s.dataSet[0+(i*4)],
                        s.dataSet[1+(i*4)],
                        s.dataSet[2+(i*4)],
                        s.dataSet[3+(i*4)]);
                    }
                }
            }
        }
    }
}
