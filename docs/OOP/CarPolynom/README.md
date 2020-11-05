# 다형성 테스트 코드
- 좀 어렵긴 한데

- 어떤 클래스의 필드의 속성을 부모클래스로 정의하고
- 자식 클래스를 만들어놔서, 부모클래스가 들어갈 부분에 자식 클래스를 넣는다.

- 그니까 차라는 클래스 안에 부품중 타이어는 우선 부모 클래스로 생성해놓고
- 차의 타이어는 여러 각종 특정한 파라미터들이 다를 거니까
- 특정 제조사의 타이어 라는 자식 클래스를 만들어 놓는다.

- 차라는 클래스는 타이어의 부모클래스를 통한 객체를 생성해놓고,
- 이 부모클래스를 통한 객체 대신에 자식클래스의 객체를넣는다.

* 이 예제에서는 부모클래스로 만든 객체가 들어가있다가, 자식 객체가 들어가는 컨셉이다.


<strong>자동차 클래스 코드</strong>

```java

package CarPolynom;

public class Car {
    //자동차의 각 타이어는 Tire라는 클래스의 객체들이 생성당시에 들어가게 된다
    Tire frontLeftTire = new Tire("앞왼쪽", 6);
    Tire frontRightTire = new Tire("앞오른쪽", 2);
    Tire backLeftTire = new Tire("뒤왼쪽",3);
    Tire backRightTire = new Tire("뒤오른쪽", 4);
    //타이어의 수명이 다하면 stop()메서드 호출 및 특정 정수 리턴 (예제 코드에서 어느 위치의 타이어인지 구분할 값)
    int run() {
        System.out.println("자동차 달린당");
        if(frontLeftTire.roll()==false) { stop(); return 1; };
        if(frontRightTire.roll()==false) { stop(); return 2; };
        if(backLeftTire.roll()==false) { stop(); return 3; };
        if(backRightTire.roll()==false) { stop(); return 4; };
        return 0;
    }
    //타이어가 터졌을 때 자동차가 멈추는 것을 구현
    void stop() {
        System.out.println("자동차가 멈췃따");
    }
}
```

<strong>타이어 클래스 코드</strong>

```java

package CarPolynom;

public class Tire {
    //fields
    //@param
    public int maxRotation;
    public int accumatedRotation;
    public String location;
    //타이어가 갖는 속성들, 수명(맥스로테이션), 현재 로테이션 값, 그리고 어느 위치 타이어인지 필드를 갖는다

    //constructor
    public Tire(String location, int maxRotation) {
        if maxRotation > 0 {
            this.location = location;
        }
        else {
            //예외처리 코드가 들어가야겠쥬
            //요즘 공부하다 배웠는데, 이런 인자 입력은
            //getter setter 개념처럼 vaildation check로직이 들어가야 안전합니다.
        }
        //this.location = location; 이게 기존코드인데 음수도 들어갈 수 있겠져 <- 우리가 원하지 않는 동작을 야기합니다.
        this.maxRotation = maxRotation;
    }//생성자로 타이어의 위치와, 최대 수명을 입력 받을 수 있게 함
    //method
    // 타이어가 돌면 현재 수명이 증가하고, 최대 수명에 도달하면 false를 리턴하는 로직입니다.
    public boolean roll() {
        ++accumatedRotation;
        if (accumatedRotation < maxRotation ) {
            System.out.println(location + " Tire 수명 " + ( maxRotation - accumatedRotation ));
            return true;
        }
        else {
            System.out.println("***" + location + " Tire 펑크 ***");
            return false;
        }
    }
}

```

<strong>한국타이어 클래스 코드</strong>

```java
package CarPolynom;

public class HankookTire extends Tire {
    public HankookTire(String location, int maxRotation){
        super(location, maxRotation);
    } //부모 클래스와 거의 동일하구 부모 클래스의 location, maxRotation로직을 상속받은거주
    //this.location = location과
    //this.maxRotation = maxRotaton 을 또 코딩하지 않으려구 넣은겁니다.
    @Override //오버라이딩 하는 이유는 이게 어느 제조사 타이어인지 알려줄라구유
    public boolean roll() {
        ++accumatedRotation;
        if ( accumatedRotation < maxRotation ) {
            System.out.println(location + " Hankook Tire 수명 :" + ( maxRotation - accumatedRotation ));
            return true;
        } else {
            System.out.println("***" + location + " HankookTire 펑크 ***");
            return false;
            }
    }
}

```
<strong>테스트 클래스 코드</strong>

```java
package CarPolynom;

public class CarExample {
    public static void main(String[] args) {
        Car car = new Car(); //차라는 객체를 하나 생성합니다.

        for(int i=1; i<=5; i++) {
            int problemLocation = car.run();
            switch(problemLocation) {
                case 1:
                System.out.println("앞 왼쪽 HT로 교체");
                car.frontLeftTire = new HankookTire("앞왼쪽", 15); //타이어가 터지면 Tire필드의 객체를 Tire의 자식 객체로 대체해주는 로직이쥬. 이게 다형성이라구 합니다.
            break;
                case 2:
                System.out.println("앞 오른쪽 KT로 교체");
                car.frontLeftTire = new KumhoTire("앞오른", 13);
            break;
                case 3:
                System.out.println("뒤 왼쪽 HT로 교체");
                car.frontLeftTire = new HankookTire("뒤왼쪽", 14);
            break;
                case 4:
                System.out.println("뒤 오른쪽 KT로 교체");
                car.frontLeftTire = new KumhoTire("뒤오른쪽", 17);
            break;
            }
        }
    }
}
```

>> 출력

```console
자동차 달린당
앞왼쪽 Tire 수명 5
앞오른쪽 Tire 수명 1
뒤왼쪽 Tire 수명 2
뒤오른쪽 Tire 수명 3
자동차 달린당
앞왼쪽 Tire 수명 4
***앞오른쪽 Tire 펑크 ***
자동차가 멈췃따
앞 오른쪽 KT로 교체
자동차 달린당
앞오른 Kumho Tire 수명 :12
***앞오른쪽 Tire 펑크 ***
자동차가 멈췃따
앞 오른쪽 KT로 교체
자동차 달린당
앞오른 Kumho Tire 수명 :12
***앞오른쪽 Tire 펑크 ***
자동차가 멈췃따
앞 오른쪽 KT로 교체
자동차 달린당
앞오른 Kumho Tire 수명 :12
***앞오른쪽 Tire 펑크 ***
자동차가 멈췃따
앞 오른쪽 KT로 교체
```

