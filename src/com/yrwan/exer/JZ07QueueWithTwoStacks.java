package com.yrwan.exer;

import java.util.Stack;

import org.junit.Test;

/**
 * 7.用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：一个栈压入元素，而另一个栈作为缓冲，将栈1的元素出栈后压入栈2中。
 * 也可以将栈1中的最后一个元素直接出栈，而不用压入栈2中再出栈。
 * @author wyran
 *
 */
public class JZ07QueueWithTwoStacks {
	Stack<Integer> s1 = new Stack<>();// 入列用
	Stack<Integer> s2 = new Stack<>();// 出列用
	
	public void offer(int value){
		s1.push(value);
	}
	
	public Integer poll(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public Integer peek(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}
	
	@Test
	public void test(){
		JZ07QueueWithTwoStacks qwts = new JZ07QueueWithTwoStacks();
		qwts.offer(1);
		System.out.println(qwts.poll());
		qwts.offer(2);
		qwts.offer(3);
		qwts.offer(4);
		System.out.println(qwts.peek());
		System.out.print(qwts.poll());
		System.out.print(qwts.poll());
		System.out.print(qwts.poll());
	}
}
