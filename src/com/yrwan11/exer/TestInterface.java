package com.yrwan11.exer;

/*
 * 定义一个接口用来实现两个对象的比较。
 * interface CompareObject{
 * 	//若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 * 	public int compareTo(Object o);   
 * }
 * 定义一个Circle类。
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * 定义一个测试类TestInterface，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 * 思考：参照上述做法定义矩形类Rectangle和ComparableRectangle类，在ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。
 * 
 */
public class TestInterface {
	public static void main(String[] args) {
		ComparablaCircle c1 = new ComparablaCircle(1.5);
		ComparablaCircle c2 = new ComparablaCircle(1.5);
		System.out.println(c1.compareTo(c2));
	}
}

interface CompareObject {
	int compareTo(Object o);
}

class Circle {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}

class ComparablaCircle extends Circle implements CompareObject {
	public ComparablaCircle(double radius) {
		super(radius);
	}

	// 若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
	public int compareTo(Object o) {
		if (o == this) {
			return 0;
		} else if (o instanceof ComparablaCircle) {
			ComparablaCircle c = (ComparablaCircle) o;
			if (this.getRadius() > c.getRadius()) {
				return 1;
			} else if (this.getRadius() < c.getRadius()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			throw new RuntimeException("传入对象有误");
		}
	}
}