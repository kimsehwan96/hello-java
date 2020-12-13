public class WeekTest {
    private Week today;
    WeekTest(Week today){
        this.today = today;
    }
    public boolean isMatch(Week day){
        if(this.today == day){
            return true;
        }
        else {
            return false;
        }
    }
    public void showToday(){
        System.out.println(this.today);
    }
    public static void main(String[] args){
        WeekTest test = new WeekTest(Week.SUN);
        System.out.println(test.isMatch(Week.THU));
        System.out.println(test.isMatch(Week.SUN));
        test.showToday();
    }
}
