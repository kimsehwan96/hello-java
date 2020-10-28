package clockmodule;

public class TimeController {
    private int hh = 0;
    private int mm = 0;
    private int ss = 0;

    public Tick tick = new Tick();
    public Display display = new Display();

    private int oneDaySec = -1;

    public void loop(Key key) {
        if (tick.isPulse()) {
            oneDaySec ++;
            caculatorTime();
            display.displayTime(hh, mm, ss);
        }

        if (key.event == KeyName.HOUR) {
            oneDaySec += 3600;
            key.event = KeyName.NON;
        }
        else if (key.event == KeyName.MIN) {
            oneDaySec += 60;
            key.event = KeyName.NON;
        }
        else if (key.event == KeyName.RESET) {
            oneDaySec =0;
            key.event = KeyName.NON;
            System.out.println("Clock reset");
        }
    }

    public void oneDaySecZeroContorol() {
        if (oneDaySec > 86400) {
            oneDaySec %= 86400 ;
        }
    }

    public void caculatorTime() {
        oneDaySecZeroContorol();
        hh = oneDaySec /60 /60;
        mm = (oneDaySec /60) % 60;
        ss = oneDaySec % 60;
    }
}
