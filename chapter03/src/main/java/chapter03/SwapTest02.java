package chapter03;

public class SwapTest02 {
	private static void swapFunc(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
				
		System.out.println("a=" + a + ", b=" + b);
		swapFunc(a, b);
		System.out.println("a=" + a + ", b=" + b);

	}

}
