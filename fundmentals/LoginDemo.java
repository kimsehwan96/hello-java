package fundmentals;

public class LoginDemo {
    public static void main(String[] args) {
        String id = args[0];
        System.out.println("this is your args" + args[0]);
        if(id.equals("gimsehwan")){
            System.out.println("success to login");
        } else {
            System.out.println("failed to login");
        }
    }
}
