package com.yrwan13.java;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * 1.�洢����ķ�ʽ��������(����+����)  �ڼ���(����)
 * 2.����洢���ݵı׶ˣ��ٳ��ȳ�ʼ���󲻿ɱ䣻������������Ԫ�ظ���û���ֳɵķ������á�
 * 3.����Collection�ӿ� ��
 * 		|------List�ӿڣ��洢����ģ������ظ���Ԫ��
 * 				|------ArrayList����Ҫ��ʵ���ࣩ
 * 	 			|------LinkedList����������Ƶ���Ĳ��롢ɾ��������
 * 	 			|------Vector�����ϵ�ʵ���ࡢ�̰߳�ȫ�ģ���Ч��Ҫ����ArrayList��
 * 		|------Set�ӿڣ��洢����ģ������ظ���Ԫ�ء�
 * 				|------HashSet����Ҫ��ʵ���ࣩ
 * 				|------LinkedHashSet(��HashSet�����࣬�����Ǳ�������Ԫ��ʱ���ǰ�����ӽ�ȥ��˳��ʵ�ֵģ�Ƶ���ı��������ٵ���ӡ������������ѡ���)
 * 				|------TreeSet�����԰�����ӽ������е�Ԫ�ص�ָ�����Խ�������
 * 
 */
public class TestCollection {
	@Test
	public void testCollection3() {
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add("BB");
		Collection<Object> coll1 = Arrays.asList(123, "AA");

		// 10.removeAll(Collection coll):ɾ����ǰ���������β�coll�еĹ�ͬԪ��
		coll.removeAll(coll1);
		System.out.println(coll);// [BB]

		// 11.equals(Object obj):�ж��������Ƿ���ͬ��boolean
		System.out.println(coll.equals(coll1));// false

		// 12.hashCode():���㼯���е�hashֵ
		System.out.println(coll.hashCode());

		// 13.toArray():������תΪ���� Array.asList()�ǽ�����תΪ����
		Object[] obj = coll.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);// [BB]
		}

		// 14.iterator():����һ��Iterator�ӿ�ʵ����Ķ���ʵ�ּ��ϵı���
		Iterator<Object> iterator = coll.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());// [BB]
		}

	}

	@Test
	public void testCollection2() {
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");

		// 6.contains(Object obj):�жϵ�ǰ�������Ƿ����objԪ�أ�boolean
		// �ж����ݣ�Ԫ���������equals()����
		// �������Ԫ��Ϊ�Զ�����Ķ�����Ҫ����д���Զ������equals()������
		System.out.println(coll.contains(123));//
		System.out.println(coll.contains(new Date()));// true

		// 7.containAll(Collection coll):�жϵ�ǰ�������Ƿ�����β�coll�е�����Ԫ��
		Collection<Object> coll1 = Arrays.asList(123, "AA", "BB");
		System.out.println(coll.containsAll(coll1));// true

		// 8.retainAll(Collection coll):��ǰ�������β�coll�еĹ�ͬԪ�أ����ظ���ǰ����
		coll.retainAll(coll1);
		System.out.println(coll);// [123, AA, BB]

		// 9.remove(Object obj):ɾ����ǰ�����е�Ԫ��obj��ɾ���ɹ�����true
		coll.remove(123);
		System.out.println(coll);// [AA�� BB]

		System.out.println("-----------------------");
	}

	@Test
	public void testCollection1() {
		Collection<Object> coll = new ArrayList<Object>();

		// 1.size():������Ԫ�ظ���
		System.out.println(coll.size());

		// 2.add(Objcet obj):�򼯺������Ԫ��
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		System.out.println(coll.size());// 4

		// 3.addAll(Collection coll):���β�coll�е�����Ԫ����ӵ���ǰ������
		Collection<Object> coll1 = Arrays.asList(1, 2, 3);
		coll.addAll(coll1);
		System.out.println(coll.size());// 7

		// 4.isEmpty():�жϼ����Ƿ�Ϊ��
		System.out.println(coll.isEmpty());// false

		// 5.clear():��ռ���Ԫ��
		coll.clear();
		System.out.println(coll.isEmpty());// true

		System.out.println("-----------------------");
	}
}
