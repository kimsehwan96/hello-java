package fourthweek;

public class MainStringArrayArguments {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.print("값의 수가 부족하다");
            System.out.println("usage : $ java MainStringArrayArguments.java {number} {number_2}");
            System.exit(0);
        }

        String strNum1 = args[0];
        String strNum2 = args[1];

        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        int result = num1 + num2;

        System.out.println(num1 + " + " + num2 + " = " + result);

        
    }   
}
