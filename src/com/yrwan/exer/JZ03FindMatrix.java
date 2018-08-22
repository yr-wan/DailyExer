package com.yrwan.exer;

/*
 * 剑指offer面试题3：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：从右上角或左下角开始找，逐行删除，或者用二分法查找
 */
public class JZ03FindMatrix {
	// 从左下角开始搜寻
	public static boolean find1(int[][] array, int target) {
		if (array == null) {
			return false;
		}
		int m = array.length - 1;// 行数
		int n = 0;
		while (m >= 0 && n < array[0].length) {
			if (array[m][n] > target) {
				m--;
			} else if (array[m][n] < target) {
				n++;
			} else {
				return true;
			}
		}
		return false;
	}

	// 从右上角开始搜寻
	public static boolean find2(int[][] array, int target) {
		if (array == null) {
			return false;
		}
		int m = 0;// 行数
		int n = array[0].length - 1;
		while (n > 0 && m < array.length) {
			if (array[m][n] > target) {
				n--;
			} else if (array[m][n] < target) {
				m++;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// 测试一个4行4列的数组，目标值为7
		int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int b = 7;
		System.out.println(find2(a, b));
	}
}
