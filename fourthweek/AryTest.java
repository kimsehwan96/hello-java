package fourthweek;
import java.util.Arrays;

public class AryTest {
    

    public static void main(String[] args){
        int[] scores = new int[30];
        for(int i = 0; i<30 ;i++ ){
            scores[i] = i+10;
        }
        System.out.println(scores[29]);
        System.out.println(Arrays.toString(scores));

        String[] names = null;
        names = new String[] { "1", "2", "3"};

        System.out.println(Arrays.toString(names));
        int num = scores.length;
        System.out.println(num);

        for (int data : scores) { // scores의 원소가 data.
            System.out.println(data);
        }
    }



    
}
