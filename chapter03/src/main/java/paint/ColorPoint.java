package paint;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() { // 오버라이딩 
		System.out.println("점 [x=" + getX() + ",y=" + getY() + ", color=" + getColor() + "]을 그렸습니다.");
	}
}
