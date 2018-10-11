package com.yrwan.exer;
/**
 * 46.求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 * 思路：利用递归以及&&的短路原理（返回值类型为Boolean）
 * @author wyran
 *
 */
public class JZ46Sum_Solution {
	public static void main(String[] args) {
		System.out.println(sum_Solution(3));
        System.out.println(sum_Solution2(3));
    }
	// 利用递归以及&&的短路原理
	public static int sum_Solution(int n){ 
		int sum = n;
		@SuppressWarnings("unused")
		boolean result = (n > 0) && ((sum += sum_Solution(n-1)) > 0);
	    return sum;
	}
	// 利用try-catch实现
	
	public static int sum_Solution2(int n) {
		try {
			@SuppressWarnings("unused")
			int rt = 1 / n;
			return n + sum_Solution2(n - 1);
		} catch (Exception e) {
		}
		return 0;
	}
}
