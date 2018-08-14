package com.yrwan18.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestNewInstance {

	@SuppressWarnings("rawtypes")
	@Test
	public void test6() throws Exception {
		Class clazz = Person.class;
		Class[] inter = clazz.getInterfaces();
		for (Class class1 : inter) {
			System.out.println(class1);// �ӿ�
		}
		System.out.println(clazz.getPackage());// ��
		System.out.println((clazz.getAnnotations())[0]);// ע��
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test5() throws Exception {
		Class clazz = Person.class;
		System.out.println(clazz.getSuperclass());// ����

		Type type1 = clazz.getGenericSuperclass();
		System.out.println(type1);// �����͵ĸ���

		ParameterizedType param = (ParameterizedType) type1;
		Type[] ars = param.getActualTypeArguments();
		System.out.println(((Class) ars[0]).getName());// ��ȡ����ķ��� jdbc��
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void test4() throws Exception {
		Class clazz = Person.class;
		Method[] method2 = clazz.getDeclaredMethods();
		System.out.println("�ܻ�ȡ����ȫ��������");
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
		// 1.getMethods():ֻ�ܻ�ȡ������ʱ�༰�丸���public����
		Method[] method1 = clazz.getMethods();
		System.out.println("��ȡ����public������");
		for (Method method : method1) {
			System.out.println(method);
		}

		// 2.getDeclaredMethods():ֻ�ܻ�ȡ������ʱ�౾���ȫ������
		Method[] method2 = clazz.getDeclaredMethods();
		System.out.println("�ܻ�ȡ����ȫ��������");
		for (Method method : method2) {
			System.out.println(method);
		}
	}

	// Ӧ�ö�����ȡ��Ӧ������ʱ�����������Ľṹ
	@SuppressWarnings("rawtypes")
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;
		// 1.getFields():ֻ�ܻ�ȡ������ʱ�༰�丸���public����
		Field[] fields1 = clazz.getFields();
		System.out.println("��ȡ����public���ԣ�");
		for (Field field : fields1) {
			System.out.println(field.getName());
		}

		// 2.getDeclaredFields():ֻ�ܻ�ȡ������ʱ�౾���ȫ������
		Field[] fields2 = clazz.getDeclaredFields();
		System.out.println("�ܻ�ȡ����ȫ�����ԣ�");
		for (Field field : fields2) {
			System.out.println(field.getName());
		}

		// 3.��ȡ���Եĸ�����������
		System.out.println("��ȡ�������Ը����������ݣ�");
		for (Field field : fields2) {
			// Ȩ�����η�
			System.out.print(Modifier.toString(field.getModifiers()) + "  ");
			// ��������
			System.out.print(field.getType().getName() + "  ");
			// ������
			System.out.print(field.getName());
			System.out.println();
		}

	}

	// Ӧ��һ�����Դ�����Ӧ������ʱ��Ķ���
	@SuppressWarnings("rawtypes")
	@Test
	public void test1() throws Exception {
		String name = "com.yrwan18.java.Person";
		Class clazz = Class.forName(name);
		Object obj = clazz.newInstance();
		// Ҫ���Ӧ�����пղι�����������Ȩ���㹻
		Person p = (Person) obj;
		System.out.println(p);
	}
}
