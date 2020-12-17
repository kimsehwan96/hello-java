public class Tire {
    //타이어가 갖는 필드들.
    private int lifeCycle; //내구도
    private int radius; // 인치수
    private TireMaker maker = null; //제조사
    
    Tire(int lifeCycle, int radius, TireMaker maker){
        this.lifeCycle = lifeCycle;
        this.radius = radius;
        this.maker = maker;
    }
    public boolean roll(int driveDistance){
        this.lifeCycle -= driveDistance;
        if (lifeCycle < 0){
            System.out.println("tire funked");
            return false; //
        }
        else {
            return true;
        }
    }
    
}
