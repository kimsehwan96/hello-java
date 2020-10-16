# 인스턴스 멤버와 정적 멤버

- 핵심 키워드 : 인스턴스 멤버, this, 정적 멤버, static, final 필드, 싱글톤, 상수

- 핵심 포인트
    - 클래스에 선언된 필드와 메소드가 모두 객체 내부에 포함되는 것은 아님
    - 객체가 있어야 사용 가능한 멤버가 있고, 그렇지 않은 멤버도 있다.


* 복습
    - 메모리 사용 영역(Runtime Data Area)
        * 메소드 영역
            - 클래스 별로
            - static field
            - constant
            - constructor
            - method
            - 코드 등을 분류해 저장
        
        * 힙 영역
            - 객체와 배열이 생성되는 영역

        * JVM 스택 영역
            -  메소드가 호출 되면
            - 프레임이 추가되고
            - 메소드가 종료되면
            - 프레임이 제거 됨

## 메소드 영역

- 메소드 영역 -> 변환이 없는 것들이 들어간다고 생각하면 됨
    - 상수, 정적필드, 메소드 코드, 생성자 코드(얘네 변하지 않아요)
    - 함수에 들어오는 인자 값은 변할 수 있지만, 내부 로직이 변하진 않는다는 의미임.
- 힙 영역 -> 여러개가 존재하는 것들 (배열, 객체)
- JVM 스택 -> 1개씩 바뀌는 (Pop - Push)


* 다시 본론으로

- 인스턴스 멤버
    - 객체마다 가지고 있는 멤버
        - 인스턴스 필드 : 힙 영역의 객체마다 가지고 있는 멤버, 객체마다 다른 데이터를 저장
        - 인스턴스 메소드 : 객체가 있어야 호출 가능한 메소드, 클래스 코드 (메소드 영역에 위치하지만), 이해하기 쉽도록 객체마다 가지고 있는 메소드라고 생각하면 됨

*파이썬과 비교 -김세환 작성-*

```python3

class TestClass:

    def __init__(self, name):
        self.name = name  #파이썬에서의 클래스 생성 시 인스턴스 변수 생성 되는 로직
        self.age = 0
    
    def get_name(self):
        return self.name
    
    def get_age(self):
        return self.age
    #위에 두 get_name, get_age는 인스턴스 메소드임

if __name__ == "__main__":
    cls = TestClass('kim') #cls는 TestClass의 새로운 객체 임
    # def __init__(self,name) 이것이 클래스 생성자인데, self 뒤 인자로 name을 받고,이 name이 클래스의 인스턴스 필드 name에 저장 됨
    print(cls.get_name()) # 'kim'

```

- 위 코드는 간단한 테스트 클래스 작성을 표현했다. 기본적으로 파이썬 클래스 생성시 인스턴스 변수를 인스턴스 메서드를 이용해 정의해야 함.

예를 들어

```python3
class TestClass:
    self.name = 'kim'
    def __init__(self):
        pass

    def get_name(self):
        return self.name

if __name__ == "__main__":
    cls = TestClass()
    print(cls.get_name()) #오류 발생
```

이렇게 정의 할 경우 문제가 발생함. 반드시 인스턴스 메서드 안에서 인자를 통해 받거나, 계산, 혹은 전역 변수로부터 받아야 한다 !


*자바에서의 예제*

```java

public class Calculator {

    //접근 제한자로 private을 쓰면서, Calculator라는 클래스의 인스턴스 변수로 result_buffer를 정의 함.
    private double result_buffer;

    Calculator() {
        this.result_buffer = 0; // 생성시 인스턴스 변수의 초기화. 
        //this는 객체 내에서 인스턴스 멤버에 접근하기 위해 사용
        // 파이썬에서는 self 사용
    }

    // show result 인스턴스 메서드, 파이썬에서 private 접근 지정자와 비슷한 개념이 있다. 추후 설명
    private void show_result() {
        System.out.println(this.result_buffer);
    }
    // 이하 메서드 모두 인스턴스 메서드 !!
    public String return_str_buffer() {
        return String.valueOf(this.result_buffer);
    }

    public double return_buffer(){
        return this.result_buffer;
    }
    public void reset(){
        this.result_buffer = 0;
        System.out.println("buffer reset!!");
    }

    public void input_number(double x){
        this.result_buffer = x;
        this.show_result();
    }
}

```

