package com.yrwan13.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * Iterator 遍历的几种方式
 */
public class TestIterator {
	// 增强for循环实现集合的遍历
	@Test
	public void test2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");

		for (Object i : coll) {
			System.out.println(i);
		}
	}

	// 迭代器Iterator实现遍历
	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");

		Iterator i = coll.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
