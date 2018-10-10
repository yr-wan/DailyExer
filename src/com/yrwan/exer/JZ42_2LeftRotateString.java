package com.yrwan.exer;
/**
 * 42.1对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 * 思路：拼接或反转三次字符串
 * @author wyran
 *
 */
public class JZ42_2LeftRotateString {
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(leftRotateString(str, 2));
	}

	public static String leftRotateString(String str, int index) {
		if (str == null || str.length() == 0) {
			return null;
		}
		StringBuffer sb1 = new StringBuffer();
		sb1.append(str.substring(0, index));
		sb1 = sb1.reverse();
		StringBuffer sb2 = new StringBuffer();
		sb2.append(str.substring(index, str.length()));
		sb2 = sb2.reverse();

		StringBuffer sb3 = new StringBuffer();
		sb3 = sb1.append(sb2);
		return sb3.reverse().toString();
	}
}
