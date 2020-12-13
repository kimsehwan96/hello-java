# 열거타입

- 데이터 중 한정된 값만 갖는 경우 열거형 사용

```java
Week today;
today = Week.FRI;
```

```java
public enum Week { //열거 타입 이름
    MON, //열거 타입 상수들
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN
}
```

- 실제 사용 예시

```java

//Week.java -> enum type
public enum Week {
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN
}
```

```java
//test code
public class WeekTest {
    private Week today;
    WeekTest(Week today){
        this.today = today;
    }
    public boolean isMatch(Week day){
        if(this.today == day){
            return true;
        }
        else {
            return false;
        }
    }
    public void showToday(){
        System.out.println(this.today);
    }
    public static void main(String[] args){
        WeekTest test = new WeekTest(Week.SUN);
        System.out.println(test.isMatch(Week.THU)); //false
        System.out.println(test.isMatch(Week.SUN)); //true
        test.showToday(); //SUN
    }
}
```