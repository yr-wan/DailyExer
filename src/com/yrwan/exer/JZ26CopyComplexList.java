package com.yrwan.exer;
/**
 * 26.输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点（复制后的节点）。
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