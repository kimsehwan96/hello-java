public class parseTest {
    public StringBuilder buf;
    parseTest() {
       this.buf = new StringBuilder("");
    }
    public void PutBuf(String x) {
        this.buf.append(x);
        System.out.println(this.buf);
    }
    public void Reset(){
        this.buf.setLength(0);
    }

    public static void main(String[] args){
        parseTest test = new parseTest();
        test.PutBuf("Hi");
        test.PutBuf("Oh my got");
        test.PutBuf("Hello");
        test.Reset();
        test.PutBuf("1");
        test.PutBuf("4.5");
        Double db = Double.parseDouble(test.buf.toString());
        System.out.println(db);
    }
}
