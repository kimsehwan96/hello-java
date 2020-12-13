# 배열

- 배열, 인덱스, 배열 길이, 배열 선언, 배열 생성, 다차원 배열, 향상된 for 문

- 배열
    - 데이터를 연속된 공간에 나열하고 각 데이터에 index를 부여한 자료구조
    - 같은 타입 데이터만 저장 가능
    - 한번 생성한 배열은 길이를 늘이거나 줄일 수 없다.

- for 문을 이용한 배열 처리

```java
int sum = 0;
for(int i = 0; i<30; i++){
    sum += score[i];
}
int avg = sum / 30;

```


- 배열 변수 선언

```java
int[] intArray;
int intArray[];
```

- 둘 다 가능.

- 참조할 배열 객체가 없는 경우
`타입[] 변수 = null;` 이렇게 초기화.


- 배열 생성
- 값 목록으로
`타입 [] 변수 = {값0, 값1, 값2 ...};`

- new 연산자로
`int[] scores = new int[30];`


- 배열 복사

```java
public class AryCopy {
    public static void main(String args[]){
        String[] oldStrArray = {"java", "array", "copy"};
        String[] newStrArray = new String[5];//5개 번지

        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
        //새로운 배열의 객체 주소에 기존 배열의 객체 주소를 그대로 넣어준다. == 했을때 똑같아야 겠지

        System.out.println(oldStrArray[0] == newStrArray[0]); //true
    }    
}

```


- 향상된 for문
    - 배열이나 컬렉션을 좀 더 쉽게 처리
    - 반복 실행 위해 루프 카운터 변수나 증감식 사용하지 않는다.

```java
public class Iter {
    public static int addvancedFor(int[] iter){ //배열을 인자로 받는다.
        int sum = 0;
        for(int score : iter){ //향상된 for문. for(타입 변수 : 배열){ 실행문 }
            sum = sum + score;
        }
        return sum;
    }
    public static void main(String[] args){
        int[] testAry = {1, 2, 3, 4, 5};
        int result;
        result = Iter.addvancedFor(testAry);
        System.out.println(result);//결과 15
    }
}
```