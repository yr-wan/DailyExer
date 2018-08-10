package com.yrwan13.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * Iterator �����ļ��ַ�ʽ
 */
public class TestIterator {
	// ��ǿforѭ��ʵ�ּ��ϵı���
	@Test
	public void test2() {
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");

		for (Object i : coll) {
			System.out.println(i);
		}
	}

	// ������Iteratorʵ�ֱ���
	@Test
	public void test1() {
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");

		Iterator<Object> i = coll.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
