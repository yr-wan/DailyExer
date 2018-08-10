package com.yrwan13.java;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Test;

public class TestListIterator {
	// ������ListIteratorʵ���������
	@Test
	public void testArrayList3() {
		LinkedList<Object> list = new LinkedList<Object>();
		list.add(123);	
		list.add(456);
		list.add("AA");
		list.add("BB");
		list.add("CC");
		System.out.println(list);

		System.out.println(list.getFirst());
		
		System.out.println(list.getLast());
		list.removeLast();
		System.out.println(list.getLast());
		System.out.println(list);
		System.out.println();

		ListIterator<Object> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next();
		}
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

	}
}
