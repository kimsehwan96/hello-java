package CalExam;

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorApp extends JFrame implements ActionListener
{
    Calculator cal = new Calculator(); // 구현한 계산기 인스턴스 생 ~ 성 
    JPanel textArea = new JPanel();
    JPanel operPad = new JPanel();
    JPanel reset = new JPanel();
    JButton btnPlus = new JButton("+");
    JButton btnSub = new JButton("-");
    JButton btnDiv = new JButton("/");
    JButton btnMul = new JButton("*");
    JButton btnReset = new JButton("RESET !!!");
    JTextField number = new JTextField(cal.return_str_buffer(), 20);
    JTextField result = new JTextField("결과 값 : ", 20);

    public CalculatorApp(){
        super("계 산 기 (김세환이 만듦)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(3,2));

        // 외부 클래스로 구현하면 이케하구, 근데 객체 전달 개념을 내가 잘 모르니까 그냥 
        // 내부 클래스에서 오버라이딩 해서 사용하는걸루 하자.. ㅜㅜ
        //MyActionListener listener = new MyActionListener(cal);

        btnPlus.addActionListener(this);
        btnSub.addActionListener(this);
        btnDiv.addActionListener(this);
        btnMul.addActionListener(this);
        btnReset.addActionListener(this);
        number.addActionListener(this);
        result.addActionListener(this);

        textArea.setSize(200,200);
        operPad.setLayout(new GridLayout(1,4));
        operPad.add(btnPlus);
        operPad.add(btnSub);
        operPad.add(btnDiv);
        operPad.add(btnMul);
        textArea.setLayout(new GridLayout(1,2));
        textArea.add(result);
        textArea.add(number);
        reset.setLayout(new GridLayout(1,1));
        reset.add(btnReset);

        c.add(textArea);
        c.add(operPad);
        c.add(reset);

        this.setSize(600,600);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new CalculatorApp();
    } 
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(number))
        {
            JTextField t = (JTextField)e.getSource();
            cal.input_number(t.getText());
            System.out.println(cal.return_str_buffer());
        }

        if (e.getSource().equals(btnPlus))
        {
            if (cal.result_buffer == 0)
            {
                cal.input_number(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
            if (cal.result_buffer != 0)
            {
                cal.plus(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
        }

        if (e.getSource().equals(btnSub))
        {
            if (cal.result_buffer == 0)
            {
                cal.input_number(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
            if (cal.result_buffer != 0)
            {
                cal.sub(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
        }

        if (e.getSource().equals(btnMul))
        {
            if (cal.result_buffer == 0)
            {
                cal.input_number(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
            if (cal.result_buffer != 0)
            {
                cal.multiply(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
        }

        if (e.getSource().equals(btnDiv))
        {
            if (cal.result_buffer == 0)
            {
                cal.input_number(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
            if (cal.result_buffer != 0)
            {
                cal.devide(number.getText());
                number.setText("0");
                result.setText("결과 값 :" + cal.return_str_buffer());
            }
        }



        if (e.getSource().equals(btnReset))
        {
            cal.reset();
            result.setText("계산기 초기화");
            number.setText("0");
        }


    }
    
}


// 이렇게 하면 객체 전달이 어려우니까 그냥 오버라이드 해서 하는걸로...(외부 클래스로 하지 않구..)
class MyActionListener implements ActionListener{
    Calculator superClass;
    MyActionListener(Calculator superClass){
        this.superClass = superClass;
    }
    public void actionPerformed(ActionEvent e){
        JTextField t = (JTextField)e.getSource();
        this.superClass.input_number(t.getText());
        System.out.println(this.superClass.return_str_buffer());
    }
}