package CarPolynom;

public class HankookTire extends Tire {
    public HankookTire(String location, int maxRotation){
        super(location, maxRotation);
    }
    @Override
    public boolean roll() {
        ++accumatedRotation;
        if ( accumatedRotation < maxRotation ) {
            System.out.println(location + " Hankook Tire 수명 :" + ( maxRotation - accumatedRotation ));
            return true;
        } else {
            System.out.println("***" + location + " HankookTire 펑크 ***");
            return false;
            }
    }
}
