package week_4;

public class Test {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.show_current_status();
        //cal.add(10,20);
        //cal.add(20.2, 50.0);
        //cal.add(30,100);

        double x;
        double y;
        double result;
        x = 20;
        y = 30;
        result = x + y;
        System.out.println(result);
        cal.plus(1,20.3, 40212.2, 3, 1);
        
    }
    
}
