package SwingStudy;

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들

public class CalculatorLayout extends JFrame{
    public CalculatorLayout() {
        super("Caclulator !! ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new GridLayout(3,1));
        c.add(new NumberShow());
        c.add(new NumberPad());
        c.add(new OperatorPad());

        setSize(600, 600);
        setVisible(true);
    }
    public static void main(String[] args){
        new CalculatorLayout();
    }
}

class NumberPad extends JPanel{
    public NumberPad(){
        setLayout(new GridLayout(4, 3, 5, 5));
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(new JButton("."));
        add(new JButton("0"));
        add(new JButton("AC"));
        setSize(300,300);
        setVisible(true);
    }
}

class OperatorPad extends JPanel{
    public OperatorPad(){
        setLayout(new GridLayout(1, 4, 5, 5));
        add(new JButton("+"));
        add(new JButton("-"));
        add(new JButton("*"));
        add(new JButton("/"));
        setSize(150, 150);
        setVisible(true);
    }
}

class NumberShow extends JPanel{
    public NumberShow(){
        setLayout(new GridLayout(1,2));
        add(new JLabel("Result :"));
        add(new JTextField(0));
        setSize(100, 150);
        setVisible(true);
    }
}