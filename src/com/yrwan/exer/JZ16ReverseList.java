package com.yrwan.exer;

/**
 * 6.输入一个链表，反转链表后，输出链表的所有元素。 
 * 扩展题：输出反转后链表的头节点，定义三个指针反向输出。 思路：定义两个指针，反向输出
 * @author wyran
 *
 */
public class JZ16ReverseList {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		Node newHead = reverseList(node1);
		while (newHead != null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}

	public static Node reverseList(Node head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		Node pre = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}
}
