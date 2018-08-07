package com.yrwan12.java;

/*
 * 手动抛出异常的例子
 * 抛出的是RuntimeException可不显式处理
 * 抛出的是Exception必须显式处理
 */
public class TestThrow {
	public static void main(String[] args) {
		Circle c = new Circle(2.0);
		int i = 1;
		c.compareTo(i);
	}
}
class Circle {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public int compareTo(Object o) {
		if (o == this) {
			return 0;
		} else if (o instanceof Circle) {
			Circle c = (Circle) o;
			if (this.radius > c.radius) {
				return 1;
			} else if (this.radius < c.radius) {
				return -1;
			} else {
				return 0;
			}
		} else {// 手动抛出异常
			//throw new RuntimeException("传入对象有误");
			throw new MyException("传入的类型有误！");//自定义异常类
		}
	}
}
