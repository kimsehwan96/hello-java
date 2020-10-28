package clockmodule;

import java.time.LocalTime;

public class Tick {
    public LocalTime time;

    public int pastSec;

    public Tick() {
        this.time = LocalTime.now();
        this.pastSec = time.getSecond();
    }

    public boolean isPulse() {
        this.time = LocalTime.now();
        int nowSec = time.getSecond();

        if(this.pastSec != nowSec) {
            //System.out.println(nowSec);
            this.pastSec = nowSec;
            return true;
        }
        else {
            return false;
        }
    }
    
}
