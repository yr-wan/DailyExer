package com.yrwan18.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestNewInstance {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test8() throws Exception {
		Class clazz = Person.class;
		// 1.获取指定方法
		Method nameMethod = clazz.getMethod("show");
		// 2.创建运行时类的对象
		Person p = (Person) clazz.newInstance();
		// 3.将运行时类的指定方法赋值
		nameMethod.invoke(p);
		System.out.println(p);
		
		Method infoMethod = clazz.getDeclaredMethod("display",String.class);
		infoMethod.setAccessible(true);
		infoMethod.invoke(p, "China");
		System.out.println(infoMethod);
	}
	
	
	// 应用三：调用对应的运行时类的完整的类的结构
	@SuppressWarnings("rawtypes")
	@Test
	public void test7() throws Exception {
		Class clazz = Person.class;
		// 1.获取指定属性
		Field nameField = clazz.getField("name");
		// 2.创建运行时类的对象
		Person p = (Person) clazz.newInstance();
		// 3.将运行时类的指定属性赋值
		nameField.set(p, "AA");
		System.out.println(p);
		
		Field ageField = clazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(p, 23);
		System.out.println(p);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test6() throws Exception {
		Class clazz = Person.class;
		Class[] inter = clazz.getInterfaces();
		for (Class class1 : inter) {
			System.out.println(class1);// 接口
		}
		System.out.println(clazz.getPackage());// 包
		System.out.println((clazz.getAnnotations())[0]);// 注解
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test5() throws Exception {
		Class clazz = Person.class;
		System.out.println(clazz.getSuperclass());// 父类

		Type type1 = clazz.getGenericSuperclass();
		System.out.println(type1);// 带泛型的父类

		ParameterizedType param = (ParameterizedType) type1;
		Type[] ars = param.getActualTypeArguments();
		System.out.println(((Class) ars[0]).getName());// 获取父类的泛型 jdbc用
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test4() throws Exception {
		Class clazz = Person.class;
		Method[] method2 = clazz.getDeclaredMethods();
		System.out.println("能获取到的全部方法：");
		for (Method m : method2) {
			Annotation[] anno = m.getAnnotations();
			for (Annotation annotation : anno) {
				System.out.println(annotation);
			}
			System.out.print(Modifier.toString(m.getModifiers()) + "  ");
			System.out.print(m.getReturnType() + "  ");

			System.out.print(m.getName() + "( ");
			Class[] param = m.getParameterTypes();
			for (Class class1 : param) {
				System.out.print(class1 + " ");
			}
			System.out.println(")");

			System.out.println();
		}
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test3() throws Exception {
		Class clazz = Person.class;
		// 1.getMethods():只能获取到运行时类及其父类的public方法
		Method[] method1 = clazz.getMethods();
		System.out.println("获取到的public方法：");
		for (Method method : method1) {
			System.out.println(method);
		}

		// 2.getDeclaredMethods():只能获取到运行时类本身的全部方法
		Method[] method2 = clazz.getDeclaredMethods();
		System.out.println("能获取到的全部方法：");
		for (Method method : method2) {
			System.out.println(method);
		}
	}

	// 应用二：获取对应的运行时类的完整的类的结构
	@SuppressWarnings("rawtypes")
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;
		// 1.getFields():只能获取到运行时类及其父类的public属性
		Field[] fields1 = clazz.getFields();
		System.out.println("获取到的public属性：");
		for (Field field : fields1) {
			System.out.println(field.getName());
		}

		// 2.getDeclaredFields():只能获取到运行时类本身的全部属性
		Field[] fields2 = clazz.getDeclaredFields();
		System.out.println("能获取到的全部属性：");
		for (Field field : fields2) {
			System.out.println(field.getName());
		}

		// 3.获取属性的各个部分内容
		System.out.println("获取到的属性各个部分内容：");
		for (Field field : fields2) {
			// 权限修饰符
			System.out.print(Modifier.toString(field.getModifiers()) + "  ");
			// 变量类型
			System.out.print(field.getType().getName() + "  ");
			// 属性名
			System.out.print(field.getName());
			System.out.println();
		}

	}

	// 应用一：可以创建对应的运行时类的对象
	@SuppressWarnings("rawtypes")
	@Test
	public void test1() throws Exception {
		String name = "com.yrwan18.java.Person";
		Class clazz = Class.forName(name);
		Object obj = clazz.newInstance();
		// 要求对应的类有空参构造器，并且权限足够
		Person p = (Person) obj;
		System.out.println(p);
	}
}
