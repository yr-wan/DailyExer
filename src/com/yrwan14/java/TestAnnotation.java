package com.yrwan14.java;

import java.util.ArrayList;
import java.util.List;

/*
 * 1.���������� Annotation:
 * @Override: �޶���д���෽��, ��ע��ֻ�����ڷ���
 * @Deprecated: ���ڱ�ʾĳ������Ԫ��(��, ������)�ѹ�ʱ
 * @SuppressWarnings: ���Ʊ���������
 * 2.�Զ���ע�⣺
 * 
 * 3.Ԫע�⣺
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