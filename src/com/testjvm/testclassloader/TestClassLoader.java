package com.testjvm.testclassloader;

import org.junit.Test;

public class TestClassLoader {
	@Test
	public void testClassLoader() throws Exception{
		// 引导类加载器因为是c++编写的，所以会显示null
		Object object = new Object();
		System.out.println(object.getClass().getClassLoader());
		System.out.println();
		
		// 应用程序加载器
		Person person = new Person();
		System.out.println(person.getClass().getClassLoader());
		System.out.println(person.getClass().getClassLoader().getParent());
		System.out.println(person.getClass().getClassLoader().getParent().getParent());
		System.out.println();
		System.out.println(person.getClass().getSuperclass().getName());
		System.out.println(person.getClass().getSuperclass().getClassLoader());
		System.out.println();
		
	}
}

class Person {
	int id;
	String name;

	public Person() {
		super();
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}