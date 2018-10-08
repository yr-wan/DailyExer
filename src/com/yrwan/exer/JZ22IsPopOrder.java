package com.yrwan.exer;

import java.util.Stack;

/**
 * 22.���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򣬼���ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * ˼·����ջ��ѹ�뵯��Ԫ�أ�������ջ��
 * 
 * @author wyran
 *
 */
public class JZ22IsPopOrder {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 4, 5, 3, 2, 1 };
		System.out.println(isPopOrder(a, b));
	}

	public static boolean isPopOrder(int[] a, int[] b) {
		if (a == null || b == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			stack.push(a[i]);
			while (!stack.isEmpty() && stack.peek() == b[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
	}
}
