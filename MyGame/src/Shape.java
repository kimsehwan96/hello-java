public class Shape {
    int x;
    int y;
    int sizeX;
    int sizeY;
    Shape(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
}