package com.yrwan.exer;

/**
 * 34.������ֻ��������2��3��5���������С����ĵ�N��������
 * ˼·����2��3��5��֮��Ƚ�ȡ��Сֵ��
 * @author wyran
 *
 */
public class JZ34UglyNumber {
	public static void main(String[] args) {
		int index = 1500;
		System.out.println(getUglyNumber(index));
	}
	
	public static int getUglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] arr = new int[index];
		arr[0] = 1;
		int m2 = 0;
		int m3 = 0;
		int m5 = 0;
		for (int i = 1; i < index; i++) {
			int min = Math.min(arr[m2] * 2, Math.min(arr[m3] * 3, arr[m5] * 5));
			arr[i] = min;
			if (arr[m2] * 2 == min) {
				m2++;
			}
			if (arr[m3] * 3 == min) {
				m3++;
			}
			if (arr[m5] * 5 == min) {
				m5++;
			}
		}
		return arr[index - 1];
	}
	
	
	// �·�Ϊ����������
	public static int getUglyNumber2(int index) {
		if (index <= 0)
			return 0;
		int number = 0;
		int uglyFound = 0;
		while (uglyFound < index) {
			number++;
			if (isUgly(number)) {
				++uglyFound;
			}
		}
		return number;
	}
	public static boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return (number == 1) ? true : false;
	}
}
