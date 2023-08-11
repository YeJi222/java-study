package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	
	public Rectangle(double w, double h){
		this.width = w;
		this.height = h;
	}
	
	public void resize(double s) {
		this.width *= s;
		this.height *= s;
	}
	
	@Override
	public String getArea() {
		return String.valueOf(width * height);
	}

	@Override
	public String getPerimeter() {
		return String.valueOf((width + height) * 2);
	}
}
