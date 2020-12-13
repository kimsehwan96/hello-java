# java 반복문 테스트

```java
public class LoopTest {
    public static int forTest(){
        int idx = 0;
        int sum = 0;
        for(idx = 0; idx <= 100; idx ++){
            sum += idx;
        }
        return sum;
    }
    public static int whileTest(){
        int idx = 0;
        int sum = 0;
        while(idx <= 100){
            sum += idx;
            idx++;
        }
        return sum;
    }
    public static int doWhileTest(){
        int idx = 0;
        int sum = 0;
        do {
            sum += idx;
            idx ++;
        } while(idx <= 100);
        return sum;
    }
    public static int forBreak(){
        int idx = 0;
        int sum = 0;
        for(;;){
            sum += idx;
            idx ++;
            if(idx > 100) break;
        }
        return sum;
    }
    public static int whileBreak(){
        int idx = 0;
        int sum = 0;
        while(true){
            sum += idx;
            idx ++;
            if(idx > 100) break;
        }
        return sum;
    }
    public static void main(String args[]){
        int sum1;
        int sum2;
        int sum3;
        int sum4;
        int sum5;
        sum1 = LoopTest.forTest();
        sum2 = LoopTest.whileTest();
        sum3 = LoopTest.doWhileTest();
        sum4 = LoopTest.forBreak();
        sum5 = LoopTest.whileBreak();
        System.out.println("for test : " + sum1);
        System.out.println("while test : " + sum2);
        System.out.println("do while test : " + sum3);
        System.out.println("for break test : " + sum4);
        System.out.println("while breaka test : " + sum5);
    }
}
```

- 모두 동일한 결과.
- C에서의 반복문과 매우 유사.