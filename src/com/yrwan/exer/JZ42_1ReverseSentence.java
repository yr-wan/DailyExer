package com.yrwan.exer;
/**
 * 42.��ת�ַ���
 * ˼·���Ƚ������ַ�����ת��Ȼ��ÿ�����ʷ�ת��
 * @author wyran
 *
 */
public class JZ42_1ReverseSentence {
	public static void main(String[] args) {
		String str = "    I am a student.   ";
		reverseSentence(str);
	}

	// ���ַ����Կո�ָ���ַ������飬�����������
	public static void reverseSentence(String str) {
		if (str.length() == 0 || str == null) {
			return;
		}
		String[] strs = str.trim().split(" ");
		for (int i = strs.length - 1; i >= 0; i--) {
			System.out.print(strs[i] + " ");
		}
	}
}
