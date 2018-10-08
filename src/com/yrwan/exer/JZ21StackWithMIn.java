package com.yrwan.exer;

import java.util.Stack;
/**
 * 21.����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * ˼·����������ջ��һ��������ֵ����һ������Сֵ��
 * @author wyran
 *
 */
public class JZ21StackWithMIn {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(int value) {
		stack.push(value);
		if (minStack.isEmpty()) {
			minStack.push(value);
		} else {
			if (value < minStack.peek()) {
				minStack.push(value);
			} else {
				minStack.push(minStack.peek());
			}
		}
	}

	public int pop() {
		minStack.pop();
		return stack.pop();
	}

	public int min() {
		return minStack.peek();
	}
}
