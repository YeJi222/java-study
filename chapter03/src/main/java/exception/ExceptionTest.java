package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("Some Code1");
		
		// Checked Exception : 컴파일할 때 확인되는 예외로 예외처리가 필요함 
		try {
			System.out.println("Some Code2");
			int result = (1 + 2 + 3) / b;
			System.out.println("Some Code3");
			
		} catch(ArithmeticException ex) {
			// 예외 처리
			// 1. 로깅
			System.out.println("error: " + ex);
			// 2. 사과 
			System.out.println("미안합니다");
			// 3. 정상종료
			// System.exit(0);
			return; // main 함수에서 
		} finally {
			System.out.println("자원정리: file close, socket close, ...");
		}
		System.out.println("Some Code4");

	}

}
