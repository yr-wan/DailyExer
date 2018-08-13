package com.yrwan17.exer;

import java.util.Arrays;

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
	public static String mySort(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		String result = new String(c);
		return result;
	}

	// 4.��ȡ�����ַ����������ͬ�Ӵ���
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

	// 3.��ȡһ���ַ�������һ���ַ����г��ֵĴ�����
	public static int myCount(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			str1 = str1.substring(len + str2.length(), str1.length());
			count++;
		}
		return count;
	}

	// 2.��һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת��
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

	// 1.ģ��һ��trim������ȥ���ַ������˵Ŀո�
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
