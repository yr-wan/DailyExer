package com.yrwan17.exer;

import java.util.Arrays;

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
	public static String mySort(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		String result = new String(c);
		return result;
	}

	// 4.获取两个字符串中最大相同子串。
	public static String myFind(String str1, String str2) {
		String max = (str1.length()>=str2.length())?str1:str2;
		String mix = (str1.length()>=str2.length())?str2:str1;
		String temp = "0";
		String temp2 = "0";
		int len = mix.length();
		for (int i = 0; i < len; i++) {
			for (int j = len - 1; i <= j && j >= 0; j--) {
				temp = mix.substring(i, j + 1);
				if (max.contains(temp) && (temp2.length() < temp.length())) {
					temp2 = temp;
				}
			}
		}
		return temp2;
	}

	// 3.获取一个字符串在另一个字符串中出现的次数。
	public static int myCount(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			str1 = str1.substring(len + str2.length(), str1.length());
			count++;
		}
		return count;
	}

	// 2.将一个字符串进行反转。将字符串中指定部分进行反转。
	public static String myReverse(String str, int start, int end) {
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
	public static String myTrim(String str) {
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
		String str1 = "ahaasdahgafshe";
		String str2 = "aa323112sdahqw";
		System.out.println(myFind(str1, str2));
	}
}
