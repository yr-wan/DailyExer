package com.yrwan.exer;
/**
 * 14.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 思路：每次只和前面一个数交换位置。或者利用辅助数组
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
