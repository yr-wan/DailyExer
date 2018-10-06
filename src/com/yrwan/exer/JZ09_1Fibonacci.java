package com.yrwan.exer;

import org.junit.Test;

/**
 * ����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 * ˼·���ݹ��Ч�ʵͣ�ʹ��ѭ����ʽ��
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
