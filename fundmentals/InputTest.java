package fundmentals;
import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        String name;

        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요");
        name = sc.next();

        System.out.println("이름은 :" + name);

    }
}
