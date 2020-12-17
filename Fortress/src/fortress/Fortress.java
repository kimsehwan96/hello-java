package fortress;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fortress extends JFrame {
    private Image backgroundImage = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();
    public static Game game = new Game();
    public Fortress(){
        setTitle("Fortress");
        setUndecorated(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MainPanel(backgroundImage));
        this.pack();
        setVisible(true);
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));



    }
    
    class MainPanel extends JPanel { //여기서 메인으로 그려지는건 다 동작하는거라고 보면 됨.
        private Image screenImage;
        private Graphics screenGraphic;
        private Image bg;
        private Image tank = new ImageIcon(Main.class.getResource("../images/tank.png")).getImage();
        public MainPanel(Image bg){
            this.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            this.bg = bg;
            this.addKeyListener(new KeyListener());
            this.setFocusable(true);
            game.start();
        }
        public Dimension getPreferredSize(){
            return new Dimension(1280, 720);
        }
        public void paint(Graphics g){
            screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            screenGraphic = screenImage.getGraphics();
            screenDraw((Graphics2D) screenGraphic);
            g.drawImage(screenImage, 0, 0, null);
        }
        public void screenDraw(Graphics2D g){
            g.drawImage(bg, 0, 0, null);
            game.playerDraw(g);
            paintComponents(g);
            this.repaint();
        }
    }
}
