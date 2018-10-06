package com.yrwan.exer;

import org.junit.Test;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * ˼·��a&(a-1)�Ľ���Ὣa���ұߵ�1��Ϊ0��ֱ��a = 0��
 * �������Ƚ�a&1 != 0��Ȼ������1λ�������ܼ��㸺����ֵ��
 * @author wyran
 *
 */
public class JZ10NumberOfOne {
	public int numberOfOne2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	public int numberOfOne(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}

	@Test
	public void test() {
		System.out.println(numberOfOne2(-5));
	}
}
