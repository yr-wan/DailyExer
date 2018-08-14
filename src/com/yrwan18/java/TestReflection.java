package com.yrwan18.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	
	/*
	 * java.lang.Class:是反射的源头
	 * 获取Class的实例
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	@Test
	public void test3(){
		Class clazz1 = Person.class;
		
		Person p = new Person();
		Class clazz2 = p.getClass();
		
	}
	
	// 用反射之后的例子
	@Test
	public void test2() throws Exception {
		Class<Person> clazz = Person.class;
		// 1.创建clazz对应的运行时类Person类的对象
		Person p = clazz.newInstance();
		System.out.println(p);
		// 2.通过反射调用运行时类的指定属性
		Field f1 = clazz.getField("name");// 属性是public才可以这样操作
		f1.set(p, "BB");
		System.out.println(p);
		Field f2 = clazz.getDeclaredField("age");// 属性是private可以使用getDeclaredField
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		// 3.通过反射调用运行时类的指定方法
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "zhongguo");
	}

	// 用反射之前
	@Test
	public void test1() {
		Person p = new Person("AA", 23);
		p.show();
		p.display("China");
		System.out.println(p.getClass());
	}
}
