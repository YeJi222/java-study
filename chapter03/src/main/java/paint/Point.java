package paint;

public class Point implements Drawable {
	protected int x;
	protected int y;
	
	public Point() {
	}
	
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void show() {
		System.out.println("점 [x=" + x + ",y=" + y + "]을 그렸습니다.");
	}
	
	public void disappear() {
		System.out.println("점 [x=" + x + ",y=" + y + "]을 지웠습니다.");
	}
	
	public void show(boolean visible) { // 오버로딩 
		if(visible) {
			// System.out.println("점 [x=" + x + ",y=" + y + "]을 그렸습니다."); // 코드 중복 
			show();
		} else {
			// System.out.println("점 [x=" + x + ",y=" + y + "]을 지웠습니다."); // 코드 중복 
			disappear();
		}
		
	}

	@Override
	public void draw() {
		show();
	}
}
