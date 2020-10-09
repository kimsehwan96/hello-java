package week_4;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;



public class Gui extends JFrame{
    private static final long serialVersionUID = -711163588504124217L;

    public Gui(){
        
        super("Calculator");
        
        setBounds(500, 500, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Calculator cal = new Calculator();

        Container contentPane = this.getContentPane();
        JPanel pane = new JPanel(new GridLayout(4,4));
        JPanel clearPane = new JPanel();
        JButton buttonAdd = new JButton(" + ");
        JButton buttonSub = new JButton(" - ");
        JButton buttonDevide = new JButton(" % ");
        JButton buttonMultifly = new JButton(" * ");
        JButton buttonClear = new JButton("Click to clear !");

        JTextField textPeriod = new JTextField(5);
        JLabel labelPeriod = new JLabel("Input Number");
        JLabel resultLabel = new JLabel("This is result ~!");
        JLabel resultNumberLabel = new JLabel("Here is number !");

        //resultLabel.addPropertyChangeListener(new ChangeListener(){
        //    
        //});
        pane.add(labelPeriod);
        pane.add(textPeriod);
        pane.add(resultLabel);
        pane.add(resultNumberLabel);
        pane.add(buttonAdd);
        pane.add(buttonSub);
        pane.add(buttonDevide);
        pane.add(buttonMultifly);

        contentPane.add(pane);

        setVisible(true);
    }
}
