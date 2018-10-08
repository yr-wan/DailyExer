package com.yrwan.exer;

/**
 * 17.���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥���������� 
 * ˼·���ݹ���ǵݹ���⣬С������ǰ�档
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
