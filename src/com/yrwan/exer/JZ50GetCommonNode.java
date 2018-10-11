package com.yrwan.exer;
/**
 * 50.�����������ڵ����͹�������
 * @author wyran
 *
 */
public class JZ50GetCommonNode {
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
		System.out.println(findLCA(a1, 9, 4).data);
		
	}
	// ����������
	public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode node1,TreeNode node2){
		if(root == null || node1 == null || node2 == null){
			return null;
		}
		if((root.data - node1.data)*(root.data - node2.data) < 0){
			return root;
		}else{
			TreeNode newNode = (root.data>node1.data)? root.leftChild:root.rightChild;
			return getLowestCommonAncestor(newNode, node1, node2);
		}
	}
	
	public static TreeNode findLCA(TreeNode root, int node1, int node2) {
		if (root == null)
			return null;
		// �ҵ������ڵ��е�һ���ͷ���
		if (root.data == node1 || root.data == node2) {
			return root;
		}
		// �ֱ��������������������ڵ�
		TreeNode left = findLCA(root.leftChild, node1, node2);
		TreeNode right = findLCA(root.rightChild, node1, node2);
		if (left != null && right != null) {
			// ��ʱ˵���������ڵ�϶��Ƿֱ������������У���ǰ�ڵ��ΪLCA
			return root;
		}
		return left != null ? left : right;
	}
}