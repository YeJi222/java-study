package chapter04;

import java.util.Objects;

public class Rect {
	private int width;
	private int height;
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	// hashCode와 equals 함수를 override 하지 않으면 set이 제 기능을 못한다 
	// 실행 결과 
	/*
		Rect [width=10, height=20]
		Rect [width=4, height=50]
		Rect [width=10, height=20]
	*/

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return height == other.height && width == other.width;
	}
	
	// hashCode와 equals 함수 override 후 실행결과
	/*
	 	Rect [width=4, height=50]
		Rect [width=10, height=20]
	 */

	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}
}
