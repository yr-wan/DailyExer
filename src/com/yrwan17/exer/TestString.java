package com.yrwan17.exer;

import org.junit.Test;

/*
 * 1.模拟一个trim方法，去除字符串两端的空格。
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 * 3.获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab”中出现的次数
 * 4.获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 * 5.对字符串中字符进行自然顺序排序。
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort();
 * 3）将排序后的数组变成字符串。
 */
public class TestString {
	// 5.对字符串中字符进行自然顺序排序。
	public String test5() {
		return "";
	}

	// 4.获取两个字符串中最大相同子串。
	public String test4() {
		return "";
	}

	// 获取一个字符串在另一个字符串中出现的次数。
	public int test3() {
		return 0;
	}

	// 2.将一个字符串进行反转。将字符串中指定部分进行反转。
	public static String test2(String str, int start, int end) {
		int len = str.length();
		char[] c = str.toCharArray();
		char[] c2 = new char[len];
		for (int i = 0; i < len; i++) {
			c2[i] = c[i];
		}
		for (int i = start; i < end; i++) {
			c2[i] = c[len - end - 1 - i];
		}
		return new String(c2);
	}

	// 1.模拟一个trim方法，去除字符串两端的空格。
	public static String test1(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end && str.charAt(start) == ' ') {
			start++;
		}
		while (start < end && str.charAt(end) == ' ') {
			end--;
		}
		return str.substring(start, end + 1);
	}

	public static void main(String[] args) {
		String str = "12345678";
		System.out.println(test2(str,0,4));
	}
}
