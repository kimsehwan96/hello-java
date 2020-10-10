package SwingStudy;


public class Calculator {
    double result_buffer;

    Calculator() {
        this.result_buffer = 0; // 계산기 생성시 버퍼 0으로 초기화.
    }
    public void show_result() {
        System.out.println(this.result_buffer);
    }

    public String return_str_buffer() {
        //Double.parseDouble(double1);
        //String.valueOf(dobule2);
        return String.valueOf(this.result_buffer);
    }

    public double return_buffer(){
        return this.result_buffer;
    }
    //reset은 단 2개의 인자만 더하기, 빼기, 나누기, 곱하기가 들어왔을 때 그 두 수만 계산한다고 생각하고 버퍼를 초기화 함
    // 하나의 인자만 넣었을 경우 기존 버퍼에 저장되어있는 값을 대상으로 계산한다고 생각하고 구현 함.
    public void reset(){
        this.result_buffer = 0;
        System.out.println("buffer reset!!");
    }

    // 인터페이스 개념. 누군가 계산기 버퍼에 어떤 값을 넣고 싶을때 멤버 변수에 직접 접근하는 것이 아닌, 메서드를 통해서 접근하도록.
    public void input_number(double x){
        this.result_buffer = x;
        this.show_result();
    }

    public void input_number(String x){
        this.result_buffer = Double.parseDouble(x);
    }

    public void plus(double x){
        this.result_buffer += x;
        this.show_result();
    }

    // 연산 기능들은 여러 인자들을 받을 수 있게 구현한다.
    public void plus(double ...dbs){
        this.reset();
        for (double d : dbs) {
            this.result_buffer += d;
        }
        this.show_result();
    }

    public void sub(double ...dbs){
        this.reset();
        for (double d : dbs) {
            this.result_buffer -= d;
        }
        this.show_result();
    }

    public void sub(double x){
        this.result_buffer = this.result_buffer - x;
        this.show_result();
    }

    public void devide(double ...dbs){
        this.reset();
        for (double d : dbs){
            if(d == dbs[0]){
                this.result_buffer = d;
            }
        this.result_buffer = this.result_buffer / d;
        }
        this.show_result();
    }

    public void devide(double x, double y){
        this.reset();
        this.result_buffer = x / y;
        this.show_result();
    }

    //if just one argument given in devide -> do devide with result buffer
    public void devide(double x){
        if (x != 0.0){
        this.result_buffer = this.result_buffer / x;
        this.show_result();
        }
        else { // 0으로 나누려고 시도하는 상황을 try catch가 아닌 if 문으로 분기처리 함.
            System.out.println("error occured because you try to devicde number with 0!");
        }

    }

    public void multiply(double ...dbs){
        this.reset();
        for (double d : dbs){
            // 최초에 0번째 인덱스 값을 넣어준다 -> 버퍼를 처음에 0으로 초기화 했으니까!
            if (d == dbs[0]){
                this.result_buffer = d;
            }
            this.result_buffer *= d;
        }
        this.show_result();
    }
    // if just on argumnent  given in multiply -> do multiply with result buffer
    public void multiply(double x){
        this.result_buffer = this.result_buffer * x;
        this.show_result();
    }
}
