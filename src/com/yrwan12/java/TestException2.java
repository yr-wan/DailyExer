package com.yrwan12.java;

/*
 * 法二：方法声明处，显式抛出异常对象的类型
 * 如： public static void method() throws Exception {}
 */
public class TestException2 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void method1() throws Exception {
		System.out.println(10 / 0);
	}
}
