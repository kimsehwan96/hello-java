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
