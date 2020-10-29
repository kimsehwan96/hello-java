public class Singleton {
    private static Singleton singleton = new Singleton();
    // 정적 필드에 Singleton 생성자를 이용해서 singleton 객체를 한번 생성한다

    private Singleton() {};
    // 생성자는 외부 접근이 불가능하게 private 으로 접근제한한다

    static Singleton getInstance() {
        return singleton;
    }
    // 스태틱 메서드로 유일한 인스턴스를 리턴하는 스태틱 메서드를 작성한다.
    //static 리턴타입(싱글턴 객체의 타입이 리턴) getInstance 메서드 이름

    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        if (a == b) {
            System.out.println("같은 인스턴스");
        }
        else {
            System.out.println("다른 인스턴스");
        }
    }
}
