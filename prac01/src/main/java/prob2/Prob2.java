package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int min = 1, max = 10;
		for(int i = min ; i < max ; i++) {
			for(int j = i ; j < i + max ; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
