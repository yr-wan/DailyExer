package com.yrwan05.java;

//测试String两种不同赋值方法
public class TestString {
	public static void main(String[] args) {
		String str1 = new String("HelloWorld");
		String str2 = "HelloWorld";
		
		System.out.println("str1通过String str1 = new String(\"HelloWorld\");创建");
		System.out.println("str2通过String str2 = \"HelloWorld\";创建");
		System.out.println();
		
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		System.out.println();
		
		System.out.print("str1 == str2的结果: ");
		System.out.println(str1 == str2);
		System.out.println("str1.equals(str2)的结果: " + str1.equals(str2));
		System.out.println();
		
		System.out.println("---------------------------------------");
		
		System.out.println("str3通过String str3 = new String(\"HelloWorld\");创建");
		System.out.println("str4通过String str4 = \"HelloWorld\";创建");
		System.out.println();
		
		String str3 = new String("HelloWorld");
		String str4 = "HelloWorld";
		
		System.out.println("str3: " + str3);
		System.out.println("str4: " + str4);
		System.out.println();
		
		System.out.print("str1 == str3的结果: ");
		System.out.println(str1 == str3);
		System.out.println("str1.equals(str3)的结果: " + str1.equals(str3));
		System.out.println();
		
		System.out.print("str2 == str4的结果: ");
		System.out.println(str2 == str4);
		System.out.println("str2.equals(str4)的结果: " + str2.equals(str4));
		System.out.println();
	}
}
