package com.yrwan.exer;
/**
 * 39.����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * ˼·�����õݹ�����ֱ𷵻������������
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
