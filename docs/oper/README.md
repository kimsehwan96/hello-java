# 연산자

- 자바에서 제공하는 연산자
    - 산출되는 값의 타입이 연산자 별로 다름

- 산술 연산자 : +, -, * , / , %
- 부호 : + , - 
- 문자열 : +
- 대입 : =. +=, -=, *=, /=, %=
- 증감 : ++ , --
- 비교 : ==, !=, >, <, >= , <=, instanceof
- 논리 : !, &, |, &&, ||  -> 논리 부정, 논리 곱, 논리 합
- 조건 : (조건식) ? A : B  -> 조건식 만족하면 A, 아니면 B (삼항 연산자)

```java
public class ThreeOper {
    public static void main(String[] args){

        int sum = 100;
        char result;

        result = (sum>90) ?  'A' : 'B';
        System.out.println(result); // A
    }
    
}
// 삼항 연산자 예제
```


```java

int x = 1;
int y = 1;

int result1 = ++x + 10;
int result2 = y++ + 10;

// result1은 x에 1을 더한후 연산을 하므로 12
// result2 는 1 + 10 이 result에 저장된 이후, y++ 가 됨
```

* 논리 연산자
    - & 혹은 && : 피 연산자가 모두 true 일 경우에만 연산 결과가 true (논리 곱)
    - || 또는 | : 피 연산자 중 하나라도 true면 true (논리 합)
    - ^ : 피연산자가 하나는 true고 하나는 false 일 때만 연산 결과가 true (배타적 논리합)
    - ! : 피연산자의 논리값을 바꿈
