package com.yrwan14.java;

import java.util.ArrayList;
import java.util.List;

/*
 * 1.三个基本的 Annotation:
 * @Override: 限定重写父类方法, 该注释只能用于方法
 * @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
 * @SuppressWarnings: 抑制编译器警告
 * 2.自定义注解：
 * 
 * 3.元注解：
 * 
 */
public class TestAnnotation {
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		List list = new ArrayList();
	}
}
@MyAnnotation(value = "MyAnnotation")
class Student extends Person{
	@Override
	public void eat(){
		System.out.println("Student eat");
	}
}
class Person{
	String name;
	int  age;
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
	public void eat(){
		System.out.println("eat");
	}
	@Deprecated
	public void walk(){
		System.out.println("walk");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}