package com.yrwan17.java;

/*
 * String substring(int startpoint):���ش�startpoint��ʼ����β���Ӵ�
 * String substring(int start,int end):���ش�start��ʼ��end���Ӵ�(����ҿ�)
 * String replace(char oldChar,char newChar):������old�滻Ϊnew
 * String replaceAll(String old,String new):������old�滻Ϊnew
 * String trim():ȥ����β�Ŀո�
 * String concat(String str):���������ַ���
 * String[] split(String regex):���ַ�����regex��֣�������һ���ַ�������
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
