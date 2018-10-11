package com.yrwan.exer;

/**
 * 58.给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路：若节点右孩子存在，则设置一个指针从该节点的右孩子出发，
 * 一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；若节点不是根节点。
 * 如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果
 * @author wyran
 *
 */
public class JZ58GetNext {
	public TreeNode GetNext(TreeNode pNode) {
	    if (pNode == null){
	    	return null;
	    }
	    if (pNode.rightChild != null) {
	        pNode = pNode.rightChild;
	        while (pNode.leftChild != null) {
	            pNode = pNode.leftChild;
	        }
	        return pNode;
	    }
	    
	    
	    // 此处是next是指向父节点，本处未对其定义
	    while (pNode.next != null) {
	        // 找第一个当前节点是父节点左孩子的节点
	        if (pNode.next.left == pNode)
	            return pNode.next;
	        pNode = pNode.next;
	    }
	    return null;
	}
}
