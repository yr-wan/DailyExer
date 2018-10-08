package com.yrwan.exer;

/**
 * 15.输入一个链表，输出该链表中倒数第k个结点。 
 * 扩展题：找中间节点，使用两个指针，一个走一步，一个走两步。找到中间节点
 * 思路：定义一快一慢两个指针，快指针走K步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第K个节点。
 * 
 * @author wyran
 *
 */
public class JZ15FindKthToTail {
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
		System.out.println(findKthToTail(node1, 2).data);
	}

	public static Node findKthToTail(Node head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		Node leftNode = head;
		Node rightNode = head;
		for (int i = 0; i < k - 1; i++) {
			if (rightNode.next == null) {
				return null;
			}
			rightNode = rightNode.next;
		}
		while (rightNode.next != null) {
			leftNode = leftNode.next;
			rightNode = rightNode.next;
		}
		return leftNode;
	}

}
