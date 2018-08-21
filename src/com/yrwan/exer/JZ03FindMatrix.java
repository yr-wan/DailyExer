package com.yrwan.exer;

// ��ָoffer������3����ά�����еĲ���
public class JZ03FindMatrix {
	public static void main(String[] args) {
		// ����һ��4��4�е����飬Ŀ��ֵΪ7
		int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int b = 7;
		System.out.println(find2(a, b));
	}

	// �����½ǿ�ʼ��Ѱ
	public static boolean find1(int[][] array, int target) {
		int m = array.length - 1;// ����
		int n = 0;
		while (m >= 0 && n < array[0].length) {
			if (array[m][n] > target) {
				m--;
			} else if (array[m][n] < target) {
				n++;
			} else {
				return true;
			}
		}
		return false;
	}

	// �����Ͻǿ�ʼ��Ѱ
	public static boolean find2(int[][] array, int target) {
		int m = 0;// ����
		int n = array[0].length - 1;
		while (n > 0 && m < array.length) {
			if (array[m][n] > target) {
				n--;
			} else if (array[m][n] < target) {
				m++;
			} else {
				return true;
			}
		}
		return false;
	}
}
