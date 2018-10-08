package com.yrwan.exer;
/**
 * 31.�����������飨����������������
 * ˼·������С��0����������Ϊ��ǰֵ������������͡�//TODO
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
