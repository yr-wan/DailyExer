package com.yrwan17.java;

/*
 * int length():�����ַ�������
 * char charAt(int index):�����ַ�����ָ��λ�õ��ַ�����0��ʼ��
 * boolean equals(Object anObject):���������ַ����Ƿ����
 * int compareTo(String anotherString):�Ƚ������ַ����Ƿ���ȣ�����(ascii�� �� ���Ȳ�)
 * int indexOf(String s):����s���ַ����״γ���λ�ã����޷���-1
 * int indexOf(String s ,int startpoint):����s���ַ�����startpoint֮���״γ���λ�ã����޷���-1
 * int lastIndexOf(String s):����s���ַ������һ�γ���λ�ã����޷���-1
 * int lastIndexOf(String s ,int startpoint):����s���ַ�����startpoint֮ǰ���һ�γ���λ�ã����޷���-1
 * boolean startsWith(String prefix):�ж��ַ����Ƿ���prefix��ʼ
 * boolean endsWith(String suffix):�ж��ַ����Ƿ���suffix����
 * boolean regionMatches(int firstStart,String other,int otherStart ,int length):
 * �жϵ�ǰ�ַ�����firstStart��ʼ���Ӵ�other��otherStart��ʼ��length���ȵ��ַ����Ƿ�equals
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
