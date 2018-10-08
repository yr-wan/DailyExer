package com.yrwan.exer;
/**
 * O(1)ʱ��ɾ������ڵ�
 * ˼·����Ҫɾ���ڵ����һ���ڵ��ֵ����Ҫɾ���Ľڵ㣬Ȼ��ָ������һ���ڵ�
 * @author wyran
 *
 */
public class JZ13deleteNote {
	public static void main(String[] args) {

	}

	public static void deleteNode(Node head, Node toBeDelete) {
		if (head == null || toBeDelete == null) {
			return;
		}
		if (head == toBeDelete) {
			head = head.next;
		}
		if (toBeDelete.next == null) {
			Node parent = head;
			while (parent.next.next != null) {
				parent = parent.next;
			}
			parent.next = null;
		} else {
			toBeDelete.data = toBeDelete.next.data;
			toBeDelete.next = toBeDelete.next.next;
		}
	}
}
