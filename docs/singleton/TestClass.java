public class TestClass {
    private static TestClass singleton = new TestClass();

    private TestClass () {};

    static TestClass getInstance() {
        return singleton;
    }

    public static void main(String[] args){
        TestClass a = TestClass.getInstance();
        TestClass b = TestClass.getInstance();

        if(a == b) {
            System.out.println("같은 인스턴스");
        }
        else {
            System.out.println("다른 인스턴스");
        }
    }
}
