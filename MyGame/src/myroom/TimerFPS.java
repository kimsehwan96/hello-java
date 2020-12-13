package myroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerFPS implements ActionListener {
    DrawFrame f;

    TimerFPS(DrawFrame f) {
        this.f = f;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(Shape o : f.arr){
            if (o != null) {
                o.moveShape();
                if(o.whoIs()==3){
                    Triangle t = (Triangle) o;
                    t.drawLineDataSet();
                }
                if(o.whoIs()==4) {
                    Star s = (Star) o;
                    s.drawLineDataSet();
                }
            }
        }
        f.repaint();
    }
}
