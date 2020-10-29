public class CastingTest {
    public static void main(String[] argv) {
        String str = "10";
        byte value = Byte.parseByte(str);
        System.out.println(value);

        String str1 = "200";
        short value1 = Short.parseShort(str1);
        System.out.println(value1);

        long longValue = 5000000000L;
        float floatValue = longValue;
        System.out.println(floatValue);

        // 아래는 강제 형 변환
        
        int intValue = 10;
        byte byteValue = (byte) intValue;
        System.out.println(byteValue);
        double doubleValue = 20.5643643;
        int intValue_1 = (int) doubleValue;
        System.out.println(intValue_1);

        int a = 5;
        int b = 2;
        //a / b = 2.5, 
        int c = a/b;
        double d = a / b;

        System.out.println(c);
        System.out.println(d); // 2.0 이 나온다.

        double e = (double) a / b;
        System.out.println(e); // 2.5가 출력된다. 뒤쪽 피연산자 둘 중 하나 혹은 둘다 double과 같이 변환해서 나올 형으로 지정
        
    }
}
