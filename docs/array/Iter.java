public class Iter {
    public static int addvancedFor(int[] iter){
        int sum = 0;
        for(int score : iter){
            sum = sum + score;
        }
        return sum;
    }
    public static void main(String[] args){
        int[] testAry = {1, 2, 3, 4, 5};
        int result;
        result = Iter.addvancedFor(testAry);
        System.out.println(result);
    }
}
