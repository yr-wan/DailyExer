package com.yrwan.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 25.输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 思路：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值
 * @author wyran
 *
 */
public class JZ25FindPath {
	public static void main(String[] args) {
		JZ25FindPath obj = new JZ25FindPath();
		TreeNode a1 = new TreeNode(10);
		TreeNode a2 = new TreeNode(5);
		TreeNode a3 = new TreeNode(12);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(7);
		a1.leftChild = a2;
		a1.rightChild = a3;
		a2.leftChild = a4;
		a2.rightChild = a5;
		ArrayList<ArrayList<Integer>> result = obj.findPath(a1, 22);
		Iterator<ArrayList<Integer>> iterator = result.iterator();
		while(iterator.hasNext()){
			Iterator<Integer> tempIterator = iterator.next().iterator();
			while(tempIterator.hasNext()){
				System.out.print(tempIterator.next() + " ");
			}
			System.out.println();
		}
	}

	ArrayList<ArrayList<Integer>> resultlist = new ArrayList<>();
	ArrayList<Integer> path = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		if (root == null) {
			return resultlist;
		}
		path.add(root.data);
		target -= root.data;

		if (target == 0 && root.leftChild == null && root.rightChild == null) {
			resultlist.add(new ArrayList<>(path));
		} else {
			findPath(root.leftChild, target);
			findPath(root.rightChild, target);
		}
		path.remove(path.size() - 1);
		return resultlist;
	}
}
