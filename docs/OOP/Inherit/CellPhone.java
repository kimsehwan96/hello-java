public class CellPhone {
    String model;
    String color;

    void powerOn() { System.out.println("Power on ! " );}
    void powerOff() { System.out.println("Power OFF !!"); }
    void bell() { System.out.println("Bell wing wing ! " ); }
    void sendVoice(String message) { System.out.println("me : " + message); } 
    void receiveVoice(String message) { System.out.println("another : " + message ); }
    void hangUp() { System.out.println("ended call !"); }

    public static void main(String[] args){
        CellPhone cellphone = new CellPhone();
        cellphone.model = "iphone 3";
        cellphone.color = "space gray";

        cellphone.powerOn();
        cellphone.sendVoice("Hello there!");
        System.out.println(cellphone.model + ' ' + cellphone.color);
    }
}
