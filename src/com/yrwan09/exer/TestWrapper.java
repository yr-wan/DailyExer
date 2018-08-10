package com.yrwan09.exer;

/*
 * 包装类练习
 * 基本数据类型 包装类 String类之间的转化
 */
import org.junit.Test;

public class TestWrapper {
	// 基本数据类型、包装类 与 String类 的转化
	@Test
	public void test2() {
		int i1 = 10;
		Boolean b = new Boolean("true1");
		// 基本数据类型 to String类
		String str1 = "" + i1;
		String str2 = String.valueOf(i1);
		String str3 = String.valueOf(b);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		// String类 to 基本数据类型
		int i2 = Integer.parseInt(str2);
		System.out.println(i2);
	}

	// 基本数据类型与包装类的转化
	@SuppressWarnings("unused")
	@Test
	public void test1() {
		int i = 10;
		Integer i1 = new Integer(i);
		System.out.println(i1.intValue());
		int i2 = i1.intValue();
		Integer i3 = 66;// 自动装箱
		int i4 = i3;// 自动拆箱

		Float f = new Float(1.5F);
		Float f1 = new Float("1.5F");

		boolean b = false;
		Boolean b1 = new Boolean("true");// true，只有形参是true时才返回true
		Boolean b2 = new Boolean("true1");// false 不报异常
		Boolean b3 = new Boolean("123");// false
	}

}
