package com.yrwan.exer;
/**
 * 31.求连续子数组（包含负数）的最大和
 * 思路：若和小于0，则将最大和置为当前值，否则计算最大和。//TODO
 * @author wyran
 *
 */
public class JZ31FindGreatestSumOfSubArray {
	public static void main(String[] args) {
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int result = findGreatestSumOfSubArray(arr);
		System.out.println(result);
	}

	// DP
	public static int findGreatestSumOfSubArray(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return 0;
		}
		int[] f = new int[arr.length];
		int max = arr[0];
		f[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			f[i] = Math.max(arr[i], f[i - 1] + arr[i]);
			max = Math.max(f[i], max);
		}
		return max;
	}
}
