public class AryCopy {
    public static void main(String args[]){
        String[] oldStrArray = {"java", "array", "copy"};
        String[] newStrArray = new String[5];//5개 번지

        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
        //새로운 배열의 객체 주소에 기존 배열의 객체 주소를 그대로 넣어준다. == 했을때 똑같아야 겠지

        System.out.println(oldStrArray[0] == newStrArray[0]); //true
    }    
}
