# 클래스 메소드

* 앞에서 구현한 CalExam 의 Calculator 클래스는 사실
* 인스턴스를 생성하지 않고도 구현이 가능 하다는걸 알았다.

- 이것을 가능하게 하는것이 바로 클래스 메소드 ! (파이썬에도 있다.)

```java

class NumberPrinter{
        private int myNum = 0;
        private static int statVar = 0; // 스태틱 클래스 멤버 변수 -> 클래스 및 모든 인스턴스가 '공유' 한다
    static void showInt(int n){
        System.out.println(n); // 클래스 메소드. NumberPrinter.showInt(5); 와 같이 접근 가능
    }
    void setMyNumber(int n){
        myNum = n;
    }
    void showMyNumber(){ //인스턴스 메소드
        showInt(myNum); //클래스 내부에서 클래스 메소드 호출
    }
}

class ClassMethod{
    public static void main(Strings[] args){
        NumberPrinter.showInt(20); //클래스의 스태틱 메서드이므로, 인스턴스를 생성하지 않고도 호출 가능
        NumberPinrter np = new NumberPrinter(); // 인스턴스 생성
        np.ShowInt(20); //인스턴스를 통해서도 접근 가능하다고 한당.
        np.statVar = 20;
        System.out.println(np.statVar); // 20
        NumberPrinter np_2 = new NumberPrinter(); // 새로운 인스턴스 하나 더 생성
        System.out.println(np_2.statVar);// 0이 아닌 20, 왜? 스태틱 변수는 모든 인스턴스 및 자기 클래스가 공유하는 변수니까 ! -> 힙 영역이 아닌 스택 영역에 저장 됨
    }
}

```

* 클래스 메소드는 
    - 외부에 기능을 제공하기 위한 메소드일 때
    - 인스턴스 변수의 값을 참조하거나 수정하지 않는 메소드 일때

```java
class SC{
        static dobule add(double n1, double n2){
            return n1 + n2; // 덧셈 기능만 제공하지, 인스턴스 변수 값 참조하거나 수정하지 않는다.
        }

}
```

* 인스턴스와 참조 변수

- 참조 변수는 스택에 생성
- 새로 생성된 인스턴스는 힙에 생성된다.