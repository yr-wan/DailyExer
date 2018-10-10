package com.yrwan.exer;
/**
 * 39.输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路：利用递归遍历分别返回左右子树深度
 * @author wyran
 *
 */
public class JZ39_1TreeDepth {
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = treeDepth(root.leftChild);
		int rightDepth = treeDepth(root.rightChild);
		return Math.max(leftDepth, rightDepth)+1;
	}
}
