package chapter04;

public class SingletonTest {
	public static void main(String[] args) {
		SingleTon singleton1 = SingleTon.getInstance();
		SingleTon singleton2 = SingleTon.getInstance();
		
		System.out.println(singleton1 == singleton2);
	}
	

}
