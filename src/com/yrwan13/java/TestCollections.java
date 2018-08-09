package com.yrwan13.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
 * ����Collection ��  Map��Collections�����ࣺ
 */
public class TestCollections {
	
	@Test
	public void testCollections2(){
		/*
		 * Object max(Collection)������Ԫ�ص���Ȼ˳�򣬷��ظ��������е����Ԫ��
		 * Object max(Collection��Comparator)������ Comparator ָ����˳�򣬷��ظ��������е����Ԫ��
		 * Object min(Collection)������Ԫ�ص���Ȼ˳�򣬷��ظ��������е���СԪ��
		 * Object min(Collection��Comparator)������ Comparator ָ����˳�򣬷��ظ��������е���СԪ��
		 * int frequency(Collection��Object)������ָ��������ָ��Ԫ�صĳ��ִ���
		 * void copy(List dest,List src)����src�е����ݸ��Ƶ�dest��
		 * boolean replaceAll(List list��Object oldVal��Object newVal)��ʹ����ֵ�滻 List ��������о�ֵ
		 * 
		 */
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("DD");
		list.add("BB");
		list.add("TT");
		list.add("SS");
		System.out.println(list);
		System.out.println("max:" + Collections.max(list));// ����Ԫ�ص���Ȼ˳�򣬷��ظ��������е����Ԫ��
		System.out.println("min:" + Collections.min(list));// ����Ԫ�ص���Ȼ˳�򣬷��ظ��������е���СԪ��
		System.out.println(Collections.frequency(list, "AA"));// ����ָ��������ָ��Ԫ�صĳ��ִ���
		// List<String> list1 = new ArrayList<String>();//����ʽ
		List<Object> list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		
		List<String> list2 = Collections.synchronizedList(list);//list2���̰߳�ȫ��
	}
	
	@Test
	public void testCollections1(){
		/*
		 * reverse(List)����ת List ��Ԫ�ص�˳��
		 * shuffle(List)���� List ����Ԫ�ؽ����������
		 * sort(List)������Ԫ�ص���Ȼ˳���ָ�� List ����Ԫ�ذ���������
		 * sort(List��Comparator)������ָ���� Comparator ������˳��� List ����Ԫ�ؽ�������
		 * swap(List��int�� int)����ָ�� list �����е� i ��Ԫ�غ� j ��Ԫ�ؽ��н���
		 */
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("DD");
		list.add("BB");
		list.add("TT");
		list.add("SS");
		System.out.println(list);
		Collections.reverse(list);// ��ת List ��Ԫ�ص�˳��
		System.out.println(list);
		Collections.shuffle(list);// �� List ����Ԫ�ؽ����������
		System.out.println(list);
		Collections.sort(list);// ����Ԫ�ص���Ȼ˳���ָ�� List ����Ԫ�ذ���������
		System.out.println(list);
		Collections.swap(list, 0, 1);// ��ָ�� list �����е� i ��Ԫ�غ� j ��Ԫ�ؽ��н���
		System.out.println(list);
	}
}
