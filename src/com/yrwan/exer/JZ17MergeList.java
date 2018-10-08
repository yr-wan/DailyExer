package com.yrwan.exer;

/**
 * 17.输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。 
 * 思路：递归与非递归求解，小数放在前面。
 * @author wyran
 *
 */
public class JZ17MergeList {
	public static Node mergeList(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		Node newHead = null;
		if (list1.data >= list2.data) {
			newHead = list2;
			newHead.next = mergeList(list1, list2.next);
		} else {
			newHead = list1;
			newHead.next = mergeList(list1.next, list2);
		}
		return newHead;
	}
}
