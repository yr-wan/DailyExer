package com.yrwan13.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * Collection�ӿ� ��
 * 		|------List�ӿڣ��洢����ģ������ظ���Ԫ��
 * 				|------ArrayList����Ҫ��ʵ���ࣩ
 * 	 			|------LinkedList����������Ƶ���Ĳ��롢ɾ��������
 * 	 			|------Vector�����ϵ�ʵ���ࡢ�̰߳�ȫ�ģ���Ч��Ҫ����ArrayList��
 * 		|------Set�ӿڣ��洢����ģ������ظ���Ԫ�ء�
 * 				|------HashSet����Ҫ��ʵ���ࣩ
 * 				|------LinkedHashSet(��HashSet�����࣬�����Ǳ�������Ԫ��ʱ���ǰ�����ӽ�ȥ��˳��ʵ�ֵģ�Ƶ���ı��������ٵ���ӡ������������ѡ���)
 * 				|------TreeSet�����԰�����ӽ������е�Ԫ�ص�ָ�����Խ�������
 */
public class TestList {

	//ArrayList:List����Ҫʵ��
	/* List��Collestion�����ӵķ���
	 * void add(int index, Object obj):����λ��index�����obj
	 * boolean addAll(int index, Collection coll):����λ��index�����coll������Ԫ��
	 * Object remove(int index):ɾ��ָ������index��Ԫ��
	 * Object set(int index, Object obj):�޸�ָ������index��Ԫ��Ϊobj
	 * Object get(int index):��ȡָ������index��Ԫ��
	 * 
	 * int indexOf(Object obj):����obj�״γ���ʱ��λ�ã�û�з���-1
	 * int lastIndexOf(Object obj):����obj������ʱ��λ�ã�û�з���-1
	 * List subList(int fromIndex, int toIndex):���ش�fromIndex��toIndex����ҿ�����List
	 * 
	 * ��add(Object obj)
	 * ɾremove(int index)��remove(Object obj)
	 * ��set(int index, Object obj)
	 * ��get(int index)
	 * ��add(int index, Object obj)
	 * ����size()
	 */
	@Test
	public void testArrayList2() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("GG");
		list.add("AA");
		System.out.println(list);

		System.out.println(list.indexOf("AA"));
		System.out.println(list.lastIndexOf("AA"));

		List subList = list.subList(1, 3);
		System.out.println(subList);

	}

	@Test
	public void testArrayList1() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("GG");
		System.out.println(list);

		list.add(0, 555);// ����λ��index�����obj
		System.out.println(list);

		System.out.println(list.get(1));// ��ȡָ������index��Ԫ��

		list.remove(0);// ɾ��ָ������index��Ԫ��
		System.out.println(list);

		list.set(0, 111);// �޸�ָ������index��Ԫ��Ϊobj
		System.out.println(list);

		System.out.println("---------------------");
	}
}
