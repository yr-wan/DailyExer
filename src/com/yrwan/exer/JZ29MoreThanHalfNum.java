package com.yrwan.exer;
/**
 * 29.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则-1，最后进行校验是否超过长度的一半。
 * @author wyran
 *
 */
public class JZ29MoreThanHalfNum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 2, 2, 5, 2, 4 };
		int result = moreThanHalfNum(arr);
		System.out.println(result);
	}
	
	public static int moreThanHalfNum(int[] arr) {
		int max = arr[0];
		int temp = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != temp) {
				if (count == 0) {
					temp = arr[i];
					count = 1;
				} else {
					count--;
				}
			} else {
				count++;
			}
			if (count == 1) {
				max = temp;
			}
		}
		return max;
	}
	
	// 以下是基于快排思想的实现法
	public static int moreThanHalfNum2(int[] arr) {
		if(arr == null){
			return 0;
		}
		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;
		int index = partition(arr, start, end);
		while (mid != index) {
			if (mid > index) {
				start = index + 1;
				index = partition(arr, start, end);
			} else {
				end = index - 1;
				index = partition(arr, start, end);
			}
		}
		return arr[index];
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
