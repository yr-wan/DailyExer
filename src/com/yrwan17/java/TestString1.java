package com.yrwan17.java;

/*
 * int length():返回字符串长度
 * char charAt(int index):返回字符串在指定位置的字符（从0开始）
 * boolean equals(Object anObject):返回两个字符串是否相等
 * int compareTo(String anotherString):比较两个字符串是否相等，返回(ascii差 或 长度差)
 * int indexOf(String s):返回s在字符串首次出现位置，如无返回-1
 * int indexOf(String s ,int startpoint):返回s在字符串在startpoint之后首次出现位置，如无返回-1
 * int lastIndexOf(String s):返回s在字符串最后一次出现位置，如无返回-1
 * int lastIndexOf(String s ,int startpoint):返回s在字符串在startpoint之前最后一次出现位置，如无返回-1
 * boolean startsWith(String prefix):判断字符串是否以prefix开始
 * boolean endsWith(String suffix):判断字符串是否以suffix结束
 * boolean regionMatches(int firstStart,String other,int otherStart ,int length):
 * 判断当前字符串从firstStart开始的子串other从otherStart开始，length长度的字符串是否equals
 */
public class TestString1 {
	public static void main(String[] args) {
		String str1 = new String("abcdefg");
		String str2 = new String("abc");
		String str3 = new String("defg");
		System.out.println(str1.length());
		System.out.println(str1.charAt(0));
		System.out.println(str1.equals(str2));
		System.out.println(str1.compareTo("abc"));
		System.out.println(str1.indexOf("b"));
		System.out.println(str1.regionMatches(3, str3, 0, 4));
	}
}
