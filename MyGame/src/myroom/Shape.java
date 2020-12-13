package myroom;

public abstract class Shape{
    int x;
    int y;
    int sizeX;
    int sizeY;
    int speedX;
    int speedY;

    Shape(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        speedX = (int)(Math.random()*10)+1;
        speedY = (int)(Math.random()*10)+1;
    }
    
    void moveShape() {
        boundaryCheck(x+speedX, y+speedY);
        x += speedX;
        y += speedY;
    }

    void boundaryCheck(int movingX, int movingY){
        if(movingX > 500) {
            speedX = -speedX;
        }
        else if (movingX < 0){
            speedX = -speedX;
        }
        if(movingY > 500) {
            speedY = -speedY;
        }
        else if (movingX < 0){
            speedY = -speedY;
        }
    }

    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
    public abstract int whoIs();
}
