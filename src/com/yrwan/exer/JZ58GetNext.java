package com.yrwan.exer;

/**
 * 58.����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * ˼·�����ڵ��Һ��Ӵ��ڣ�������һ��ָ��Ӹýڵ���Һ��ӳ�����
 * һֱ����ָ�����ӽ���ָ���ҵ���Ҷ�ӽڵ㼴Ϊ��һ���ڵ㣻���ڵ㲻�Ǹ��ڵ㡣
 * ����ýڵ����丸�ڵ�����ӣ��򷵻ظ��ڵ㣻����������ϱ����丸�ڵ�ĸ��ڵ㣬�ظ�֮ǰ���жϣ����ؽ��
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
	    
	    
	    // �˴���next��ָ�򸸽ڵ㣬����δ���䶨��
	    while (pNode.next != null) {
	        // �ҵ�һ����ǰ�ڵ��Ǹ��ڵ����ӵĽڵ�
	        if (pNode.next.left == pNode)
	            return pNode.next;
	        pNode = pNode.next;
	    }
	    return null;
	}
}
