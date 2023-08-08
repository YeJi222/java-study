package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] reverseChar = new char[str.length()];
		int j = 0;
		for(int i = str.length()-1 ; i >= 0 ; i--) {
			reverseChar[j++] = str.charAt(i);
		}
		
		return reverseChar;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}