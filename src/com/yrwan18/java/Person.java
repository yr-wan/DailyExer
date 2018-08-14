package com.yrwan18.java;

@MyAnnotation(value = "����ע��")
public class Person extends Creature<String> implements Comparable<Person>,MyInterface{
	private static final long serialVersionUID = -7658406008474958905L;
	public String name;
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@MyAnnotation(value = "abc123")
	public void show() {
		System.out.println("����person");
	}

	public void display(String nation) {
		System.out.println("�ҵĹ�����" + nation);
	}

	@Override
	public int compareTo(Person o) {
		return 0;
	}
}