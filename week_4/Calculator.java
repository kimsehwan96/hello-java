package week_4;

public class Calculator {
    int int_result_buffer;
    double float_result_buffer;
    boolean buffer_mode; // 0(false)는 int 모드, 1(true) 는 float 모드, 디폴트는 정수모드
    
    Calculator() {
        this.int_result_buffer = 0;
        this.float_result_buffer = 0; // 정수 혹은 실수형 자료들을 0으로 초기화 해서 생성하고, 초기 인자는 필요 없다 (생성 당시에)
        this.buffer_mode = false;
    }
    public void show_current_status() {
        System.out.println("this is buffer mode " + this.buffer_mode);
        if (this.buffer_mode == true) {
            System.out.println("this is int buffer " + this.int_result_buffer);
        }
        else {
            System.out.println("this is float buffer " + this.float_result_buffer);
        }
    }
    public void reset_int_buffer(){
        this.int_result_buffer = 0;
        this.buffer_mode = true;
        System.out.println("reset int buffer");
    }
    public void reset_float_buffer(){
        this.float_result_buffer = 0;
        this.buffer_mode = false;
        System.out.println("reset float buffer");
    }
    public void add(int x, int y){
        this.reset_float_buffer();
        this.int_result_buffer = x + y;
        System.out.println(this.int_result_buffer);
    }

    public void add(int x){
        this.reset_float_buffer();
        this.int_result_buffer += x;
        System.out.println(this.int_result_buffer);
    }

    public void add(double x, double y) {
        this.reset_int_buffer();
        this.float_result_buffer = x + y;
        System.out.println(this.float_result_buffer);
    }

    public void add(double x){
        this.reset_float_buffer();
        this.float_result_buffer += x;
        System.out.println(this.float_result_buffer);
    }

    public void plus(double ...dbs){
        for (double d : dbs) {
            this.float_result_buffer += d;
        }
        System.out.println(this.float_result_buffer);
    }
}
