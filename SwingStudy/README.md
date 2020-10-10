# JAVA 의 GUI 개발을 돕는 Swing에 대해서 공부하기

## 컨테이너와 컴포넌트

- 컨테이너는 다른 GUI를 포함 할 수 있는 컴포넌트임
- 컨테이너는 컴포넌트이자 동시에 컨테이너다.
- 컨테이너가 되기 위해서는 java.awt.Container 상속받아야 함.

```java
import java.awt.Container
```

- AWT 컨테이너 : Frame, Panel, Applet, Dialog, Window
- 스윙 컨테이너 : JFrame, JPanel, JApplet, JDialog, JWindow

- 컴포넌트
    - 컴포넌트는 다른 컴포넌트를 포함 할 수 없고, 컨테이너에 포함되어야 출력 된다
    - Component 클래스에는 모든 컴포넌트의 공통적인 속성과 기능이 작성되어 있음
    - 컴포턴트의 크기, 모양 등등에 관한 정보를 관리하는 멤버 변수와, 다양한 메서드를 제공함
    - 순수 스윙 컴포넌트는 javax.swing.Jcomponent를 상속받는다.

- 최상위 컨테이너
    - 컨테이너중에서 다른 컨테이너에 속하지 않고도 독립적으로 화면에 출력되는 컨테이너를 최상위 컨테이너라고 함
    - JFrame, JDialog, JApplet 이 세가지가 포함 된다.
    - 이를 제외한 나머지 컴포넌트들은 다른 컨테이너에 부착되어야 하고, 결국엔 최상위 컨테이너에 부착되어야 한다.


## 스윙 프레임가 컨텐트 팬

- 스윙 프레임은 모든 스윙 컴포넌트들을 담는 최상위 컨테이너다.
- 스윙 프레임이 출력 될 때 스윙 프레임 내에 부착된 모든 컴포넌트들이 화면에 출력된다.
- 컴포넌트들은 스윙 프레임 없이 독립적으로 화면에 출력 할 수 없다.


```java

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들

public class FirstTest extends JFrame {
    public FirstTest() {
        setTitle("Swing Frame test");
        setSize(300, 300);
        setVisible(true);
    }
public static void main(String[] args){
    FirstTest frame = new FirstTest();
} 
}
```

이런식으로 하면 300x300 프레임이 출력된다. 이 예제에서는 프레임 클래스를 구현한 코드 안에 main 메서드를 만들어서 출력했지만, 내가 만들 구조는 이 프레임을 실행 시킬 코드를 분리할것이다.

* main 메서드는 무조건 간단하게, 무언가 중요한 로직이 안들어 가는 것이 swing기반 응용프로램에서 중요하다고 한다.



```java

package SwingStudy;

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들


public class FirstTest extends JFrame {
    public FirstTest() {
        super("타이틀 붙이기"); // super() -> JFrame(title문자열) 생성자를 호출해서 다는 것 
        //setTitle("Swing Frame test"); super() 혹은 setTitle 둘다 동일함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); // 컨텐트 팬을 알아내는 로직
        contentPane.setBackground(Color.BLACK); // 배경 색 검은색으로
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("Ok"));
        contentPane.add(new JButton("Cancle"));
        contentPane.add(new JButton("Ignore"));

        setSize(300, 300);
        setVisible(true);
    }
public static void main(String[] args){
    FirstTest frame = new FirstTest();
} 
}

```

![1](images/1.png)

- 출력 화면
- contentPane을 알아내고, 여기에 세개의 버튼을 순서대로 붙인 화면이다.