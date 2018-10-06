package com.yrwan.exer;

import java.util.Stack;

import org.junit.Test;

/**
 * 7.������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ˼·��һ��ջѹ��Ԫ�أ�����һ��ջ��Ϊ���壬��ջ1��Ԫ�س�ջ��ѹ��ջ2�С�
 * Ҳ���Խ�ջ1�е����һ��Ԫ��ֱ�ӳ�ջ��������ѹ��ջ2���ٳ�ջ��
 * @author wyran
 *
 */
public class JZ07QueueWithTwoStacks {
	Stack<Integer> s1 = new Stack<>();// ������
	Stack<Integer> s2 = new Stack<>();// ������
	
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
