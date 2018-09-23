package com.testjvm.testclassloader;

import org.junit.Test;

public class TestClassLoader {
	@Test
	public void testClassLoader() throws Exception{
		// �������������Ϊ��c++��д�ģ����Ի���ʾnull
		Object object = new Object();
		System.out.println(object.getClass().getClassLoader());
		System.out.println();
		
		// Ӧ�ó��������
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