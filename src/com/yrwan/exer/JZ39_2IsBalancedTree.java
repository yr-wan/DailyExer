package com.yrwan.exer;
/**
 * 39.2输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路：平衡因子的绝对值<=1
 * @author wyran
 *
 */
public class JZ39_2IsBalancedTree {
	public boolean isBalancedTree(TreeNode root){
		if (root == null)
	        return true;
	    int left = treeDepth(root.leftChild);
	    int right = treeDepth(root.rightChild);
	    int diff = left - right;
	    if (diff > -1 && diff > 1) {
	        return false;
	    }
	    return isBalancedTree(root.leftChild)&&isBalancedTree(root.rightChild);
	}
	
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = treeDepth(root.leftChild);
		int rightDepth = treeDepth(root.rightChild);
		return Math.max(leftDepth, rightDepth)+1;
	}
}
