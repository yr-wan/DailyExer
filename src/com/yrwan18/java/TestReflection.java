package com.yrwan18.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	
	/*
	 * java.lang.Class:�Ƿ����Դͷ
	 * ��ȡClass��ʵ��
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	@Test
	public void test3(){
		Class clazz1 = Person.class;
		
		Person p = new Person();
		Class clazz2 = p.getClass();
		
	}
	
	// �÷���֮�������
	@Test
	public void test2() throws Exception {
		Class<Person> clazz = Person.class;
		// 1.����clazz��Ӧ������ʱ��Person��Ķ���
		Person p = clazz.newInstance();
		System.out.println(p);
		// 2.ͨ�������������ʱ���ָ������
		Field f1 = clazz.getField("name");// ������public�ſ�����������
		f1.set(p, "BB");
		System.out.println(p);
		Field f2 = clazz.getDeclaredField("age");// ������private����ʹ��getDeclaredField
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		// 3.ͨ�������������ʱ���ָ������
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "zhongguo");
	}

	// �÷���֮ǰ
	@Test
	public void test1() {
		Person p = new Person("AA", 23);
		p.show();
		p.display("China");
		System.out.println(p.getClass());
	}
}
