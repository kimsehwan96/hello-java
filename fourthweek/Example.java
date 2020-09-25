package fourthweek;
import java.util.Random;
import java.util.Arrays;

public class Example {
    public static void main(String[] args)  {

        String strAry[] = args;

        int lottoNum[] = new int [6];
        Random ran = new Random();
        System.out.println(ran.nextInt(45)+1);
        for (int idx = 0; idx < lottoNum.length; idx++) 
        {
            lottoNum[idx] = ran.nextInt(45) + 1;
            for (int j = 0; j < idx ; j ++)  
            {
                if (lottoNum[idx] == lottoNum[j]) 
                {
                    idx --; // 이게 더 낫네
                }
            }
        }
        int myNum[] = new int[6];
        for (int i = 0; i<strAry.length; i ++ ) {
            myNum[i] = Integer.parseInt(strAry[i]);
        }

        int count = 0 ;
        
        for (int num : myNum) {
            for (int hit : lottoNum){
                if (num == hit) {
                    count ++;
                }
            }
        }



        System.out.println("this is lottol number : " +Arrays.toString(lottoNum));
        System.out.println("your input" + Arrays.toString(myNum));
        System.out.println("your hit count is " + count);
    }
}
