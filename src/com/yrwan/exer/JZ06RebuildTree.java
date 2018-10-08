package com.yrwan.exer;

import java.util.Arrays;

import org.junit.Test;

/**输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：先找出根节点，然后利用递归方法构造二叉树
 * @author wyran
 *
 */
public class JZ06RebuildTree {
	/**
	 * 
	 * @param pre 前序遍历
	 * @param in 中序遍历
	 * @param index 根节点
	 * @return
	 */
	public static TreeNode rebuildTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
			return null;
		}
		TreeNode current = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				current.leftChild = rebuildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
				current.rightChild = rebuildTree(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
			}
		}
		return current;
	}

	public static void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.data + " ");
		}
	}
	
	@Test
	public void test() {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = rebuildTree(pre, in);
		postOrder(root);
	}
}
