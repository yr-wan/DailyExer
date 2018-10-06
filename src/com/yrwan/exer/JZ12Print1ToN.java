package com.yrwan.exer;
/**
 * 打印1到最大的n位数
 * 思路：考虑大数问题，使用字符串或数组表示。
 * @author wyran
 *
 */
public class JZ12Print1ToN {
	public static void main(String[] args) {
		print1ToN(10);
	}
	
	/**
	 * 打印1到n位数的十进制数
	 * @param n 最大位数
	 */
	public static void print1ToN(int n) {
		if (n <= 0) {
			return;
		}
		int[] arr = new int[n];
		printArray(arr, 0);
	}
	
	// 递归设置每一位
	public static void printArray(int[] arr, int n) {
		// 每一位的数字
		for (int i = 0; i < 10; i++) {
			if (n != arr.length) {
				arr[n] = i;
				printArray(arr, n+1);
			} else {
				// 到达长度，开始打印
				boolean isBeginning = true;
				for (int j = 0; j < arr.length; j++) {
					// 判断首位是不是0，如果是0就跳过
					if (arr[j] == 0 && isBeginning) {
						continue;
					}
					if (arr[j] != 0 && isBeginning) {
						isBeginning = false;
					}
					if (!isBeginning) {
						System.out.print(arr[j]);
					}
				}
				System.out.println();
				return;
			}
	    }
	}

}
