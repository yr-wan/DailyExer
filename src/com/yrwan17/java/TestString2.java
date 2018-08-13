package com.yrwan17.java;

/*
 * String substring(int startpoint):返回从startpoint开始到结尾的子串
 * String substring(int start,int end):返回从start开始到end的子串(左闭右开)
 * String replace(char oldChar,char newChar):将所有old替换为new
 * String replaceAll(String old,String new):将所有old替换为new
 * String trim():去除收尾的空格
 * String concat(String str):连接两个字符串
 * String[] split(String regex):将字符串按regex拆分，并返回一个字符串数组
 */
public class TestString2 {
	public static void main(String[] args) {
		String str1 = new String("abcdefgc");
		
		System.out.println(str1.substring(2));
		System.out.println(str1.substring(2,5));
		System.out.println(str1.replace('c', 'x'));
		
		String str2 = new String("   ab  cd   ");
		String str3 =str2.trim();
		System.out.println("---" + str2 + "---");
		System.out.println("---" + str3 + "---");
		
		System.out.println(str1.concat("xyz"));
		
		String str4 = new String("a-*gr-d*gr");
		String[] str5 = str4.split("-");
		for (String string : str5) {
			System.out.println(string);
		}
	}
}
