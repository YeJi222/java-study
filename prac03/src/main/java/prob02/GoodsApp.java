package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS]; // 객체 배열
		
		// 인스턴스화 
		for(int i = 0 ; i < goods.length ; i++) {
			goods[i] = new Goods();
		}

		// 상품 입력
		for(int i = 0 ; i < goods.length ; i++) {
			String input = scanner.nextLine();
			String[] inputSplit = input.split(" ");
			
			goods[i].setName(inputSplit[0]);
			goods[i].setMoney(Integer.parseInt(inputSplit[1]));
			goods[i].setNum(Integer.parseInt(inputSplit[2]));
		}

		// 상품 출력 
		System.out.println();
		for(int i = 0 ; i < goods.length ; i++) {
			System.out.println(goods[i].getName() + "(가격: " + 
					goods[i].getMoney() + ")이 " + goods[i].getNum() + "개 입고 되었습니다.");
		}
		
		// 자원정리
		scanner.close();
	}
}
