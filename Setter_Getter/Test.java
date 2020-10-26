public class Test {
    public static void main(String[] args) {
        SetterGetter cls = new SetterGetter();
        cls.setSpeed(60.0);
        cls.showSpeed();
        cls.setSpeed(-5);
        cls.showSpeed();
        cls.setSpeed(100);

        System.out.println(cls.getSpeed());
    }
}
