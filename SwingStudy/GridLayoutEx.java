package SwingStudy;

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들


public class GridLayoutEx extends JFrame{
    public GridLayoutEx(){
        super("Grid Layout test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new GridLayout(4,3, 5, 5));// 첫 두번쨰 숫자는 행개수, 열개수, 그 뒤 두개는 패딩
        c.add(new JButton("1"));
        c.add(new JButton("2"));
        c.add(new JButton("3"));
        c.add(new JButton("4"));
        c.add(new JButton("5"));
        c.add(new JButton("6"));
        c.add(new JButton("7"));
        c.add(new JButton("8"));
        c.add(new JButton("9"));
        c.add(new JButton("."));
        c.add(new JButton("0"));
        c.add(new JButton("AC"));

        setSize(300,300);
        setVisible(true);

    }
    public static void main(String[] args){
        new GridLayoutEx();
    }
}
