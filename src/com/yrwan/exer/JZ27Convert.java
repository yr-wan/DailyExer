package com.yrwan.exer;
/**
 * 27.输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
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
		// 1、将左子树构造成双链表，并返回该链表头结点left
		TreeNode left = convert(root.leftChild);
		// 2、定位到左子树链表的最后一个节点（左子树最右边的节点）
		TreeNode temp = left;
		while (temp != null && temp.rightChild != null) {
			temp = temp.rightChild;// 最终temp为左子树最右边的节点
		}
		// 3、如果左子树链表不为空，将当前root追加到左子树链表后
		if (left != null) {
			temp.rightChild = root;
			root.leftChild = temp;
		}
		// 4、将右子树构造成双链表，并返回该链表的头结点right
		TreeNode right = convert(root.rightChild);
		// 5、如果右子树链表不为空，将右子树链表追加到当前root后
		if (right != null) {
			right.leftChild = root;
			root.rightChild = right;
		}
		return left != null ? left : root;// 根据左子树链表是否为空返回整个双向链表的头指针。
	}
}
