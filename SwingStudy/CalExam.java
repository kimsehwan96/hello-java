package SwingStudy;

import javax.swing.*; // 스윙 컴포넌트들 사용하기 위해서
import java.awt.*; // 폰트 등 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // 이벤트 처리에 필요한 기본 클래스들의 경로명
import javax.swing.event.*; // 스윙 이벤트 처리에 필요한 부분들


public class CalExam extends JFrame{
    public CalExam() {
        super("계 산 기 (김세환이 만듦)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Calculator cal = new Calculator(); // 구현한 계산기 인스턴스 생 ~ 성 
        
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(2,4));
        JPanel textArea = new JPanel();
        JPanel operPad = new JPanel();
        JButton btnPlus = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnDiv = new JButton("/");
        JButton btnMul = new JButton("*");
        JTextField number = new JTextField(cal.return_str_buffer(), 20);

        MyActionListener listener = new MyActionListener(cal);

        btnPlus.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnDiv.addActionListener(listener);
        btnMul.addActionListener(listener);
        number.addActionListener(listener);

        textArea.setSize(200,200);
        operPad.setLayout(new GridLayout(1,4));
        operPad.add(btnPlus);
        operPad.add(btnSub);
        operPad.add(btnDiv);
        operPad.add(btnMul);
        textArea.setLayout(new GridLayout(1,1));
        textArea.add(number);

        c.add(textArea);
        c.add(operPad);

        setSize(600,600);
        setVisible(true);
    }

    public static void main(String[] args){
        new CalExam();
    }
}

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