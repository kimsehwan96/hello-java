## 매개변수의 다형성

- 메서드의 매개변수를 부모클래스를 넣고
    - 부모클래스를 상속받은 자식클래스를 구현하고
    - 자식클래스들을 매개변수로 넣어주면 자동 형변환 일어나면서
    - 자식클래스에서 구현한 메서드가 동작하는 다형성을 구현 !

<strong>Vehicle 클래스</strong>

```java
public class Vehicle {
    public void run() {//자식클래스에서 새로 구현될 메서드-> 추상메서드로 만드는게 더 좋아보임 ㅋㅋ
        System.out.println("차량이 달립니당");
    }
}
```


<strong>Bus 클래스</strong>

```java
public class Bus extends Vehicle {
    public void run() {
        System.out.println("버스가 달려용");
    }
}
```

<strong>Driver 클래스</strong>

```java
public class Driver {
    public void drive(Vehicle vehicle){
        vehicle.run(); //매개변수로 받은 vehicle 객체의 run메서드를 수행! 이는 매개변수의 클래스인 Vehicle 클래스를 상속받은 자식 클래스들의 run메서드 구현에 따라 다른 동작을 할 수 있음을 의미한다 즉 다형성이라구!
    }
}
```


<strong>테스트 클래스</strong>

```java
public class DriverTest {
    public static void main(String[] args){
        Driver driver = new Driver(); //드라이버 객체 생성
        Bus bus = new Bus(); //Vehicle을 상속받은 버스 객체 생성
        Taxi taxi = new Taxi(); //위와 동일
        /*
        Driver의 drive(Vehicle vehicle) 메서드가 밑에서 실행된다.  
        Vehicle 클래스를 상속받은 객체고, drive 메서드는   
        vehicle(객체).run() 메서드를 실행하는데  
        즉 자식 클래스의 객체에서 run() 메서드를 재정의하면 재정의한 동작들이 수행된다.   
        이건 내 생각에 베이스 클래스(Vehicle)의 run 메서드를 추상메서드로 만들고,   
        상속받은 자식 클래스에서 강제로 구현하게 해야 더 안전한 프로젝트 코드가 될 듯 
        */
        driver.drive(bus);
        driver.drive(taxi);
    }
}
```