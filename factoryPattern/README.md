# 팩토리 패턴 in Java

* 우선 간단하게는 팩토리 클래스가 객체 생성을 대신 수행 해준다고 보면 된다.

- 확장성 있는 구조를 만들 수 있지만, 불필요한 많은 클래스가 필요하다.

- 인스턴스를 만드는 절차를 추상화 한 패턴임.

객체를 생성하는 인터페이스는 미리 정의하지만,  
인스턴스를 만들 클래스의 결정은 서브 클래스에 내리는 패턴.

## 예시코드

```java
package factoryPattern;

public interface Shape {
    void draw();
}

```

interface를 정의하고, draw는 서브 클래스에서 구현한다. - 파이썬에서는 @abstract 데코레이터를 붙인다

그리고 Shape 이라는 base class를 상속받은 세개의 클래스를 생성한다.

```java
package factoryPattern;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square - drwa() method");
    }
}
```

shape에서 상속받은 method인 draw를 오버라이딩한다 (shape에서의 draw는 비어있다)


```java

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

``` 

ShapeFactory.getShape 메서드를 정의함. (각 클래스 생성)


```java

package factoryPattern;

public class FactoryPatternTest {
    public static void main(String[] args) {
        
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");

        shape1.draw(); //method calling

        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");

        shape3.draw();

    } 
}

```

팩토리객체를 생성하고 각 클래스 인스턴스 생성(.getShape) 및 각 클래스에 구현된 메서드 동작.


## FactoryPattern in Python

```python3
from abc import ABC, abstractmethod
```

추상클래스 및 객체를 구현하기 위해 모듈을 임포트 한다

위 예제를 구현해보자면

```python3
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def draw(self):
        pass

class Circle(Shape):
    def draw(self):
        print("circle method")

class Rectangle(Shape):
    def draw(self):
        print("Rectangle method")

class Square(Shape):
    def draw(self):
        print("Square method")

class ShapeFactory:
    def getShape(self, shape):
        return shape.draw()

shape_factory = ShapeFactory()

shape_factory.getShape(Circle())
shape_factory.getShape(Square())
shape_factory.getShape(Rectangle())
```

-> 출력

```console
(base)  ~/Desktop/ingkle/hello_java/factoryPattern   master ●  python3 factoryPattern.py
circle method
Square method
Rectangle method
```
