package clockmodule;

public class Display {
    public void displayTime(int hh, int mm, int ss) {
        System.out.printf("%02d : %02d : %02d\r", hh, mm, ss);
    }
}
