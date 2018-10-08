package com.yrwan.exer;

import java.util.Stack;
/**
 * 21.定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：定义两个栈，一个存放入的值。另一个存最小值。
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
