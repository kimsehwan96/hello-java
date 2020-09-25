package thirdweek;

public class forTest {
    public static void main(String args []){
        int sum = 0;
        for (int i=1; i<=100; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        boolean a = false;
        boolean b = false;
        boolean OR, AND, NOT ;
        OR = a | b; // or
        AND = a & b;
        NOT = a^b;
        System.out.println(OR);
        System.out.println(AND);
        System.out.println(NOT);

    }
    
}
