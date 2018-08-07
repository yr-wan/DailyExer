package com.yrwan10.java;


//抽象类、抽象方法练习
public class TestAbstract {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.eat();
		s1.sleep();
		Person s2 = new Student();
		s2.eat();
	}
}

abstract class Person {// 抽象方法所在的类，一定是抽象类
	private int id;
	private String name;

	public Person() {// 抽象类有构造器
		id = 1;
		name = "A";
	}

	public abstract void eat();

	public abstract void walk();

	public void sleep() {// 抽象类中可以没有抽象方法
		System.out.println("人睡觉");
	}
}

class Student extends Person {
	public void eat() {
		System.out.println("学生吃");
	}

	public void walk() {
		System.out.println("学生走");
	}
}