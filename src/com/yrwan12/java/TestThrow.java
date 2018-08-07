package com.yrwan12.java;

/*
 * �ֶ��׳��쳣������
 * �׳�����RuntimeException�ɲ���ʽ����
 * �׳�����Exception������ʽ����
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
		} else {// �ֶ��׳��쳣
			//throw new RuntimeException("�����������");
			throw new MyException("�������������");//�Զ����쳣��
		}
	}
}
