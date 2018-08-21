package com.yrwan.exer;

// 剑指offer面试题3：二维数组中的查找
public class JZ03FindMatrix {
	public static void main(String[] args) {
		// 测试一个4行4列的数组，目标值为7
		int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int b = 7;
		System.out.println(find2(a, b));
	}

	// 从左下角开始搜寻
	public static boolean find1(int[][] array, int target) {
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
}
