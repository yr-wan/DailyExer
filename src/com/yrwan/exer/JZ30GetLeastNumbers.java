package com.yrwan.exer;

/**
 * 30.����n���������ҳ�������С��K������
 * ˼·���Ƚ�ǰK�����������飬���ж�������֮�����������С������е���
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

	
	// �������ÿ���˼�����
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
