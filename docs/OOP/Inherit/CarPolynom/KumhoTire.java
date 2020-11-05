package CarPolynom;

public class KumhoTire extends Tire {
    public KumhoTire(String location, int maxRotation){
        super(location, maxRotation);
    }
    @Override
    public boolean roll() {
        ++accumatedRotation;
        if ( accumatedRotation < maxRotation ) {
            System.out.println(location + " Kumho Tire 수명 :" + ( maxRotation - accumatedRotation ));
            return true;
        } else {
            System.out.println("***" + location + " Kumho Tire 펑크 ***");
            return false;
            }
    }
}
