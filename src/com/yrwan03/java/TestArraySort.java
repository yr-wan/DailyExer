package com.yrwan03.java;

import java.util.Arrays;
//数组排序
public class TestArraySort {
	public static void main(String[] args) {
		System.out.println("排序前的数组为：");
		int[] arr = new int[] { 10, 5, 68, 124, 10, -3, 46, 31, 7, -25 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

/*		// 冒泡排序法（与直接选择法二选一）
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("冒泡排序排序后的数组为：");

		// 直接选择法（与冒泡排序法二选一）
		for (int i = 0; i < arr.length - 1; i++) {
			int t = i;// 默认i的值最小
			for (int j = i; j < arr.length; j++) {
				if (arr[t] > arr[j]) {// 在i后发现比其更小的元素，则用新下标替代i
					t = j;
				}
			}
			if (t != i) {
				int temp = arr[t];
				arr[t] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.println("直接选择法排序后的数组为：");*/

		// 调用Arrays工具类
		Arrays.sort(arr);
		System.out.println("java自带方法排序后的数组为：");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
