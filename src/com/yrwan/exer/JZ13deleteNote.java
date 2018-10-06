package com.yrwan.exer;
/**
 * O(1)时间删除链表节点
 * 思路：将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点
 * @author wyran
 *
 */
public class JZ13deleteNote {
	public static void main(String[] args) {
		
	}
	public static void deleteNode(Node head,Node toBeDelete){
		if (head == null || toBeDelete == null) {
			return;
		}
		if(head == toBeDelete){
			head = head.next;
		}
		if(toBeDelete.next == null){
			Node parent = head;
            while (parent.next.next != null) {
            	parent = parent.next;
            }
            parent.next = null;
		}else{
			toBeDelete.data = toBeDelete.next.data;
			toBeDelete.next = toBeDelete.next.next;
		}
	}
}
class Node{
	int data;
	Node next;
}