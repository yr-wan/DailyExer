package com.yrwan.exer;
/**
 * 18.�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * ˼·�������ڵ���ȣ����õݹ�Ƚ����ǵ������Ƿ���ȣ������ڵ㲻��ȣ������õݹ�ֱ������������в��ҡ�
 * @author wyran
 *
 */
public class JZ18HasSubTree {
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(8);
		TreeNode a2 = new TreeNode(8);
		TreeNode a3 = new TreeNode(7);
		TreeNode a4 = new TreeNode(9);
		TreeNode a5 = new TreeNode(2);
		TreeNode a6 = new TreeNode(4);
		TreeNode a7 = new TreeNode(7);
		a1.leftChild = a2;
		a1.rightChild = a3;
		a2.leftChild = a4;
		a2.rightChild = a5;
		a5.leftChild = a6;
		a5.rightChild = a7;
		TreeNode b1 = new TreeNode(8);
		TreeNode b2 = new TreeNode(9);
		TreeNode b3 = new TreeNode(2);
		b1.leftChild = b2;
		b1.rightChild = b3;
		System.out.println(hasSubTree(a1, b1));
	}

	public static boolean hasSubTree(TreeNode t1, TreeNode t2) {
		boolean result = false;
		if (t1 != null && t2 != null) {
			if (t1.data == t2.data) {
				result = doesAHavaB(t1, t2);
			}
			if (!result) {
				result = hasSubTree(t1.leftChild, t2) || hasSubTree(t1.rightChild, t2);
			}
		}
		return result;
	}

	public static boolean doesAHavaB(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		if (t1 == null) {
			return false;
		}
		if (t1.data != t2.data) {
			return false;
		}
		return doesAHavaB(t1.leftChild, t2.leftChild) && doesAHavaB(t1.rightChild, t2.rightChild);
	}
}
