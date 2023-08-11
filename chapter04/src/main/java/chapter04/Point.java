package chapter04;

import java.util.Objects;

public class Point {
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
	
	// hashCode()랑 equals를 같이 override 해야함 
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // 타입이 같은지 
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
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
}
