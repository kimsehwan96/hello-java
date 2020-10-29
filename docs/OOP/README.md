# 객체 지향

* 객체
    - 물리적으로 존재하거나 추상적으로 생각할 수 있는 것 중에서 자신의 속성을 가지며 식별 가능한 것
    - 속성 (field) + 동작 (method)로 구성

* 객체와 객체 간의 상호작용
    - 메소드를 통해 객체들이 상호작용
    - 메소드 호출 : 객체가 다른 객체의 기능을 이용하는 것


* 클래스
    - 자바의 설계도
    - 인스턴스 : 클래스로부터 만들어진 객체
    - 객체 지향 프로그래밍 단계
        - 클래스 설계 -> 설계된 클래스로 사용할 객체 생성 -> 객체 이용
    
* 클래스로부터 객체를 생성

``` java
new 클래스();
```

- new 연산자로 메모리 힙 영역에 객체 생성
- 객체 생성 후 객체 번지가 리턴
    - 클래스 변수에 저장하여 변수 통해 객체 사용 가능


* 클래스의 두가지 용도
    - 라이브러리 (API) 클래스
        - 객체 생성 및 메소드 제공 역할
    - 실행 클래스
        - main 메소드 제공 역할


```java

public class ClassExample {
    int fieldName; // 클래스의 필드
    // 객체의 데이터가 저장되는 곳

    ClassExample() {
        // 생성자
        // 객체 생성시 초기화 역할 담당
    }

    void methodName() {
        // 클래스의 메서드. 객체명.methoName() 과 같이 접근
        // 클래스명.methodName() 과 같이 접근하는건 정적 메서드(클래스 메서드) 참고
        // void는 해당 메서드의 리턴이 없다는 것을 뜻함
    }
}

```

## 필드 선언, 필드 사용

- 필드
    - 객체의 고유 데이터
    - 객체가 가져야 할 부품
    - 객체의 현재 상태 데이터등을 저장

- 필드 선언
    - 클래스 중괄호 블록 어디서든 존재 가능
    - 생성자와 메소드 중괄호 블록 내부에는 선언 불가
    - 변수와 선언 형태 유사하나 변수 아님에 주의

```java
public class Test {
    int a;
    String b = "hello";

}

```

- 파이썬은 ?

```python3

class Test:
    count = 0 #클래스 변수, 이 클래스를 통해 찍어낸 인스턴스는 모두 이 값으로 처음 생성
    def __init__(self, *args): #생성자
        self.name = args[0] #self 가 붙으면 인스턴스 변수들, 객체마다 다른 값
        self.age = args[1]
        self.lifeCycle = 0
    
    def test_method(self):
        self.old = self.lifeCycle
```

- 초기값은 주어질 수도, 생략할 수도 있음
    - 초기값 지정되지 않은 필드는 객체 생성 시 자동으로 기본 초기값 설정

* 필드 사용
    - 필드 값 읽고 변경하는 작업
    - 클래스 내부 생성자 및 메소드에서 사용하는 경우 :  필드 이름 읽고 변경
    - 클래스 외부에서 사용하는 경우 : 클래스로 부터 객체 생성한 뒤 필드 사용

```java

public class Car {
    String company = "현대";
    int speed;
}
```

```java
public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car(); //myCar라는 인스턴스(객체) 하나 생성
        myCar.speed = 50; // 객체의 필드값 변경
    }
}
```

- 파이썬 예
```python3

class Car:
    speed = None

if __name__ == "__main__":
    a = Car()
    a.speed = 30
```

## 생성자, 매개 변수, 객체 초기화, 오버로딩 ,this()

- 생성자
    - 클래스로부터 new 연산자로 객체를 생성할 때 호출되어 객체의 초기화를 담당

- 객체 초기화
    - 필드를 초기화 하거나 메소드를 호출해 객체를 사용할 준비를 하는 것

