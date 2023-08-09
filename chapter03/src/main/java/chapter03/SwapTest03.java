package chapter03;

import mypackage.Value;

public class SwapTest03 {
	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);
				
		System.out.println("a=" + a.val + ", b=" + b.val);
		swapFunc(a, b);
		System.out.println("a=" + a.val + ", b=" + b.val);
	}
	
	private static void swapFunc(Value a, Value b) { // 객체를 저장하면 데이터가 힙 영역에 저장 
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}
}
