package com.yrwan.exer;
/**
 * 14.����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò���
 * ˼·��ÿ��ֻ��ǰ��һ��������λ�á��������ø�������
 * @author wyran
 *
 */
public class JZ14ReorderOddRven {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		reorderOddRven(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void reorderOddRven(int[] arr) {
		if (arr == null) {
			return;
		}
		int i = -1;
		int j = arr.length;
		while (i < j) {
			while (i < j && arr[++i] % 2 != 0);
			while (i < j && arr[--j] % 2 == 0);
			swap(arr, i, j);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
