package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요: ");
		int num = scanner.nextInt();
		int init = 0;
		
		if(num % 2 == 0) { // 짝수 
			init = 2;
		} else { // 홀수 
			init = 1;
		}
		
		int result = 0;
		while(true) {
			result += init;
			init += 2;
			if(init > num) break;
		}
		System.out.println("결과 값 : " + result);
		
		scanner.close();
	}
}
