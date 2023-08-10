package exception;

// Unchecked Exception : 실행시점에 확인되는 예외로 예외처리를 하지 않아도 컴파일 됨 
public class UncheckedExceptionTest {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		for(int i = 0 ; i <= a.length ; i++) {
			System.out.println(a[i]);
		}
	}
}
