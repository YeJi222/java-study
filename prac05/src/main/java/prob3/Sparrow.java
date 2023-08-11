package prob3;

public class Sparrow extends Bird {
	private String name;
	
	public Sparrow() {
		this.name = "참새";
	}

	@Override
	public void fly() {
		System.out.println(name + "(" + getName() + ")는 날아다닙니다.");
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
