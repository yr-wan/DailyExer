package com.yrwan.exer;
/**
 * 27.����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * ˼·������һ�������β�ڵ㣬�ݹ鴦��������������󷵻������ͷ�ڵ�
 * @author wyran
 *
 */
public class JZ27Convert {
	public static TreeNode convert(TreeNode root){
		if (root == null) {
			return null;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return root;
		}
		// 1���������������˫���������ظ�����ͷ���left
		TreeNode left = convert(root.leftChild);
		// 2����λ����������������һ���ڵ㣨���������ұߵĽڵ㣩
		TreeNode temp = left;
		while (temp != null && temp.rightChild != null) {
			temp = temp.rightChild;// ����tempΪ���������ұߵĽڵ�
		}
		// 3���������������Ϊ�գ�����ǰroot׷�ӵ������������
		if (left != null) {
			temp.rightChild = root;
			root.leftChild = temp;
		}
		// 4���������������˫���������ظ������ͷ���right
		TreeNode right = convert(root.rightChild);
		// 5���������������Ϊ�գ�������������׷�ӵ���ǰroot��
		if (right != null) {
			right.leftChild = root;
			root.rightChild = right;
		}
		return left != null ? left : root;// ���������������Ƿ�Ϊ�շ�������˫�������ͷָ�롣
	}
}
