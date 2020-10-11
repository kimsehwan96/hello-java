package SwingStudy;

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들


public class CalculatorLayout extends JFrame{
    public CalculatorLayout() {
        super("Caclulator !! ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Calculator cal = new Calculator();

        Container c = getContentPane();
        OperatorPad operator = new OperatorPad(cal);
        NumberPad numpad = new NumberPad(cal);
        NumberShow numshow = new NumberShow(cal);
        c.setLayout(new GridLayout(3,1));
        c.add(numshow);
        c.add(numpad);
        c.add(operator);

        setSize(600, 600);
        setVisible(true);

        

    }

    public static void main(String[] args){
        new CalculatorLayout();
    }
}

class NumberPad extends JPanel{
    public NumberPad(Calculator cal){
        setLayout(new GridLayout(4, 3, 5, 5));

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btndot = new JButton(".");
        JButton btn0 = new JButton("0");
        JButton btnClear = new JButton("AC");

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btndot);
        add(btn0);
        add(btnClear);

        MyActionListener listener = new MyActionListener(cal);
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);
        btn6.addActionListener(listener);
        btn7.addActionListener(listener);
        btn8.addActionListener(listener);
        btn9.addActionListener(listener);
        btndot.addActionListener(listener);
        btn0.addActionListener(listener);
        btnClear.addActionListener(listener);


        setSize(300,300);
        setVisible(true);
    }
}

class OperatorPad extends JPanel{
    public OperatorPad(Calculator cal){
        setLayout(new GridLayout(1, 4, 5, 5));
        JButton btnPlus = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");
        add(btnPlus);
        add(btnSub);
        add(btnMul);
        add(btnDiv);
        MyActionListener listener = new MyActionListener(cal);
        btnPlus.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnMul.addActionListener(listener);
        btnDiv.addActionListener(listener);
        setSize(150, 150);
        setVisible(true);
    }
}

class NumberShow extends JPanel{
    public NumberShow(Calculator cal){
        
        setLayout(new GridLayout(1,2));
        JLabel labelText = new JLabel("Reuslt :");
        JTextField labelResult = new JTextField(cal.return_str_buffer());
        add(labelText);
        add(labelResult);
        MyActionListener listener = new MyActionListener(cal, labelResult);
        labelResult.addActionListener(listener);
        setSize(100, 150);
        setVisible(true);

    }
}


///below line are Action Listener Logics...
// 이거는 외부 클래스로 만들어서 개 어려운 것 같은데?
class MyActionListener implements ActionListener{
    CalculatorLayout superClass;

    MyActionListener(CalculatorLayout superClass) {
        this.superClass = superClass;
    }
    public void actionPerformed(ActionEvent e){
        //JButton b = (JButton)e.getSource();
        //String tmp_buffer;
        //tmp_buffer = b.getText();
        //System.out.println(tmp_buffer);
        //cal.input_number(tmp_buffer);
        //System.out.println(cal.return_str_buffer());
    }
}

class MyResultActionListener implements ActionListener{
    Calculator cal;
    MyResultActionListener(Calculator cal) {
        this.cal = cal;
    }
    public void actionPerformed(ActionEvent e){
        JTextField l = (JTextField)e.getSource();
        l.setText(cal.return_str_buffer());
    }
}

class OperatingActionListener implements ActionListenr{
    Calculator cal;
    OperatingActionListener(Calculator cal){
        this.cal = cal;
    }
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        if (b.getText() == "+"){
            //cal.plus(x);
            System.out.println("어렵다..");
        }
    }
}