* 여기서 잠깐
    - 자바에서의 접근 제한자 private 같은건 파이썬에 없을까?
    - 파이썬에서의 메서드에 접근 제한자는 따로 없고, 모든 클래스의 메서드가 public 개념이다.

다만 밑에 코드를 참고하자

```python3

class TestClass:
    def __init__(self):
        pass

    def _first_method(self): # 언더바 한개는 protected와 비슷한 개념으로 사용하라고 '권고' 하는것, 강제 되지 않는다. 즉 효과는 없다.
        pass

    def __second_method(self): # 언더바 두개는 private과 '동일'하다.
        pass
```

* 파이썬에서 클래스 메서드의 접근 제한자는 명명 규칙을 이용한다
    - `_method(self)` 이것은 protected 처럼 사용하라고 '권고' 강제는 못한다.
    - `__method(self)` 이것은 private과 동일하다. 뒤에 언더바 한개까진 가능하지만, 언더바 두개가 오면 public이다 (예 `__init__`)

* 다시 본론으로 돌아오기 !!!!!!!!!!!!!!!!!!1

- 자바에서의 정적 멤버
    - 객체와 상관없는 멤버, 클래스 코드(메소드 영역에 위치)
    - 정적 필드 및 상수 : 객체 없이 클래스만으로도 사용 가능한 필드
    - 정적 메소드 : 객체 없이 클래스만으로도 호출 가능한 메소드


* 파이썬과의 비교 !!
    - 일단 알아 둘 점 
        1. 파이썬에서의 정적 메서드 구현은 간단하다
        2. 정적 변수 구현은 꼼수를 좀 부려야 한다.....


1. 첫번째. 파이썬에서의 정적 메서드 구현 !
    - 데코레이터를 이용해야 한다
        1. `@staticmethod`
        2. `@classmethod`

```python3

#@staticmethod 데코레이터 이용 예

class Test:

    @staticmethod #데코레이터를 이쁘게 붙여준다
    def add(a, b):
        return a + b

if __name__ == "__main__":
    print(Test.add(5,6)) # 11
    # Test라는 클래스의 인스턴스를 만들지 않고서도 사용 가능하다 !

```

* `staticmethod`는 self를 받지 않으므로 `인스턴스 속정에 접근 불가`합니다.
* 따라서 스태틱 메서드는 인스턴스 속성, 인스턴스 메소드가 필요 없을 때 사용 한다!

## 그럼 어떨 때 정적 메서드를 만들까?

- 메서드의 실행이 외부 상태에 영향을 끼치지 않는 순수 함수(pure function)을 만들 때 사용
- 순수 함수는 side effect가 없고, 입력 값이 같으면 언제나 같은 출력 값을 반환 한다.


```python3

#@classmethod 데코레이터 이용 예

class Test:
    @classmethod
    def add(cls, a, b):
        return a + b

if __name__ == "__main__":
    print(Test.add(5,6)) # 11
    # 역시 객체의 인스턴스 생성 하지 않고도 호출 가능
    # 다른 점은 메서드 인자의 첫번째 positional argument로 cls (class)를 받는다는 것
```

```python3

class Person:
    count = 0    # 클래스 속성
 
    def __init__(self):
        Person.count += 1    # 인스턴스가 만들어질 때
                             # 클래스 속성 count에 1을 더함
 
    @classmethod
    def print_count(cls):
        print('{0}명 생성되었습니다.'.format(cls.count))    # cls로 클래스 속성에 접근
 
james = Person()
maria = Person()
 
Person.print_count()    # 2명 생성되었습니다.

```

- 스태틱 메서드와 다른 점은, cls를 인자로 받기 때문에, 클래스 속성에 접근이 가능하다는 것 !

