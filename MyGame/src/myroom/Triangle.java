package myroom;

public class Triangle extends Shape {

    int[] dataSet = new int[MAX_LINE];
    int lineVolume;

    Triangle(int x, int y, int sizeX, int sizeY) {
        super(x, y, sizeX, sizeY);
        drawLineDataSet(3);
    }

    @Override
    public int whoIs() {
        return 3;
    }

    @Override
    public void drawLineDataSet(int lineVolume) {
        this.lineVolume = lineVolume;
        dataSet[0] = x;
        dataSet[1] = y;
        dataSet[2] = x - sizeX / 2;
        dataSet[3] = y + sizeY;

        dataSet[4] = x; 
        dataSet[5] = y;
        dataSet[6] = x + sizeX/2;
        dataSet[7] = y + sizeY;

        dataSet[8] = x - sizeX / 2;
        dataSet[9] = y + sizeY;
        dataSet[10] = x + sizeX/2;
        dataSet[11] = y + sizeY;
    }
    
}
