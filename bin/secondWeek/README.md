# 2주차 내용

* 로컬 변수
- 메소드 블록 내에서 선언된 변수를 로컬 변수라고 함

```java
public class VarExample {
    public static void main(String[] args) {
        int value = 10; // 로컬 변수
        int sum = value + 20; // 로컬 변수
        System.out.println(sum);
    }
}
```

* 메소드 블록 내에서 선언된 변수를 로컬 변수라고 함.

* 로컬 변수는 해당 중괄호 블록 내에서만 사용이 가능하다.

## 자동 타입 변환

* 값의 허용 범위가 작은 타입이 큰 타입으로 저장 될 경우..

`byte < short < int < long < float < double`

이렇게 자동 타입 변환이 됩니다.
```java
byte byteValue = 10;
int intValue = byteValue; // 자동 타입 변환 됨
```
## 강제 타입 변환(casting)

* 큰 허용 범위 타입을 작은 허용 범위 타입으로 강제로 나누어 한조각만 저장
(2바이트짜리 데이터를 1바이트로 두개로 나눈다던지..)  

```java
int intValue = 10;
byte byteValue = (byte) intValue; // 강제 타입 변환
```

* 자주 쓰는 예제 두가지

```java
int intValue = 65;
char charValue = (char) intValue;
System.out.println(charValue); // "A" 가 출력

// 실수 타입을 강제로 정수로 바꿀 때.
double doubleValue = 3.14;
int intValue = (int) doubleValue; // intValue = 3
```

## 정수 연산에서의 자동 타입 변환

* 정수 타입 변수가 산술 연산식에서 피연산자로 사용 되는 경우
- byte, char, short 타입 변수는 int 타입으로 자동 변환
- 정수 연산에 사용하는 변수는 특별한 경우가 아니라면 int 타입으로 선언하기.


## 정수 연산 결과 주의점
```java
        int x = 3;
        int y = 2;
        double result = (double) x/ (double) y;
        System.out.println(result);
```

위 예제 같은 경우에는 1.5가 정확히 찍히지만.

```java
        int x = 3;
        int y = 2;
        double result = x / y;
        System.out.println(result);
```

이렇게 하면 1만 남는다... 정수 연산의 결과는 정수라서 그럼


## 문자열을 기본 타입으로 강제 변환

파이썬
```python3
string = "123125"
result = int(string)
```

자바에서는..

```java
String str = "10";
byte value = Byte.parseByte(str);

String str = "200";
short value = Short.parseShort(str);

String str = "10234233";
int value = Integer.parseInt(str);

String str = "102314234325";
long value = Long.parseLong(str);

String str = "10.353";
float value = Float.parseFloat(str);

String str = "true";
boolean value = Boolean.parseBoolean(str);


String str = String.valueOf(3); // 기본 타입을 문자열로 변환

```
