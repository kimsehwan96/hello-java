package CarPolynom;

public class Tire {
    //fields
    //@param
    public int maxRotation;
    public int accumatedRotation;
    public String location;

    //constructor
    public Tire(String location, int maxRotation) {
        this.location = location;
        this.maxRotation = maxRotation;
    }
    //method
    public boolean roll() {
        ++accumatedRotation;
        if (accumatedRotation < maxRotation ) {
            System.out.println(location + " Tire 수명 " + ( maxRotation - accumatedRotation ));
            return true;
        }
        else {
            System.out.println("***" + location + " Tire 펑크 ***");
            return false;
        }
    }
}
