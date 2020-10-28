# Setter와 Getter의 개념.

## 외부에서 객체에 마음대로 접근 할 경우 객체의 무결성 깨질 수 있음

- Setter 메소드
    - 외부의 값을 받아 필드의 값을 변경하는 것이 목적
    - 매개값 검증하여 유효한 값만 필드로 저장 할 수 있음

*Base Class java 코드*
```java


public class SetterGetter {
    private double speed;

    public void setSpeed(double speed){
        if(speed < 0) {
            this.speed = 0;
            return ;
        } else {
            this.speed = speed;
        }
    }
    public void showSpeed(){
        System.out.println(this.speed);
    }
}


```

*Test Code*

```java
public class Test {
    public static void main(String[] args) {
        SetterGetter cls = new SetterGetter();
        cls.setSpeed(60.0);
        cls.showSpeed();
        cls.setSpeed(-5);
        cls.showSpeed();
    }
}

```

*결과*

```console
cd /Users/gimsehwan/Desktop/ingkle/hello_java ; /Library/Java/JavaVirtualMachines/jdk-14.0.2.jdk/Contents/Home/bin/java -XX:+ShowCodeDetailsInExceptionMessages -Dfile.encoding=UTF-8 -cp "/Users/gimsehwan/Library/Application Support/Code/User/workspaceStorage/5c61199dbbf8e66f0e395b878ce76a23/redhat.java/jdt_ws/jdt.ls-java-project/bin" Test 
60.0
0.0
```


## Getter 메소드

- 외부로 필드값을 전달하는 것이 목적
- 필드값을 가공해서 외부로 전달할 수도 있음

```java


public class SetterGetter {
    private double speed;

    public void setSpeed(double speed){
        if(speed < 0) {
            this.speed = 0;
            return ;
        } else {
            this.speed = speed;
        }
    }

    public double getSpeed() {
        double km = this.speed*1.6;
        return km; //mile 단위로 변환해서 반환하는 로직
    }

    public void showSpeed(){
        System.out.println(this.speed);
    }
}

```

`public double getSpeed()` 이것이 바로 Getter Class



## Getter와 Setter를 파이썬에서도?!

```python3
class Test:
    def __init__(self):
        self.__age = 0
    
    @property
    def age(self):
        return self.__age

    @age.setter
    def age(self, value):
        self.__age = value

if __name__ == "__main__":
    james = Test()
    james.age = 20
    print(james.age)
```

확인해보면..

self.__age 이므로 외부에서 임의로 수정 불가능 하지만.
@age.setter 와 @property를 붙여줬기 때문에 객체.속성으로 접근 가능하다.
