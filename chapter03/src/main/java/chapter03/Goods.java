package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() { // 기본 생성자 
		// 초기화 코드 
		// 내부에서는 클래스 이름 생략 가능 
		// Goods.countOfGoods++;
		countOfGoods++;
	}
	
	public Goods(String name, int price, int countStock, int countSold) { // 생성자의 오버로딩(다형성)
		// 초기화 코드 
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; // this : 자기자신을 가리키는 것 
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	public void showInfo() {
		System.out.println(
				"상품이름 : " + name
				+ ", 가격 : " + price
				+ ", 재고개수 : " + countStock
				+ ", 팔린 개수 : " + countSold
		);
	}
	
	public int calcDiscountPrice(double discountRate) {
		return (int)(price * discountRate);
	}
}
