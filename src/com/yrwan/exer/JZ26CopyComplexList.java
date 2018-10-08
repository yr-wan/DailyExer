package com.yrwan.exer;
/**
 * 26.����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * ˼·���ȸ��������next�ڵ㣬�����ƺ�Ľڵ����ԭ�ڵ��Ȼ���������Ľڵ㣬���ȡż��λ�õĽڵ㣨���ƺ�Ľڵ㣩��
 * @author wyran
 *
 */
public class JZ26CopyComplexList {
	public static ComplexNode copyComplexList(ComplexNode head){
		if(head == null){
			return null;
		}
		
		ComplexNode newHead = new ComplexNode(head.data);
		ComplexNode temp = newHead;
		while(head.next != null){
			newHead.next = new ComplexNode(head.next.data);
			if(head.other!= null){
				newHead.other = new ComplexNode(head.other.data);
			}
			head = head.next;
			newHead = newHead.next;
		}
		return temp;
	} 
}
class ComplexNode{
	int data;
	ComplexNode next;
	ComplexNode other;
	public ComplexNode() {
		super();
	}
	public ComplexNode(int data) {
		super();
		this.data = data;
	}
}