package com.yrwan.exer;

/**
 * 28.输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 思路：将当前位置的字符和前一个字符位置交换，递归。
 * @author wyran
 *
 */
public class JZ28Permutation {
	public static void main(String[] args) {
		String str = "abc";
		permutation(str.toCharArray(), 0);
	}

	public static void permutation(char[] str, int i) {
		if (i >= str.length)
			return;
		if (i == str.length - 1) {
			System.out.println(String.valueOf(str));
		} else {
			for (int j = i; j < str.length; j++) {
				char temp = str[j];
				str[j] = str[i];
				str[i] = temp;

				permutation(str, i + 1);

				temp = str[j];
				str[j] = str[i];
				str[i] = temp;
			}
		}
	}
}