## 어떨 때 쓸까?

- 클래스 메서드는 인스턴스 없이 호출 가능한 점은 똑같다. 다만 클래스메서드는 메서드 안에서 클래스 속성, 클래스 메서드에 접근해야 할 때 사용한다.

```python3

class Person:
    @classmethod
    def create(cls): #인자로 받은 cls 는 Person임.
    p = cls() # cls()로 Person 클래스의 인스턴스 생성
    return p
```

## 파이썬에서의 정적 변수..

* 일단 파이썬에서 클래스 속성은 있는대, 이게 실제로 정적 변수는 아니다.

```python3

class Test:
    count = 0 #클래스 속성, 인스턴스 속성 아님.
```

- 자료를 찾아보니 정말 많은 해결책이 있다. 무엇이 정확할까.,.?

1. 클래스 속성이 아닌 속성으로 변경!

```python3

class Test:

    _i = 3

    @property
    def i(self):
        return type(self)._i
    
    @i.setter
    def i(self, val):
        type(self)._i = val

# 위와 기능적으로 동일한 코드, 둘중 편한거 선택

class Test:

    _i = 3

    def get_i(self):
        return type(self)._i

    def set_i(self, val):
        type(self)._i = val

    i = property(get_i, set_i)


#이제 모든 클래스 인스턴스간에 정적변수가 동기화 된다 !!!

if __name__ == "__main__":

    x1 = Test()
    x2 = Test()
    x1.i = 50 #정적변수를 50으로 셋팅, 다른 인스턴스의 정적 변수에도 모두 적용되어야 한다 !
    assert x2.i == x1.i #no error
    asssert x2.i == 50  #모든 정적변수가 동기화 됨!
```

* 사실 정적변수는 아니지만, property 기술자의 응용 중 하나임. 하지만 모든 클래스 인스턴스에서 동기화 된 정적 변수와 동일함. 다만 변경이 가능한 정적 변수라는 점.

- 만약 변하지 않는 정적변수로 만들고 싶으면 setter를 모두 날려버리면 된다.

* 위 방식의 문제중 하나는.... 클래스의 인스턴스에서만 작동하지, 클래스 자체를 사용 할 때는 안된다 이거다.

- 결과론적으로... 굳이 다른 언어의 행동을 따라하지 말라고 한다........ 안쓴다..

더 자세한 내용은 : https://c10106.tistory.com/1807
 
* 다시 돌아와서 자바의 정적 멤버와 스태틱 !!!!!!!!

```java
public class 클래스 {
    //정적 필드
    static 타입 필드 [= 초기값];

    // 정적 메소드

    static 리턴 타입 메소드 (매개 변수 선언, ~~) { 로직 ~~}
}
```


```java

public class Calculator {
    static double pi = 3.14159;
    static int plus(int x, int y) {
        return x + y;
    }
    static int minus(int x, int y){
        return x - y;
    }

    static void main(String[] args){
        double result1 = 10 * 10 * Caclulator.pi;
        //스태틱 변수이므로, 클래스명.필드 로 접근 가능
        int result2 = Calculator.plus(10, 5);
        int result3 = Calculator.minus(10, 5);
        //스태틱 메서드이므로, 클래스.메소드(매개변수)로 접근 가능
    }
}
```


## 인스턴스 멤버와 정적 멤버 선택 기준?

- 객체마다 다를 수 있는 필드 값 -> 인스턴스 필드로 선언
- 객체마다 다를 필요가 없는 값 -> 정적 필드로 선언.
- 메소드 블록에 인스턴스 필드, 혹은 메소드를 사용한다? -> 인스턴스 메소드
- 아니다? -> 정적 메소드로 선언

* 정적 메소드 사용시 주의 할 점
    - 정적 메소드 선언 시 그 내부의 인스턴스 필드 및 메소드 사용 불가
    - 정적 메소드 선언 시 this 키워드 사용 불가
    - 그니까, Pure function 만들 때 사용해라 쫌 !!!

## 좀 이따 싱글톤 정라ㅣ 예정