- 클래스에서 생성자 선언하지 않아도 new 생성자()로 객체 생성 가능


```java
public class Car {
    Car(String model, String color, int maxSpeed){ }
}
```

```java
Car myCar = new Car("그랜저", "검정", 300);
```

- 파이썬

```python3
class Car:
    def __init__(self, model, color, maxSpeed):
        self.modle = model
        self.color = color
        self.maxSpeed = maxSpeed

if __name__ == "__main__":
    myCar = Car("그랜저", "검정", 300)
```



* 생성자의 필드 초기화

```java
public class Korean {
    String nation = "대한민국";
    String name;
    String ssn;

    public Korea(String n, String s) {
        name = n;
        ssn = s;
    }
}

Korean k1 = new Korean("하이", "960316-1234567");
```
* 매개 변수 이름은 필드 이름과 유사하거나 동일한 것 사용 권장
* 필드와 매개 변수 이름 완전히 동일할 경우 this.필드로 표현

```java
public Korean(String name, String ssn) {
    this.name = name
    this.ssn = ssn
}
```



* 생성자 오버로딩(Overloading)
    - 매개 변수를 달리하는 생성자 여러개 선언
    - 외부에서 제공되는 다양한 데이터를 사용하여 객체 화 하기 위해

```java

public class Test {
    private int speed;

    Test(String speed){ //생성자
        this.speed = Integer.parseInt(speed);
    }

    Test(int speed) { //생성자를 다른 매개변수 타입으로 -> 생성자 오버로딩
        this.speed = speed
    }
    //생성자 오버로딩은 매개 변수의 타입, 개수, 순서를 다르게 선언해야 함
}
```

- 파이썬에 이런게 있을까?
    - 자바도 최근부터 지원하지만, 파이썬의 함수는 가변인자를 받을 수 있다.

```python3

class Test:
    def __init__(self, *args, **kwargs):
        print(args)
        print(kwargs)
# *args와 **kwargs의 차이? args는 각 인자별로 들어오고, kwargs는 keyword args로, 딕셔너리 형태로 입력하게 된다

# 이러한 가변인자 기능이 있기 때문에 오버로딩이 굳이 필요하지 않아 보인다.
```

```python3

def test(x, *args):
    pass 
test(1, 2, 3, 4)
# x -> 1, args = (2,3,4)

def test(x, y, **kwargs):
    pass

test(2, 3, flag=True, mode='fast', header='debug')
#x -> 2, y -> 3 , kwargs = { 'flag': True, 'mode': 'fast', 'header': 'debug' }

```

이런 강력한 가변인자 기능이 있기 때문에 오버로딩 ㄴㄴ



- 자바에서 생성자 오버로딩 예시 더 보기

```java
public class Car {
    Car() { } // Car car1 = new Car();
    Car(String model) { } // Car car2 = new Car("K3");
    Car(String model, String color) { } // Car car3 new Car("K3", "Black");
}
```

이건 오버로딩이 아님!

```java
Car(String model, String color) { }
Car(String color, String model) { }//오버로딩이 아니다.
```



- 다른 생성자 호출
    - 생성자 오버로딩 하다 보면 중복코드 발생


```java
public class Car{
Car(String model) {
    this.model = model;
    this.color = "은색";
    this.maxSpeed = 250;
}
Car(String model, String Color) {
    this.model = model;
    this.color = "은색";
    this.maxSpeed = 250;
}
Car(String model String Color, int maxSpeed) {
    this.model = model;
    this.color = "은색";
    this.maxSpeed = 250;
}
}
//중복
```

* 중복코드 제거 방법

```java
public class Car {
Car(String model) {
    this(model, "은색", 250);
}
Car(String model, String Color) {
    this(model, "은색", 250);
}
Car(String model, String color, int maxSpeed) {
    this.model = model;
    this.color = color;
    this.maxSpeed = maxSpeed;
}
}
// this (Car)를 호출해서, 중복코드 제거함
```


