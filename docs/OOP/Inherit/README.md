# 상속

- 상속, 메소드 재정의(오버라이드), final 클래스, final 메소드


- 객체 지향 프로그램에서 부모 클래스의 멤버를 자식 클래스에게 물려줄 수 있다.

### 상속
- 이미 개발된 클래스를 재사용하여 새로운 클래스를 만들기에 중복되는 코드를 줄임
- 부모클래스의 한번의 수정으로 모든 자식 클래스까지 수정되는 효과가 있어 유지보수 시간이 줄어듬

```java

public Class A {
    int field1;
    void method(){}
}

public class B extends A { //A클래스를 상속받았으며, int field1과, void method1() 둘다 사용 가능
    String field2; //자식 클래스에서 새로 정의한 필드
    void method2(){} //자식 클래스에서 새로 정의한 메서드(기존에 없던 메서드)
}
```

### 클래스 상속

- 자식 클래스 선언시 부모 클래스 선택
- extends 뒤에 부모 클래스 기술

```java
class 자식클래스 extends 부모클래스 {
    //필드
    //생성자
    //메소드
}

class SportsCar extends Car {

}
```

- 여러개의 부모 클래스 상속할 수 없음
- 부모 클래스에서 private 접근 제한 갖는 필드와 메소드는 상속대상에서 제외(public이나 proteced만 가능)
- 부모와 자식 클래스가 다른 패키지에 존재할 경우 default 접근 제한 필드와 메소드 역시 제외


### 생성자의 상속

```java
public class Calculator {
    public Calculator(){
        System.out.println("caluator generated ");
    }
    public void whoAmI(){
        System.out.println("this is cacluator");
    }

    public void showNumber(int x){
        System.out.println("this is number" + x);
    }
}

// 밑에는 상속받은 클래스 밑 메인 메소드
public class Computer extends Calculator{
    @Override
    public void whoAmI(){
        System.out.println("I am Computer !");
    }
    
    public void showNumber(int x) {
        System.out.println("this is computer's number" + (x*2));
    }
    
    
    public static void main(String[] args){
        Computer com = new Computer();

        com.whoAmI();;
        com.showNumber(5);
    }
}
```

- 상기 코드는 생성자를 Calculator 에서만 정의했기 때문에, Computer 클래스의 객체가 생성될 때 calculator generated 라는 문자가 찍히게 된다.
- 생성자를 오버라이드해볼까


```c
public class Computer extends Calculator{
    public Computer(){
        System.out.println("Computer generated !");
    }
    @Override
    public void whoAmI(){
        System.out.println("I am Computer !");
    }
    
    public void showNumber(int x) {
        System.out.println("this is computer's number" + (x*2));
    }
    
    
    public static void main(String[] args){
        Computer com = new Computer();

        com.whoAmI();;
        com.showNumber(5);
    }
}

```

- Calculator의 생성자 및 Computer 생성자 모두 호출 되더라.

- 만약 부모클래스를 상속 받고, 자식 클래스가 생성될 때 부모 클래스의 생성자 사용하기 싫으면
- 부모클래스에 생성자를 작성하지 말아여것다.


#### 부모 생성자 호출

```java

class B extends A {
    public B(매개변수){
        super(매개값); //부모 생성자의 생성자를 호출하는 것.
    }
}
```

- 필드에 Pulic을 달아줘야 다른 패키지에서도 생성자를 통한 필드값 초기화 가능하다.

```java
package test.A;
class A {
    public int field1;
    public String field2;

    public A(int field, String str){
        this.field1 = field;
        this.field2 = str;
        //생성자도 Public 해줘야..
    }
}

package foo.bar;

class B extends A {
    B(){
        super(5, "hi"); //A라는 부모 클래스가 생성자 및 필드가 퍼블릭해야 다른 패키지에서도 부모 생성자 호출 가능하다는거!
    }
}
```

