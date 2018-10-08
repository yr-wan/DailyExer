package com.yrwan.exer;

/**
 * 30.输入n个整数，找出其中最小的K个数。
 * 思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
 * 
 * @author wyran
 *
 */
public class JZ30GetLeastNumbers {
	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] arr = { 1, 2, 3, 2, 2, 2, 5, 2, 4 };
		getLeastNumbers(arr, 3);
	}

	
	// 以下是用快排思想完成
	public static void getLeastNumbers(int[] arr, int k) {
		if (arr == null || k <= 0 || k > arr.length) {
			return;
		}
		int start = 0;
		int end = arr.length - 1;
		int index = partition(arr, start, end);
		while (index != k) {
			if (index > k) {
				end = index - 1;
				index = partition(arr, start, end);
			} else {
				start = index + 1;
				index = partition(arr, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int left = start - 1;
		int right = end;
		int target = arr[end];
		while (left < right) {
			while (left < right && arr[++left] <= target);
			while (left < right && arr[--right] > target);
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		int temp = arr[left];
		arr[left] = arr[end];
		arr[end] = temp;
		return left;
	}
}
