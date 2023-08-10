package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	/* 코드 작성 */
	public Person() { // Constructor 
		this.name = "";
		this.age = 12;
	}
	public Person(String name) { // Constructor 
		this.name = name;
		this.age = 12;
		numberOfPerson += 1;
	}
	public Person(int age, String name) { // 오버로딩 
		this.age = age;
		this.name = name;
		numberOfPerson += 1;
	}
	
	public void selfIntroduce(){
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "입니다.");
	}
	public static int getPopulation() {
		return numberOfPerson;
	}
}
