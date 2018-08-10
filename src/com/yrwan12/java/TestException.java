package com.yrwan12.java;

import java.io.*;
import org.junit.Test;

/*
 * �������쳣����
 * java.lang.Throwable
 * 		|-----Error:���󣬲�����
 * 		|-----Exception:�쳣��Ҫ����
 */
public class TestException {
	class Person {
	}
	// ����������ʱ�쳣

	// 1.�����±�Խ���쳣:ArrayIndexOutOfBoundsException
	@Test
	public void test1() {
		int[] arr = new int[10];
		System.out.println(arr[10]);
	}

	// 2.�����쳣:ArithmeticException
	@Test
	public void test2() {
		int i = 10;
		System.out.println(i / 0);
	}

	// 3.����ת���쳣:ClassCastException
	@SuppressWarnings("unused")
	@Test
	public void test3() {
		Object obj = new Integer(1);
		String str = (String) obj;
	}

	// 4.��ָ���쳣:NullPointerException
	@SuppressWarnings("null")
	@Test
	public void test4() {
		Person p = new Person();
		p = null;
		System.out.println(p.toString());
	}

	// ����ʱ�쳣
	
	// 5.�粻��throws Exception�������ֱ���ʱ�쳣
	@Test
	public void test5() throws Exception {
		FileInputStream fis = new FileInputStream(new File("test.txt"));
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println((char) b);
		}
		fis.close();
	}
}
