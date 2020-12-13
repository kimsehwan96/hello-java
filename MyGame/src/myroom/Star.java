package myroom;

public class Star extends Shape implements DrawLineShape{

    int[] dataSet = new int[MAX_LINE];
    int lineVolume = 6;

    Star(int x, int y, int sizeX, int sizeY) {
        super(x, y, sizeX, sizeY);
    }

    @Override
    public void drawLineDataSet() {
        dataSet[0] = x;
        dataSet[1] = y;
        dataSet[2] = x - sizeX / 2;
        dataSet[3] = y + (int)(sizeY*0.75);

        dataSet[4] = x; 
        dataSet[5] = y;
        dataSet[6] = x + sizeX/2;
        dataSet[7] = y + (int)(sizeY*0.75);

        dataSet[8] = x - sizeX / 2;
        dataSet[9] = y + (int)(sizeY*0.75);
        dataSet[10] = x + sizeX/2;
        dataSet[11] = y + (int)(sizeY*0.75);

        dataSet[12] = x;
        dataSet[13] = y + sizeY;
        dataSet[14] = x - sizeX/2;
        dataSet[15] = y + (int)(sizeY*0.25);
    
        dataSet[16] = x;
        dataSet[17] = y + sizeY;
        dataSet[18] = x + sizeX/2;
        dataSet[19] = y + (int)(sizeY*0.25);

        dataSet[20] = x - sizeX/2;
        dataSet[21] = y + (int)(sizeY*0.25);
        dataSet[22] = x + sizeX/2;
        dataSet[23] = y + (int)(sizeY*0.25);

    }

    @Override
    public int whoIs() {
        // TODO Auto-generated method stub
        return 4;
    }
    
}
