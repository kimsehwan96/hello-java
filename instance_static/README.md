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

