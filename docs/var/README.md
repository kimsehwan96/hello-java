# 변수와 타입

* 변수
    - 값을 저장할 수 있는 메모리의 특정 번지에 붙여진 이름
    - 변수 통해 해당 메모리 번지에 하나의 값 저장하고 읽을 수 있음
    - 변수는 정수, 실수 등 다양한 타입 값을 저장 할 수 있음

* 변수 사용 위해 변수 선언 필요
    - 변수에 어떤 타입의 데이터를 어떤 이름으로 저장 할 것인지

* 로컬 변수
    - 메소드 블록 내에서 선언된 변수를 로컬 변수라고 함

```java
public class Test{ //클래스 블록
    public static void main(String[] args){ //메소드 블록 시작
        int value = 10; //로컬 변수 value
        int sum = value + 20; //로컬 변수 sym
    } // 여기까지가 메소드 블록 
}//클래스 블록 끝
```

- 로컬 변수는 메소드 블록 내에서만 사용되고, 메소드 실행이 끝나면 자동 삭제됨
- 스택 영역에 저장(배열이나 객체가 아니라면..)

* 로컬 변수는 해당 중괄호 블록 내에서만 사용 가능

```python3

def test():
    a = 50
    c = 10
    return a + c
# 파이썬도 동일하다. 이 함수 부분 안에서만 a, c가 존재한다.
```

* 변수 기본 타입

- 총 8개의 기본 타입을 제공함
    - 정수 타입
        - byte
        - char
        - short
        - int
        - long
    - 실수 타입
        - float
        - double
    - 논리타입
        - boolean

* 정수 타입
    - byte : 1byte (-2^7 ~ 2^7 - 1) ->왜 2^7? 1비트는 부호비트니까 ㅋㅋ -1? 0을 뺴니까 ㅋㅋ
    - short : 2byte (-2^15 ~ 2^15 - 1)
    - char : 2byte (0 ~ 2^16 - 1) 0 ~ 65535 (유니코드)
    - int : 4byte
    - long : 8byte

* 리터럴
    - 소스 코드에서 개발자에 의해 직접 입력된 값
    - 다음 경우를 자바에서 정수로 인식
    - 2진수
        - `0b10011 -> 11`
        - `0b10100 -> 20`
    - 8진수
        - `013 -> 11`
        - `0206 -> 134`
    - 16진수
        - `0x83 -> 179`
        - `0x2A0F -> 10767`

* char 타입
    - 하나의 문자를 저장할 수 있는 타입

```java
char v1 = 'A'; //유니코드 65
char v2 = 'B'; //유니코드 66
char v3 = '가'; //유니코드 44032
char v4 = '각'; //유니코드 44033
char c = 0x0041; //정수형이기 때문에 이런 표현도 가능
```

* 문자열
    - 큰 따옴표로 감싼 문자들을 문자열
    - char에 저장 불가

```java
String v = "A";
String v2 = "김세환";
```

* 이스케이프 문자
    - 문자열 내부에 " 표현할때는
    - `String str = "나는 \"바보\" 입니다";`
    - \t \n \r 이런거 있다
    - \u16진수 -> 16진수 유니코드에 해당하는 문자 출력

* 실수 타입
    - float 4byte // 정밀도 7자리
    - double 8byte //정밀도 15자리
    - 알파벳 e 또는 E 포함된 숫자 리터럴은 지수 및 가수로 표현 된, 소수점 있는 10진수 실수로 인식
    - `5e2 -> 5.0 * 10^2`
    - `0.12E-2 -> 0.12*10^-2`

* 자바는 실수 리터럴을 기본적으로 double로 해석함
* float타입으로 저장하려는 경우 리터럴 뒤 f 혹은 F붙여서 타입 표시


* 논리 타입
    - 참과 거짓에 해당하는 true, false 리터럴 저장

## 타입 변환 (캐스팅)

* 타입 변환이란
    - 데이터 타입을 다른 데이터 타입으로 변환하는 것을 말한다.
        - byte -> int
        - int -> byte
        - double -> int
        - String -> int

* 변수 값을 다른 타입의 변수에 저장 할 때 타입 변환이 발생 할 수 있다.

* 자동 타입 변환
    - 값의 허용 범위가 작은 타입이 큰 타입으로 저장되는 경우

