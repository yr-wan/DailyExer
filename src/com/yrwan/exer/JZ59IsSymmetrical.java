package com.yrwan.exer;
/**
 * 59.��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * ˼·�����õݹ�����жϣ��������������ӵ������������Һ��������������Һ��ӵ��������������ӣ�
 * �������������ڵ��ֵ��ȣ����ǶԳƵġ�
 * @author wyran
 *
 */
public class JZ59IsSymmetrical {
	public boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null)
			return true;
		return isCommon(pRoot.leftChild, pRoot.rightChild);
	}

	public boolean isCommon(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null)
			return true;

		if (leftNode != null && rightNode != null)
			return leftNode.data == rightNode.data && isCommon(leftNode.leftChild, rightNode.rightChild)
					&& isCommon(leftNode.rightChild, rightNode.leftChild);
		return false;
	}
}
