package fourthweek;
import java.util.Arrays;

import fundmentals.first;

public class AryTest {
    

    public static void main(String[] args){
        int[] scores = new int[30];
        for(int i = 0; i<30 ;i++ ){
            scores[i] = i+10;
        }
        System.out.println(scores[29]);
        System.out.println(Arrays.toString(scores));

        String[] names = null; //  변수 길이가 미정일때 이런식으로 하자
        names = new String[] { "1", "2", "3"};

        System.out.println(Arrays.toString(names));
        int num = scores.length;
        System.out.println(num);

        for (int data : scores) { // scores의 원소가 data.
            System.out.println(data);
        }
        String firstName = "kim";
        System.out.println(firstName);
        String firstName_2 = firstName;
        System.out.println(firstName_2);
        boolean test = (firstName == firstName_2);
        System.out.println(test);
        String firstName_3 = new String("kim");
        System.out.println(firstName == firstName_3);
        boolean result = firstName.equals(firstName_3);
        System.out.println(result);

        int[] ints = null;
        ints = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(Arrays.toString(ints));
    }



    
}
