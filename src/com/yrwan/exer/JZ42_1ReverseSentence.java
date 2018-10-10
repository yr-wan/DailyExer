package com.yrwan.exer;
/**
 * 42.翻转字符串
 * 思路：先将整个字符串翻转，然后将每个单词翻转。
 * @author wyran
 *
 */
public class JZ42_1ReverseSentence {
	public static void main(String[] args) {
		String str = "    I am a student.   ";
		reverseSentence(str);
	}

	// 将字符串以空格分割成字符串数组，反向输出即可
	public static void reverseSentence(String str) {
		if (str.length() == 0 || str == null) {
			return;
		}
		String[] strs = str.trim().split(" ");
		for (int i = strs.length - 1; i >= 0; i--) {
			System.out.print(strs[i] + " ");
		}
	}
}
