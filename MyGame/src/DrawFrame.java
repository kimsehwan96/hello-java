import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
public class DrawFrame extends JFrame{
    Shape[] arr = new Shape[100];
    public void paint(Graphics g){
        g.setColor(Color.red);
        for (Shape o: arr) {
            if ( o != null ) {
                g.fillRect(o.x,o.y,o.sizeX,o.sizeY); //draw square
            }
        }
    }
}
