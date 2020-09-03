import java.util.*;
import java.lang.*;
import java.io.*;

class IntString
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(1+2);
		/*
		 * 따옴표 없는숫자 숫자로 인
		 */
		System.out.println(1.2 + 1.3);
		System.out.println(2*5);
		System.out.println(6/2);
		System.out.println('안');
		/*
		  자바는 문자와 문자열을 구분하는데, 문자는 한글자를 의미하고
		  문자열은 여러개의 문자를 의미한다.
		  문자는 ' '로 감싼
		 */
		System.out.println("안녕하세");
		/*
		 * 쌍따옴표를 출력하고 싶다면 \ 을 이용해 이스케이프 시
		 */
		System.out.println(" 이것은 큰 따옴표 \"");
		/*
		 여러 줄을 표시하고 싶다면 \ 을 이용하고, 문자열끼리 더하는건 +
		 */
	}
	
}