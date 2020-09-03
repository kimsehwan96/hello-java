package fundmentals;

public class LoginDemo2 {
    public static void main(String[] args){
        String id = args[0];
        String password = args[1];
        if (id.equals("gimsehwan") && password.equals("1234")) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }
    
}
