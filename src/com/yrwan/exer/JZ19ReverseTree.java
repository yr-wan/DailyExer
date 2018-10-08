package com.yrwan.exer;

import java.util.Stack;

/**
 * 19.操作给定的二叉树，将其变换为源二叉树的镜像。 思路：使用递归或非递归方式交换每个节点的左右子树位置。
 * 
 * @author wyran
 *
 */
public class JZ19ReverseTree {
	// 递归
	public static void reverseTree(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return;
		}
		TreeNode temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
		if (root.leftChild != null) {
			reverseTree(root.leftChild);
		}
		if (root.rightChild != null) {
			reverseTree(root.rightChild);
		}
	}

	// 非递归
	public void reverseTree2(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				TreeNode temp = root.leftChild;
				root.leftChild = root.rightChild;
				root.rightChild = temp;
				stack.push(root);
				root = root.leftChild;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.rightChild;
			}
		}
	}
}
