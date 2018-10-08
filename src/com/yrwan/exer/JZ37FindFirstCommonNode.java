package com.yrwan.exer;
/**
 * 37.输入两个链表，找出它们的第一个公共结点。
 * 思路：先求出链表长度，然后长的链表先走多出的几步，然后两个链表同时向下走去寻找相同的节点，
 * 代码量少的方法需要将两个链表遍历两次，然后从头开始相同的节点。
 * @author wyran
 *
 */
public class JZ37FindFirstCommonNode {
	// 不需要遍历链表的解法
	public static Node findFirstCommonNode2(Node pHead1, Node pHead2) {
		Node p1 = pHead1;
		Node p2 = pHead2;
	    while (p1 != p2){
	        p1 = (p1 != null ? p1.next : pHead2);
	        p2 = (p2 != null ? p2.next : pHead1);
	    }
	    return p1;
	}
	
	public static Node findFirstCommonNode(Node list1, Node list2) {
		if (list1 == null || list2 == null) {
			return null;
		}
		int length1 = getListLength(list1);
		int length2 = getListLength(list2);
		int diff = length1 - length2;
		Node listLong = list1;
		Node listShort = list2;
		if (length2 > length1) {
			diff = length2 - length1;
			listLong = list2;
			listShort = list1;
		}
		for (int i = 0; i < diff; i++) {
			listLong = listLong.next;
		}
		while(listLong.next != null && listShort.next != null && listLong != listShort){
			listLong = listLong.next;
			listShort = listShort.next;
		}
		Node firstCommonNode = listLong;
		return firstCommonNode;
	}
	
	public static int getListLength(Node head){
		int i = 0;
		while(head.next!=null){
			head = head.next;
			i++;
		}
		return i;
	}
}
