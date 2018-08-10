package com.yrwan09.java;

//类变量、类方法
public class TestStatic {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Person.nation = "China";
		Person.show3();
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(Person.count);
	}
}

class Person {
	String name = "Tom";
	int age = 20;
	static String nation = "null";
	static int count;

	public Person() {
		super();
		count++;
	}

	public static void show1() {
		System.out.println("public static void show");
	}

	public void show2() {
		System.out.println(nation);
		System.out.println("public void show2");
	}

	public static void show3() {
		show1();
		System.out.println("public static void show3");
		System.out.println("nation: " + nation);
	}
}