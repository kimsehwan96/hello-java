package week_4;

public class Test {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
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
        //cal.plus(1,20.3, 40212.2, 3, 1);
        cal.devide(10.0, 2.0);
        cal.devide(2.0);
        cal.reset();
        cal.multiply(1.0, 2.0, 3, 4); //expect 24.0
        cal.multiply(2.0); // expect 48.0
        cal.multiply(2); // exepct 96.0
        cal.devide(2); //expect 48.0
    }
    
}
