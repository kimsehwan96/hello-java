# OOP Review

```java

public class ClassNaame {
    //필드
    int filename;

    ClassName(){ //생성자}
    
    //메서드
    void methodName() { //로직 }
}

```

- 필드
    - 객체의 고유 데이터
    - 객체가 가져야 할 부품
    - 객체의 현재 상태 데이터 등을 저장

- e.g : 자동차 객체
    - 고유 데이터   
        - 제작사
        - 모델
        - 색깔
        - 최고 속도
    - 상태 데이터
        - 현재 속도
        - 엔진 회전수
    - 부품
        - 차체
        - 엔진
        - 타이어

```java
public class Car {
    String Company;
    String model;
    String color;
    int maxSpeed;

    int speed;
    int rpm;

    //여기는 사용자 정의 타입(클래스) 필드들이 들어가는거겠지.
    Body body;
    Engine engine;
    Tire tire;
}

```

- 필드 선언
    - 클래스 중괄호 블록 어디서든 가능
    - 생성자와 메서드 중괄호 블록 내에서는 선언 불가.
    - 변수가 아님ㅁ에 유의.

- 필드 사용
    - 필드 값을 읽고 변경하는 작업
    - 클래스 내부 생성자 및 메소드에서 사용하는 경우 : 필드 이름ㅁ으로 읽고 변경
    - 클래스 외부에서 사용하는 경우 -> 클래스로부터 객체 생성한 뒤 필드 사용

