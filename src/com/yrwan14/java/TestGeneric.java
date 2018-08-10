package com.yrwan14.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/*
 * ���͵�ʹ��
 * 1.�����е�ʹ��
 * 2.�Զ��巺�͡����ͽӿڡ����ͷ���
 * 3.������̳еĹ�ϵ:��A����B�����࣬��List<A>����List<B>���ӽӿ�
 * 4.ͨ���:<?><? extends A><? super A>
 */
public class TestGeneric {
	@Test
	public void printCollection(Collection c) {
		Iterator i = c.iterator();
		for (int k = 0; k < c.size(); k++) {
			System.out.println(i.next());
		}
	}
	@Test
	public void printCollection1(Collection<Object> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}

	@Test
	public void test4() {
		TestOrder<String> order = new TestOrder<String>();
		String t = order.getT();
		System.out.println(t);
	}

	@Test
	public void test3() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("AA", 98);
		map.put("DD", 56);
		map.put("BB", 82);

		Set<Entry<String, Integer>> entry = map.entrySet();
		Iterator<Entry<String, Integer>> it = entry.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// 2.ʹ�÷���
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(77);
		list.add(89);
		list.add(59);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// 1.δʹ�÷���
	@Test
	public void test1() {
		List list = new ArrayList();
		list.add(77);
		list.add(89);
		list.add(59);
		list.add("AA");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((Integer) list.get(i));// ClassCastException
		}
	}
}
