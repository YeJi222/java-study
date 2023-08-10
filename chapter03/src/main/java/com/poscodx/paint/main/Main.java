package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.GraphicText;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
//		point1.setX(10);
//		point1.setY(20);
		
		// drawPoint(point1);
		draw(point1);
		// point1.disappear();
		point1.show(false);
		
		Point point2 = new ColorPoint(); // casting
		/*
		ColorPoint p = new ColorPoint(); 
		Point point2 = p;
		*/
		
		point2.setX(20); // 상속 받았으니까 
		point2.setY(20);
		
		// ColorPoint p2 = (ColorPoint)point2; // down casting
		((ColorPoint)point2).setColor("red");
		// drawPoint(point2);
		draw(point2);
		
		Rect rect = new Rect();
		// drawRect(rect);
		// drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
		// drawTriangle(triangle);
		// drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		// drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello World"));
		
		// instanceof 연산자 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
		// 오류 : 연산자 우측항 클래스인 경우, 
		// 레퍼런스하고 있는 클래스 타입의 hierarchy 상의 하위와 상위만
		// instanceof 연산자를 사용할 수 있다.
		// System.out.println(circle instanceof Rect); 
		
		// 연산자 우측항이 인터페이스인 경우,
		// Hierarchy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
//	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}

//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
}
