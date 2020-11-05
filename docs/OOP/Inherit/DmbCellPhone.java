public class DmbCellPhone extends CellPhone { // CellPhone 클래스를 상속받음
    int channel; //필드
    
    //생성자
    DmbCellPhone(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    //메서드
    
    void turnOnDmb() {
        System.out.println("Channel : " + channel + "start recevice");
    }

    void chnageChannelDmb(int channel) {
        this.channel = channel;
        System.out.println("changed channel : " + channel);
    }

    void turnOffDmb() {
        System.out.println("DMB turn off !!!!");
    }

    public static void main(String[] args){
        DmbCellPhone dmbcellphone = new DmbCellPhone("S10", "Blue", 50);
        dmbcellphone.turnOnDmb();
        dmbcellphone.chnageChannelDmb(123);
        dmbcellphone.receiveVoice("Hello dmb! I'm iphone from cellphone");        
    }
}
