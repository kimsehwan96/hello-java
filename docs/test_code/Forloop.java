import java.util.Scanner;

public class Forloop {
    public static void main(String[] argsv){
        int a = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        for (; true;){
            a = Integer.parseInt(sc.nextLine());
            if (a == -1){
                break;
            }
            sum += a;
            System.out.println(sum);
        }
    }
    
}
