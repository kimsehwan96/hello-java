## 자바 텀프로젝트 제출을 위한 포트리스 게임 만들기


## 현재까지의 구현 내용

- 디폴트 메뉴바 삭제 및 Background 이미지 삽입
- 스레드를 이용한 탱크 움직임 구현 (좌,우)

- 키가 눌릴때만 boolean이 true가 되어서 해당 작업을 실행함

![1](images/1.png)


#### 소스코드

```java
package fortress;

public class Main {
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static void main(String[] args) throws Exception {
        new Fortress();
    }
}
```

- 코드 메인 진입점. Fortress라는 객체를 새로 생성해서 JFrame을 시작한다.



```java
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
```

- JFrame을 상속받은 Fortress 디폴트 메뉴바를 삭제하였다.
- MainPanel이라는 내부 클래스를 생성히고, 여기서 탱크의 이미지 및 배경사진을 draw 한다.
- Game이라는 클래스의 메서드를 호출하는 부분이 다수 있다 (game.start(), game.playerDraw)
- 키 리스너를 등록하여 키의 입력값을 받을 수 있도록 구현했다.


```java
package fortress;


import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.ImageIcon;

public class Game extends Thread {
    private Image tank = new ImageIcon(Main.class.getResource("../images/tank.png")).getImage();
    private Image fire;
    private int playerX, playerY, playerHP;
    private int playerWidth, playerHeight;
    private int score, speed;
    private boolean up, down, left, right, shooting;

    public void playerDraw(Graphics2D g) {
        g.drawImage(tank, playerX, playerY, null); // 탕크그리기
    }

    @Override
    public void run() {
        this.playerX = 0;
        this.playerY = 500;
        this.playerHP = 1000;
        this.speed = 10;
        this.left = false;
        this.right = false;
        this.up = false;
        this.shooting = false;
        this.down = false;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                this.KeyProcess();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void KeyProcess() {
        if (right && playerX - speed < 1280) {
            playerX += speed;
            System.out.println("right pressed");
            System.out.println("X : " + playerX + "Y : " + playerY);
        }
        if (left && playerY - speed < 720) {
            playerX -= speed;
            System.out.println("left pressed");
            System.out.println("X : " + playerX + "Y : " + playerY);
        }
    }

    public void true_Up() {
        if (up)
            return;
        up = true;
    }

    public void true_Down() {
        if (down)
            return;
        down = true;
    }

    public void true_Left() {
        if (left)
            return;
        left = true;
    }

    public void true_Right() {
        if (right)
            return;
        right = true;
    }

    public void true_Shooting() {
        if (shooting)
            return;
        shooting = true;
    }

    public void false_Up() {
        if (!up)
            return;
        up = false;
    }

    public void false_Down() {
        if (!down)
            return;
        down = false;
    }

    public void false_Left() {
        if (!left)
            return;
        left = false;
    }

    public void false_Right() {
        if (!right)
            return;
        right = false;
    }

    public void false_Shooting() {
        if (!shooting)
            return;
        shooting = false;
    }
}

```

- 스레드를 상속받은 Game class
- JFrame 메인 로직(스레드)의 흐름과 분리하여 탱크그림을 동적으로 그려내는 코드를 담았다.
- 키 리스너를 통해 들어온 정보를 바탕으로 하여 짧은 순간마다 tank의 위치를 A혹은 D가 눌릴 때 마다 좌우로 이동된 탱크의 그림을 그리도록 구현했다.



```java
package fortress;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyListener extends KeyAdapter{
    @Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W :
            Fortress.game.true_Up();
				break;
			case KeyEvent.VK_S :
            Fortress.game.true_Down();
				break;
			case KeyEvent.VK_A :
            Fortress.game.true_Left();
				break;
			case KeyEvent.VK_D :
            Fortress.game.true_Right();
				break;
			case KeyEvent.VK_SPACE :
            Fortress.game.true_Shooting();
				break;
		}
    }
    
    @Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_W :
            Fortress.game.false_Up();
				break;
			case KeyEvent.VK_S :
            Fortress.game.false_Down();
				break;
			case KeyEvent.VK_A :
            Fortress.game.false_Left();
				break;
			case KeyEvent.VK_D :
            Fortress.game.false_Right();
				break;
			case KeyEvent.VK_SPACE :
            Fortress.game.false_Shooting();
				break;
		}
	}
}

```

- 좋은 디자인의 코드는 아니지만, 키가 눌렸을 때 Fortress 클래스 내의 game 객체의 메서드들을 호출하도록 구현했다.




- 많은 시간을 투자하지 못해서 간단하게 스레드로 로직을 분리하고, JFrame을 상속받아서 구현한 코드만 작성했다.

- 객체지향의 컨셉이 많이 녹아있지는 않지만, 향후 재미삼아 개발할때 그러한 디자인 패턴들이나 객체지향적인 컨셉들을 많이 녹아내고 싶다.
