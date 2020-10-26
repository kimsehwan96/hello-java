
public class SetterGetter {
    private double speed;

    public void setSpeed(double speed){
        if(speed < 0) {
            this.speed = 0;
            return ;
        } else {
            this.speed = speed;
        }
    }

    public double getSpeed() {
        double km = this.speed*1.6;
        return km; //mile 단위로 변환해서 반환하는 로직
    }

    public void showSpeed(){
        System.out.println(this.speed);
    }
}
