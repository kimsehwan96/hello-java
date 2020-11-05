public class Computer extends Calculator{
    @Override
    public void whoAmI(){
        System.out.println("I am Computer !");
    }
    
    public void showNumber(int x) {
        System.out.println("this is computer's number" + (x*2));
    }
    
    
    public static void main(String[] args){
        Computer com = new Computer();

        com.whoAmI();;
        com.showNumber(5);
    }
}
