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
