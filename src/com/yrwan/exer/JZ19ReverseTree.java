package com.yrwan.exer;

import java.util.Stack;

/**
 * 19.���������Ķ�����������任ΪԴ�������ľ��� ˼·��ʹ�õݹ��ǵݹ鷽ʽ����ÿ���ڵ����������λ�á�
 * 
 * @author wyran
 *
 */
public class JZ19ReverseTree {
	// �ݹ�
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

	// �ǵݹ�
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
