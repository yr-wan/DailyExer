package com.yrwan.exer;

import org.junit.Test;

/**
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * 思路：递归的效率低，使用循环方式。
 * @author wyran
 *
 */
public class JZ09_1Fibonacci {
	public long fibonacci(int n) {
		long a = 0;
		long b = 1;
		long temp = 0;
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			for (int i = 0; i < n; i++) {
				temp = a + b;
				a = b;
				b = temp;
			}
			return b;
		}
	}
	
	@Test
	public void test(){
		System.out.println(fibonacci(39));
	}
}
