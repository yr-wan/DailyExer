package com.yrwan.exer;

public class TreeNode {
	public int data;// 节点数据
	public TreeNode leftChild;// 左子节点
	public TreeNode rightChild;// 右子节点
	public TreeNode next;// 指向父节点（为了JZ58用）
	
	public TreeNode(int data) {
		this.data = data;
	}
}