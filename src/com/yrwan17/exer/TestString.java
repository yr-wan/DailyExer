package com.yrwan17.exer;

import org.junit.Test;

/*
 * 1.ģ��һ��trim������ȥ���ַ������˵Ŀո�
 * 2.��һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת�����罫��abcdefg����תΪ��abfedcg��
 * 3.��ȡһ���ַ�������һ���ַ����г��ֵĴ�����
 * ���磺��ȡ�� ab���� ��abkkcadkabkebfkabkskab���г��ֵĴ���
 * 4.��ȡ�����ַ����������ͬ�Ӵ������磺
 * str1 = "abcwerthelloyuiodef��;str2 = "cvhellobnm"
 * ��ʾ�����̵��Ǹ������г������εݼ����Ӵ���ϳ��Ĵ��Ƚϡ�
 * 5.���ַ������ַ�������Ȼ˳������
 * ��ʾ��
 * 1���ַ�������ַ����顣
 * 2������������ѡ��ð�ݣ�Arrays.sort();
 * 3�����������������ַ�����
 */
public class TestString {
	// 5.���ַ������ַ�������Ȼ˳������
	public String test5() {
		return "";
	}

	// 4.��ȡ�����ַ����������ͬ�Ӵ���
	public String test4() {
		return "";
	}

	// ��ȡһ���ַ�������һ���ַ����г��ֵĴ�����
	public int test3() {
		return 0;
	}

	// 2.��һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת��
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

	// 1.ģ��һ��trim������ȥ���ַ������˵Ŀո�
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