- 기본 타입 허용 범위 순
`byte < short < int < long < float < double`

```java
byte byteValue = 10;
int intValue = byteValue; //자동 타입 변환

long longValue = 500000000L;
float floatValue = longValuel; // 자동 타입 변환 
```

- char 타입의 경우 int 타입으로 자동 변환되면 유니코드 값이 int 타입에 저장

```java
char charValue = 'A';
int intValue = charValue; // 65저장

byte byteValue = 65;
char charValue = byteValue; //컴파일 에러 캐스팅 명시해주지 않으면 불가능 함
```

* 강제 형 변환
    - 큰 허용 범위 타입을 작은 허용 범위 타입으로 강제로 나누어 한 조각만 저장

```java
int intValue = 10;
byte byteValue = (byte) intValue; //강제 타입 변환

double doubleValue = 3.14;
int intValue = (int) doubleValue; // 소수점 이하 버려지고 정수 부분만 저장

int a = 65;
char c = (char) a;
System.out.println(c); // "A"가 출력

```

* 정수 타입 변수가 산술 연산식에서 피 연산자로 사용 되면
    - byte, char, short는 int로 자동 변환
    - 피연산자중 다른 하나가 long이면 다른 피 연산자는 long으로 자동 변환

* 실수 연산
    - 피연산자중 하나가 double 타입 일 경우 다른 피연산자도 double 타입으로 자동 변환

* 정수 연산의 결과는 정수
    - 예를들어 정수끼리 나눠서 실수를 보고싶으면 변환이 필요함

```java
int x = 1;
int y = 2;
double result = (double) x / y;

int x = 1;
int y = 2;
double result = x / (double) y;

int x = 1;
int y = 2;
double result = (double) x / (double) y ; 

```

* `+`연산
    - 피 연산자가 모두 숫자일 경우 덧셈
    - 피 연산자 중 하나가 문자열이면 나머지도 문자열로 자동 변환 및 문자열 결합 연산

* 문자열을 기본 타입으로 강제 변환

```java
String str = "10";
byte value = Byte.parseByte(str);

String str = "200";
short value = Short.parseShort(str);

String str = "30000000";
int value = Integer.parseInt(str);

String str = "4000000000000000";
long value = Long.parseLing(str);

String str = "12.345";
float value = Float.parseFloat(str);

String str = "12.345";
double value = Double.parseDouble(str);

String str = "true";
boolean value = Boolean.parseBoolean(str);
```


```
String str = String.valueOf(3);
//기본 타입을 문자열로 변환
```

## 변수와 시스템 입출력

- 표준 출력 장치 : 모니터
- 표준 입력 장치 : 키보드 

* System.out
    - 시스템의 표준 출력 장치로 출략

* System.in 
    - 시스템의 표준 입력 장치에서 읽음

* println() 메소드
    - 괄호 안에 리터럴 넣으면 그대로 출력 / 변수 넣으면 저장된 값 출력

- 다양한 출력 메서드
    - println(내용); -> 괄호 안의 내용을 출력하고 행을 바꿔라
    - print(내용); -> 괄호 안의 내용을 출력만 해라
    - printf("형식 문자열", 값1, 값2...); -> 괄호 안의 첫 번째 문자열 형식대로 내용을 출력해라

* printf() 메서드
    - 개발자가 원하는 형식화된 문자열 (formal string)출력 

```java
System.out.printf("이름 : %s" , "김세환");
System.out.printf("나이: %d" , 25); 
System.out.printf("이름 %1$s, 나이 %2$d" , "김세환", 25);  
// 형식 문자열에 포함될 값 2개 이상인 경우 값의 순번을 표시해야 함 
/// % $ 숫자 포메팅문자

```

`%d, %f, %s` 형식 지정자로써 사용 가능하다.

* 키보드에서 입력된 내용을 변수에 저장하기

```java
Scanner scanner = new Scanner(System.in);

String inputData = scanner.nextLine();
// enter 입력 이전까지 입력된 문자열을 읽음
```


* 기본 타입과의 값 비교와 문자열 비교
    - 기본 타입의 값 비교는 `==`을 사용한다.
    - 문자열의 비교는 equals() 메서드 사용

```java
int x = 5
boolean result = (x == 5);
//true

boolean result = inputData.equals("비교 문자열");
```