- 부모클래스가 갖고있는 필드는 자식 클래스에서  this.필드 혹은 super.필드 로 접근 가능하며
- 자식클래스만 갖고있는 필드는 당연하게도 super.필드 로 접근이 불가능하다.

### 메소드 재정의(오버라이딩)

- 접근제한자가 더 강하게 재정의 불가능 (부모에서의 public을 자식에서 오버라이드 후 private 하는것 불가능)
- 새로운 throws 할 수 없음 (새로운 예외 throws 불가능)


```java

public class cal {
    final static double PI = 3.141592
    public double areaCircle(double r){
        return this.pi * r * r;
    }
}

class com extends cal {
    @Override
    public double areaCircle(double r){
        double cr = super.areaCircle(r);
        System.out.println("Calculator's area circle override in com");
        return cr;
    }
}

```

- 기존에 정의되어있던 메서드 앞이나 뒤에 좀 더 무언가 로직을 붙여줄때 쓰면 좋겠는데
    - 파이썬의 데코레이터는 이걸 편하게 해주는건가?

```python3
# @을 사용해 쉽게 데코레이터 사용

def trace(func):
    def wrapper():
        print(func.__name__, " 함수 시작")
        func()
        print(func.__name__, "함수 끝")
    return wrapper

@trace
def hello():
    print("hello")

@trace
def world():
    print("world")


if __name__ == "__main__":
    hello()
    world()

```

- 이렇게 위에 areaCircle 앞뒤에 뭔가 붙여주는것 마냥 오버라이드 하기보다도(파이썬에서)
    - wrapper함수 만들고, 이걸 decorator로 만드는 패턴 좋아보인다.

- 위 오버라이드한 자바 예제와 거의 비슷하게 돌려버리는 파이썬 코드

```python3
def trace(func):
    def wrapper(self, r):
        r = func(self, r)
        print("this is com area_circle")
        return r
    return wrapper

class cal:
    def __init__(self):
        self.PI = 3.141592
    def area_circle(self, r):
        return self.PI * r * r

class com1(cal):
    @trace
    def area_circle(self, r):
        return self.PI * r * r

if __name__ =="__main__":
    c = com1()
    print(c.area_circle(5))

```

- 자바코드와의 차이점은, 메서드 오바라이드를 하지 않고 데코레이터를 새로 만들어서 진행한점.
    - 아예 똑같은 버전도 코딩해보자.


```python3

class cal:
    def __init__(self):
        self.PI = 3.141592
    def area_circle(self, r):
        return self.PI * r * r

class com1(cal):
    def area_circle(self, r):
        ac = super(com1, self).area_circle(r) #파이썬은 부모 클래스의 
        #메서드 접근을 super(자식클래스, self).부모메서드 이렇게 접근 가능.
        print("Calculator's area circle override in com")
        return ac

if __name__ == "__main__":
    c = com1()
    print(c.area_circle(5))

```


### 부모 메서드 호출

- 자식 클래스 내부에서 재정의된 부모 클래스 메소드를 호출헤야 하는 경우

```java

class Child extends Parent {
    void method2(){}
    void method3(){
        this.method2();
        super.method2();
    }
}
```


```python3
class Parent:
    def __init__(self):
        pass

    def method1(self):
        print("method1 in Parent")
    
    def method2(self):
        print("method2 in Parent")

class Child(Parent):
    def method2(self):
        print("method2 in Child")
    
    def call_parent_method(self):
        super(Child, self).method2()


if __name__ == "__main__":
    p = Parent()
    c = Child()

    c.method2()
    c.call_parent_method()

```


### final class, final method

- 해당 선언이 최종 상태이며 수정될 수 없음을 의미
- 클래스 및 메소드 선언시 final 키워드를 사용하면 상속과 관련됨

#### 상속할 수 없는 final 클래스

```java
public final class String { }

public class NewString extends String { }// 절대 안됨
```

#### 재정의할 수 없는 final 메소드

- 부모 클래스에 선언된 final 메소드는 자식 클래스에서 재정의 할 수 없음

```java
public final 리턴타입 메소드 () { }
```
