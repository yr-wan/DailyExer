package com.yrwan10.java;

//final关键字练习
public class TestFinal {
	public static void main(String[] args) {
		Final f = new Final("NAME");
		// f.id = 2;//final修饰的属性为常量 不可二次更改
		f.show();
	}
}

final class Final {// final修饰的类不可被继承
	final int ID = 1;// final修饰的属性可显式赋值
	final int A, B;
	private String name;

	{
		A = 2;// final修饰的属性可被代码块赋值
	}

	public Final() {
		super();
		B = 3;// final修饰的属性可被构造器赋值
	}

	public Final(String name) {
		super();
		B = 3;
		this.name = name;
	}

	public final void show() {// final修饰的方法不可被重写
		System.out.println("ID:" + ID + " name:" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return ID;
	}
}
// final修饰的类不可被继承
// class Final2 extends Final{}