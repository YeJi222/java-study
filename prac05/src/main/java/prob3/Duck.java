package prob3;

public class Duck extends Bird {
	private String name;
	
	public Duck() {
		this.name = "오리";
	}

	@Override
	public void fly() {
		System.out.println(name + "(" + getName() + ")는 날지 않습니다.");
	}

	@Override
	public void sing() {
		System.out.println(name + "(" + getName() + ")가 소리내어 웁니다.");
	}
	
	@Override
	public String toString() {
		return name + "의 이름은 " + getName() + "입니다.";
	}
}
