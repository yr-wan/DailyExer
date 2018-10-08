package com.yrwan.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 25.����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * ˼·���ȱ�����ڵ㣬Ȼ��ֱ�ݹ���������������Ŀ��ֵ�����ҵ�������Ҷ�ӽڵ㣬��ӡ·���е�ֵ
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
