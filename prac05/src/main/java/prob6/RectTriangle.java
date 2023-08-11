package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public String getArea() {
		return String.valueOf(width * height * 0.5);
	}

	@Override
	public String getPerimeter() {
		return String.valueOf(width + height + (Math.sqrt((width*width) + (height*height))));
	}
}
