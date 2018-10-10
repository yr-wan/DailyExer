package com.yrwan.exer;
/**
 * 41.1输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是最先出现的两个数乘积最小
 * @author wyran
 *
 */
public class JZ41_1FindNumberWithSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 7, 11, 15 };
		findNumberWithSum(arr, 14);
	}

	public static void findNumberWithSum(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] > target) {
				j--;
			} else if (arr[i] + arr[j] < target) {
				i++;
			} else if (arr[i] + arr[j] == target) {
				System.out.println(arr[i] + " " + arr[j]);
				break;
			}
		}
		System.out.println("can't find");
	}
}
