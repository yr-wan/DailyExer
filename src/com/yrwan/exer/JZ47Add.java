package com.yrwan.exer;
/**
 * 47.写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：利用位运算
 * @author wyran
 *
 */
public class JZ47Add {
	public static int Add(int num1, int num2){
		while (num2 != 0) {
	        // 计算个位
	        int temp = num1 ^ num2;
	        // 计算进位（1+1）
	        num2 = (num1 & num2) << 1;
	        num1 = temp;
	    }
	    return num1;
	}
}
