public class Computer extends Calculator{
    public Computer(){
        System.out.println("Computer generated !");
    }
    @Override
    public void whoAmI(){
        System.out.println("I am Computer !");
    }
    
    public void showNumber(int x) {
        System.out.println("this is computer's number" + (x*2));
    }

    public void testSuper(){
        super.whoAmI();
    } //부모클래스의 메서드를 사용하는 방법
    
    
    public static void main(String[] args){
        Computer com = new Computer();

        com.whoAmI();;
        com.showNumber(5);
        com.testSuper();
    }
}
