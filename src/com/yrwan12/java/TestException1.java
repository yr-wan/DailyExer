package com.yrwan12.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
 * 处理异常Exception的方法：抓抛模型
 * 1.抛：当执行代码时，一旦出现异常，就会在异常的代码处生成一个对应的异常类型的对象，并将此对象抛出。
 * 		>一旦抛出此异常类的对象，程序就终止执行
 *		>此异常类的对象抛给方法的调用者
 * 2.抓：抓住上一步抛出来的异常类的对象。如何抓？即为异常处理的方式
 * 		法一：
 * 		try{
 * 			//可能异常的代码
 * 		}catch(Exception1 e1){
 * 			//处理1
 * 		}catch(Exception2 e2){
 * 			//处理2
 * 		}finally{
 * 			//必执行的代码
 * 		}
 * 注：	1.try内声明的变量，类似于局部变量，出了try{}语句，就不能被调用
 *    	2.finally是可选的。
 * 		3.catch语句内部是对异常对象的处理：
 * 			>getMessage();  printStackTrace();
 * 		4.可以有多个catch语句，try中抛出的异常类对象从上往下去匹配catch中的异常类的类型，一旦满足
 * 			 就执行catch中的代码。执行完，就跳出其后的多条catch语句
 *    	5.如果异常处理了，那么其后的代码继续执行。
 *    	6.若catch中多个异常类型是"并列"关系，孰上孰下都可以。
 *			若catch中多个异常类型是"包含"关系，须将子类放在父类的上面，进行处理。否则报错！
 *		7.finally中存放的是一定会被执行的代码，不管try中、catch中是否仍有异常未被处理，
 *			以及是否有return语句。
 *		8.try-catch是可以嵌套的。
 */
public class TestException1 {
	// 1.数组下标越界异常:ArrayIndexOutOfBoundsException
	// catch的参数内可写具体报错类：ArrayIndexOutOfBoundsException
	@Test
	public void test1() {
		int[] arr = new int[10];
		try {
			System.out.println(arr[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组下标越界异常");
		} finally {
			System.out.println("这是finally语句，可不写，但写了必执行");
		}
	}

	// 2.算术异常:ArithmeticException
	// catch的参数内可写父类：Exception
	@Test
	public void test2() {
		int i = 10;
		try {
			System.out.println(i / 0);
		} catch (Exception e) {
			System.out.println("出现异常");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// 5.如不加throws Exception，则会出现编译时异常
	// finally内存放必执行的语句，并且try-catch可嵌套
	@Test
	public void test5() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("test.txt"));
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
