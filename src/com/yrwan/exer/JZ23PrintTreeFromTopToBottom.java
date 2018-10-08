package com.yrwan.exer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
/**
 * 23.从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：层序遍历，利用队列（链表）辅助实现。
 * @author wyran
 *
 */
public class JZ23PrintTreeFromTopToBottom {
	public static ArrayList<TreeNode> printTreeFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<>();
		if (root == null) {
			return null;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		list.add(root);
		while (!queue.isEmpty()) {
			TreeNode currrnt = queue.poll();
			list.add(currrnt);
			if (currrnt.leftChild != null) {
				queue.offer(currrnt.leftChild);
			}
			if (currrnt.rightChild != null) {
				queue.offer(currrnt.rightChild);
			}
		}
		return list;
	}
}
