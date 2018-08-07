package com.yrwan12.java;

import java.io.*;
import org.junit.Test;

/*
 * 常见的异常类型
 * java.lang.Throwable
 * 		|-----Error:错误，不处理
 * 		|-----Exception:异常，要求解决
 */
public class TestException {
	class Person {
	}
	// 常见的运行时异常

	// 1.数组下标越界异常:ArrayIndexOutOfBoundsException
	@Test
	public void test1() {
		int[] arr = new int[10];
		System.out.println(arr[10]);
	}

	// 2.算术异常:ArithmeticException
	@Test
	public void test2() {
		int i = 10;
		System.out.println(i / 0);
	}

	// 3.类型转换异常:ClassCastException
	@Test
	public void test3() {
		Object obj = new Integer(1);
		String str = (String) obj;
	}

	// 4.空指针异常:NullPointerException
	@Test
	public void test4() {
		Person p = new Person();
		p = null;
		System.out.println(p.toString());
	}

	// 编译时异常
	
	// 5.如不加throws Exception，则会出现编译时异常
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
