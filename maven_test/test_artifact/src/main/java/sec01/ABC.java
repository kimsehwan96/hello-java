package sec01;

interface Inter {
    public void interMethod(); //abastact method
}

public class ABC implements Inter{
    public void interMethod(){
        System.out.println("this is abstract method's override !!");
    };

    public static void main(String[] args) {
        ABC a = new ABC();
        a.interMethod();
    }
}
