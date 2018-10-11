package com.yrwan.exer;

import java.util.HashSet;

/**
 * 51.在一个长度为n的数组里的所有数字都在0到n-1的范围内，找出数组中任意一个重复的数字
 * 思路：使用HashSet
 * @author wyran
 *
 */
public class JZ51Duplicate {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(duplicate(arr));
	}

	public static boolean duplicate(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
			} else {
				return true;
			}
		}
		return false;
	}
}
