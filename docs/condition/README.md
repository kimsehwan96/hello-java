# 조건문



## if, if - else, if - else if - else 문
```java


if (조건식) {
    //로직
}


if (조건식) {
    로직
}

else {
    //로직
}



if (조건식) {
    //로직
}
else if (조건식) {
    //로직
}

else {
    //로직
}

```

  

## switch 문

```java

switch (변수) {
    case 값 1:
        //로직
        break;
    case 값 2:
        // 로직
        break;
    default:
        //로직
}
```


## for, while, do-while, breeak, continue

```java

for (초기화식; 조건식; 증감식) {
    //로직
}
```

* for 문을 이용한 무한루프 예제

```java

import java.util.Scanner;

public class Forloop {
    public static void main(String[] argsv){
        int a = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        for (; true;){
            a = Integer.parseInt(sc.nextLine());
            if (a == -1){
                break;
            }
            sum += a;
            System.out.println(sum);
        }
    }
    
}
// -1이 입력되기 전까지 입력된 값을 계속해서 더하는 로직 , 초기화식, 증감식 모두 공백인 상태
```



