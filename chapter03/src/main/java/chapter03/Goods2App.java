package chapter03;

import mypackage.Goods2;

public class Goods2App {
	public static void mian(String[] args) {
		Goods2 goods = new Goods2();
		
		// public : 접근 제한이 없다 
		goods.name = "camera";
		
		// protected : 같은 패키지에서 접근이 가능 
		// 더 중요한 접근 제어는 자식에서 접근 가능하다 
		// goods.price = 10000; // (오류)
		
		// default : 같은 패키지에서 접근 가능 
		// goods.countStock = 10; // (오류)
		
		// private는 같은 클래스에서만 접근이 가능
		// goods.countSold = 20; // (오류)
	}
}
