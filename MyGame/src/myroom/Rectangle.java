package myroom;

public class Rectangle extends Shape
{
    //Shape 클래스에서 생성자를 정의했기 떄문에 상속 받은 코드에서도 정의한다.
    Rectangle(int x, int y, int sizeX, int sizeY) {
        super(x, y, sizeX, sizeY);
    }
            
    @Override
    public int whoIs() {
        // TODO Auto-generated method stub
        return  1;
    }

}
