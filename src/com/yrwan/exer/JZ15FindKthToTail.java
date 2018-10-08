package com.yrwan.exer;

/**
 * 15.����һ����������������е�����k����㡣 
 * ��չ�⣺���м�ڵ㣬ʹ������ָ�룬һ����һ����һ�����������ҵ��м�ڵ�
 * ˼·������һ��һ������ָ�룬��ָ����K����Ȼ����ָ�뿪ʼ�ߣ���ָ�뵽βʱ����ָ����ҵ��˵�����K���ڵ㡣
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
