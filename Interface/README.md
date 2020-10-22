# 자바에서의 Interface 
- 내가 계속 궁금했던 것...


```java

package sec01;

interface Inter {
    public void interMethod(); //abastact method
}

public class ABC implements Inter{
    public void interMethod(){
        System.out.println("this is abstract method's override !!");
    };

    public static void main(String[] args) {
        ABC a = new ABC();
        a.interMethod();
    }
}


```

- `interface`는 특정 메서드를 클래스에서 구현하도록 강제할때 사용한다. 파이썬에서도 비슷한 방식이 있다.
- 보통 추상메서드라고 이야기 한다. 협업할때 많이 사용함. 
- 중요한 점 `inferface`는 `implements`를 이용해 불러온다.

*파이썬에서의 추상메서드 강제*

```python3

import abc

class BaseClass(abc.ABC):
    def __init__(self):
        pass
    
    @abc.abstractmethod
    def do_this(self):
        raise Excpetion
    # 익셉션을 raise 하지않더라도, 상속받은 클래스가 구현 안하면 에러 발생함

class TestClass(BaseClass):
    def do_this(self):
        pass
    #이렇게라도 구현해야 TestClass에서의 do_this 메서드를 사용했을 때 에러가 안남.

```

