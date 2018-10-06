package com.yrwan.exer;

import java.util.Arrays;

import org.junit.Test;

/**����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * ˼·�����ҳ����ڵ㣬Ȼ�����õݹ鷽�����������
 * @author wyran
 *
 */
public class JZ06RebuildTree {
	/**
	 * 
	 * @param pre ǰ�����
	 * @param in �������
	 * @param index ���ڵ�
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

class TreeNode {
	public int data;// �ڵ�����
	public TreeNode leftChild;// ���ӽڵ�
	public TreeNode rightChild;// ���ӽڵ�

	public TreeNode(int data) {
		this.data = data;
	}
}