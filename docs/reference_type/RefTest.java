public class RefTest {
    public static void main(String[] args){
        String text = "Hello";
        String a = "Hello";
        String b = a;
        String c = new String("Hello");
        System.out.println((text == a));
        System.out.println(a == b);
        System.out.println(text == c);
        System.out.println(text.equals(c));
    }    
}
